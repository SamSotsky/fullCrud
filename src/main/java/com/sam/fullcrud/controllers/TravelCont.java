package com.sam.fullcrud.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sam.fullcrud.models.Travel;
import com.sam.fullcrud.services.TravelService;



@Controller
public class TravelCont {

	@Autowired
	private TravelService travelServ;
 
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
//	============= DISPLAY===========
//	displays home page
	@GetMapping("/expenses")
	public String allExpenses(@ModelAttribute("travel")Travel travel, Model model) {
		List<Travel> travels = travelServ.allTravels();
		model.addAttribute("akali", travels);
		
		return "index.jsp";
	}
	
//	displays detail of one expense
	@RequestMapping("/expenses/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		Travel travels = travelServ.findTravel(id);
		model.addAttribute("yeet", travels);
		return "one.jsp";
	}
	
//	displays edit page
	@RequestMapping("/expenses/{id}/edit")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Travel travel = travelServ.findTravel(id);
		model.addAttribute("foot", travel);
		return "edit.jsp";
	}
	

	
	
	
//	=========ACTION TINGS====
//	url of each action TING must me the EXACT same in the form on jsp page bruv
	@PostMapping("/munkie")
	public String create(
			@Valid @ModelAttribute("travel") Travel travel,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "index.jsp";
		}else {
		travelServ.createTravel(travel);
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value="/expenses/{id}/edit/edited", method=RequestMethod.PUT)
	public String edited(@Valid @ModelAttribute("travel") Travel travel, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		Travel editExpense = travelServ.updateTravel(travel);
		travelServ.createTravel(editExpense);
		return "redirect:/expenses";
	}
	

	@RequestMapping(value="/expenses/{id}/delete", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		travelServ.deleteTravel(id);
		return "redirect:/expenses";
	}
	 
}
