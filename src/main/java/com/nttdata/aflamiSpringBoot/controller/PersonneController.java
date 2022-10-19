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

import com.nttdata.aflamiSpringBoot.entity.Personne;
import com.nttdata.aflamiSpringBoot.enums.TypePersonne;
import com.nttdata.aflamiSpringBoot.service.NationaliteService;
import com.nttdata.aflamiSpringBoot.service.PersonneService;
import com.nttdata.aflamiSpringBoot.utils.FileUtils;

@Controller
@RequestMapping("personne")
public class PersonneController {
	PersonneService personneService;
	NationaliteService nationaliteService;
    private final String UPLOAD_DIR = "/src/main/resources/static/thumbnail/";

	public PersonneController(PersonneService personneService, NationaliteService nationaliteService) {
		this.personneService = personneService;
		this.nationaliteService = nationaliteService;
	}

	@GetMapping
	public String index(Model model) {
		model.addAttribute("list", personneService.getList());
		return "personne/index";
	}

	@GetMapping(value = "add")
	public String add(Model model) {
		model.addAttribute("personne", new Personne());
		model.addAttribute("nationalites",nationaliteService.getList());
		return "personne/form";
	}

	@GetMapping(value = "update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("personne", personneService.getPersonne(id));
		model.addAttribute("nationalites",nationaliteService.getList());
		return "personne/form";
	}
	@PostMapping(value = "save")
	public String save(@RequestParam("file") MultipartFile file,Personne personne) {
		if(!file.isEmpty()) {
			String fileName=StringUtils.cleanPath(file.getOriginalFilename());
			fileName=UUID.randomUUID().toString()+fileName;
			String dest=UPLOAD_DIR;
			try {
				FileUtils.saveFile(dest, fileName, file);
				personne.setPhoto("/thumbnail/"+fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		personneService.save(personne);
		return "redirect:/personne";
	}
	@GetMapping(value = "delete/{id}")
	public String delete(@PathVariable Long id) {
		personneService.delete(id);
		return "redirect:/personne";
	}
	@GetMapping(value = "details/{id}")
	public String details(@PathVariable Long id,Model model) {
		Personne personne=personneService.getPersonne(id);
		model.addAttribute("personne",personne);
		if(personne.getTypePersonne()==TypePersonne.REALISATEUR)
			model.addAttribute("realiseList",personneService.getFilmsRealise(id));
		
		return "personne/details";
	}

}
