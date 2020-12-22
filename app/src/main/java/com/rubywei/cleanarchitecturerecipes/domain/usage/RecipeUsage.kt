package com.rubywei.cleanarchitecturerecipes.domain.usage

import com.rubywei.cleanarchitecturerecipes.domain.entity.Recipe
import com.rubywei.cleanarchitecturerecipes.domain.repository.RecipeRepository

class RecipeUsage(private val recipeRepository: RecipeRepository) {
   suspend fun getAllReceipe() : List<Recipe> = recipeRepository.getAllRecipes()
}