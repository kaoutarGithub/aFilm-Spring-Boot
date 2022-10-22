package com.nttdata.aflamiSpringBoot.controller;

import java.io.IOException;
import java.util.UUID;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.nttdata.aflamiSpringBoot.entity.Media;
import com.nttdata.aflamiSpringBoot.service.FilmService;
import com.nttdata.aflamiSpringBoot.service.MediaService;
import com.nttdata.aflamiSpringBoot.utils.FileUtils;

@Controller
@RequestMapping("/media")

public class MediaController {
	MediaService mediaService;
	FilmService filmService;
	private final String UPLOAD_DIR = "/src/main/resources/static/thumbnail/";
	
	public MediaController(MediaService mediaService, FilmService filmService) {
		// TODO Auto-generated constructor stub
		this.mediaService = mediaService;
		this.filmService = filmService;
	}
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("mediaList", mediaService.getList());
		return "media/index";
	}
	
	@GetMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("media", new Media());
		model.addAttribute("films",filmService.getList());
		return "media/form";
	}
	
	@GetMapping(value = "/update/{id}")
	public String add(@PathVariable Long id,Model model) {
		model.addAttribute("media", mediaService.getById(id));
		model.addAttribute("films",filmService.getList());
		return "media/form";
	}
	
	@PostMapping(value = "save")
	public String save(@RequestParam("file") MultipartFile file,Media media,Model model) {
		if (!file.isEmpty()) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			fileName = UUID.randomUUID().toString() + fileName;
			String dest = UPLOAD_DIR;
			try {
				FileUtils.saveFile(dest, fileName, file);
				media.setMedia("/thumbnail/" + fileName);
				model.addAttribute("media", media);
			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mediaService.save(media);
		return "redirect:/media";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		mediaService.delete(id);
		return "redirect:/media";
	}

}
