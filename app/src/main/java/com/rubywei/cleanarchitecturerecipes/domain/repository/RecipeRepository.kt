package com.rubywei.cleanarchitecturerecipes.domain.repository

import com.rubywei.cleanarchitecturerecipes.domain.entity.Recipe

abstract class RecipeRepository {
    abstract suspend fun getAllReceipes() : List<Recipe>
}