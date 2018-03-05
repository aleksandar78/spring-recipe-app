package org.aroundbit.recipe.controllers;

import org.aroundbit.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

	private RecipeService service;

	public RecipeController(RecipeService service) {
		this.service = service;
	}
	
	@RequestMapping("/recipe/show/{id}")
	public String showRecipeDetails(@PathVariable Long id, Model model) {
		model.addAttribute("recipe", service.findById(id));
		return "recipe/show";
	}
}
