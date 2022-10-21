package com.nttdata.aflamiSpringBoot.controller;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nttdata.aflamiSpringBoot.entity.Film;
import com.nttdata.aflamiSpringBoot.enums.TypePersonne;
import com.nttdata.aflamiSpringBoot.service.FilmService;
import com.nttdata.aflamiSpringBoot.service.GenreService;
import com.nttdata.aflamiSpringBoot.service.NationaliteService;
import com.nttdata.aflamiSpringBoot.service.PersonneService;
import com.nttdata.aflamiSpringBoot.utils.FileUtils;

@Controller
@RequestMapping("/film")
public class FilmController {
	FilmService filmService;
	GenreService genreService;
	NationaliteService nationaliteService;
	PersonneService personneService;
	private final String UPLOAD_DIRR = "/src/main/resources/static/MediaFilm/";

	public FilmController(FilmService filmService, 
			GenreService genreService, 
			NationaliteService nationaliteService,
			PersonneService personneService) {
		this.filmService = filmService;
		this.genreService=genreService;
		this.nationaliteService=nationaliteService;
		this.personneService=personneService;
	}

	@GetMapping
	public String index(Model model) {
		model.addAttribute("filmList", filmService.getList());
		return "film/index";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("film", new Film());
		model.addAttribute("genres",genreService.getList());
		model.addAttribute("nationalites",nationaliteService.getList());
		model.addAttribute("personnes",personneService.getList().stream()
				.filter(f->f.getTypePersonne()==TypePersonne.REALISATEUR)
				.collect(Collectors.toList()));
		return "film/form";
	}
	@GetMapping(value = "/update/{id}")
	public String add(@PathVariable Long id,Model model) {
		model.addAttribute("film", filmService.getOne(id));
		model.addAttribute("genres",genreService.getList());
		model.addAttribute("nationalites",nationaliteService.getList());
		model.addAttribute("personnes",personneService.getList().stream()
				.filter(f->f.getTypePersonne()==TypePersonne.REALISATEUR)
				.collect(Collectors.toList()));
		return "film/form";
	}
	@PostMapping(value = "/save")
	public String save(@RequestParam("file") MultipartFile file,Film film) {
		if(!file.isEmpty()) {
			String fileName=StringUtils.cleanPath(file.getOriginalFilename());
			fileName=UUID.randomUUID().toString()+fileName;
			String dest=UPLOAD_DIRR;
			try {
				FileUtils.saveFile(dest, fileName, file);
				film.setPhoto("/MediaFilm/"+fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		filmService.save(film);
		return "redirect:/film";
	}
	
	
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		filmService.delete(id);
		return "redirect:/film";
	}
	
	@GetMapping(value = "/details")
	public String dds() {
		return "film/details";
	}

}
