package com.rubywei.cleanarchitecturerecipes.domain.mapper

import com.rubywei.cleanarchitecturerecipes.data.model.FoodRecipeModel
import com.rubywei.cleanarchitecturerecipes.domain.entity.Recipe

class RecipeMapper {
    companion object{
       fun fromModel(recipe : Recipe) : FoodRecipeModel = FoodRecipeModel(
           resultModels = recipe.results.map {
               ResultMapper.toModel(it)
           }
       )
        fun toModel(recipeModel: FoodRecipeModel) = Recipe(
            results = recipeModel.resultModels.map {
                ResultMapper.fromModel(it)
            }
        )
    }
}