package org.aroundbit.recipe.controllers;

import org.aroundbit.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	private final RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"", "/", "index"})
	public String getIndexPage(Model model) {
		log.debug("Access index page");
		model.addAttribute("recipes",recipeService.getRecipes());
		return "index";
	}
}
