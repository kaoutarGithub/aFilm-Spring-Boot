package com.nttdata.aflamiSpringBoot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.aflamiSpringBoot.entity.Genre;
import com.nttdata.aflamiSpringBoot.service.GenreService;

@Controller
@RequestMapping("genre")
public class GenreController {
	GenreService genreService;

	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}

	@GetMapping
	public String index(@RequestParam(value = "filter", required = false) String filter, Model model) {
		if (filter == null)
			model.addAttribute("list", genreService.getList());
		else {
			model.addAttribute("filter", filter);
			model.addAttribute("list", genreService.getFilteredList(filter));
		}
		return "genre/index";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		genreService.delete(id);
		return "redirect:/genre";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("genre", new Genre());
		return "genre/form";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("genre", genreService.getGenre(id));
		return "genre/form";
	}

	@PostMapping(value = "/save")
	public String save(Genre genre) {
		genreService.save(genre);
		return "redirect:/genre";
	}

}
