package com.nttdata.aflamiSpringBoot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.nttdata.aflamiSpringBoot.entity.Seance;
import com.nttdata.aflamiSpringBoot.service.FilmService;
import com.nttdata.aflamiSpringBoot.service.SalleService;
import com.nttdata.aflamiSpringBoot.service.SeanceService;

@Controller @RequestMapping("seance")
public class SeanceController {
	SeanceService seanceService;
	SalleService salleservice;
	FilmService filmService;
	public SeanceController(SeanceService seanceService, SalleService salleservice, FilmService filmService) {
		this.seanceService=seanceService;
		this.salleservice = salleservice;
		this.filmService = filmService;
	}
	
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute(" ",seanceService.getSeances());
		return "seance/index";
	}
	@GetMapping(value= "/add")
	public String add(Model model) {
		model.addAttribute("seance",new Seance());
        model.addAttribute("listeSalle", salleservice.getSalles());
        model.addAttribute("listeFilms", filmService.getList());
		return "seance/form";
	}
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Long id,Model model){
		model.addAttribute("seance",seanceService.getSeance(id));
		return "seance/form";
	}
	@PostMapping(value = "/save")
	public String save(Seance seance) {
		seanceService.setSeance(seance);
		return "redirect:/seance";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id) {
		seanceService.deleteSeance(id);
		return "redirect:/salle";
	}
	
	/*
	 * @GetMapping(value = "/details/{id}") public String details(@PathVariable Long
	 * id,Model model) { Seance seance=seanceService.getSeance(id);
	 * model.addAttribute("salle",seance);
	 * model.addAttribute("seances",seanceService.getSeancesBySalle(salle.getID()));
	 * return "salle/details"; }
	 */

}
