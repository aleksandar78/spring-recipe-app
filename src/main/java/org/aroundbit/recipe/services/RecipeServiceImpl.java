package org.aroundbit.recipe.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.aroundbit.recipe.domain.Recipe;
import org.aroundbit.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository repository;

	public RecipeServiceImpl(RecipeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Recipe> getRecipes() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	
}
