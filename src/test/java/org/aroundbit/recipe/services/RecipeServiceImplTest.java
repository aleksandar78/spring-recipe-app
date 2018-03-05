package org.aroundbit.recipe.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aroundbit.recipe.domain.Recipe;
import org.aroundbit.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RecipeServiceImplTest {

	RecipeServiceImpl target;
	
	@Mock
	RecipeRepository repository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		target = new RecipeServiceImpl(repository);
	}
	
	@Test
	public void getRecipeByIdTest() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> opt = Optional.of(recipe);
		
		BDDMockito.given(repository.findById(Mockito.anyLong())).willReturn(opt);
		
		Recipe response = target.findById(1L);
		assertNotNull(response);
		BDDMockito.verify(repository, Mockito.times(1)).findById(Mockito.anyLong());
		BDDMockito.verify(repository, Mockito.never()).findAll();
	}
	
	@Test
	public void getREcipesTest() throws Exception {
		Recipe recipe = new Recipe();
		List<Recipe> set = new ArrayList<>();
		set.add(recipe);
		
		BDDMockito.when(target.getRecipes()).thenReturn(set);
		List<Recipe> recipes = target.getRecipes();
		assertEquals(recipes.size(), 1);
		Mockito.verify(repository, Mockito.times(1)).findAll();
		Mockito.verify(repository, Mockito.never()).findById(Mockito.anyLong());
	}
}
