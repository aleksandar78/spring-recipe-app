package org.aroundbit.recipe.controllers;

import org.aroundbit.recipe.domain.Recipe;
import org.aroundbit.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class RecipeControllerTest {

	@Mock
	RecipeService service;
	RecipeController target;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		target = new RecipeController(service);
	}
	
	@Test
	public void testGetRecipe() throws Exception {
		Recipe r = new Recipe();
		r.setId(1L);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(target).build();
		
		BDDMockito.when(service.findById(Mockito.anyLong())).thenReturn(r);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("recipe/show"));
	}
}
