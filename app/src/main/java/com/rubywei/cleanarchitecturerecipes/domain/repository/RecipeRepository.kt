package com.rubywei.cleanarchitecturerecipes.domain.repository

import com.rubywei.cleanarchitecturerecipes.domain.entity.Recipe
import com.rubywei.cleanarchitecturerecipes.util.NetworkResult

interface  RecipeRepository {
     suspend fun getAllRecipes() : NetworkResult<Recipe>?
}