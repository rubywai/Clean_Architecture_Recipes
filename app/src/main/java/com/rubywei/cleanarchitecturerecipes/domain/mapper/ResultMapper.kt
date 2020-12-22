package com.rubywei.cleanarchitecturerecipes.domain.mapper

import com.rubywei.cleanarchitecturerecipes.data.model.ResultModel
import com.rubywei.cleanarchitecturerecipes.domain.entity.Result

class ResultMapper {
    companion object {
        fun toModel(result: Result): ResultModel = ResultModel(
            aggregateLikes = result.aggregateLikes,
            cheap = result.cheap,
            dairyFree = result.dairyFree,
            glutenFree = result.glutenFree,
            recipeId = result.recipeId,
            image = result.image,
            readyInMinutes = result.readyInMinutes,
            sourceName = result.sourceName,
            sourceUrl = result.sourceUrl,
            summary = result.summary,
            title = result.title,
            vegan = result.vegan,
            vegetarian = result.vegetarian,
            veryHealthy = result.veryHealthy,
            extendedIngredientModels = result.extendedIngredients.map {
                ExtendedIngredientMapper.toData(it)
            }
        )
        fun fromModel(resultModel: ResultModel): Result = Result(
            aggregateLikes = resultModel.aggregateLikes,
            cheap = resultModel.cheap,
            dairyFree = resultModel.dairyFree,
            glutenFree = resultModel.glutenFree,
            recipeId = resultModel.recipeId,
            image = resultModel.image,
            readyInMinutes = resultModel.readyInMinutes,
            sourceName = resultModel.sourceName,
            sourceUrl = resultModel.sourceUrl,
            summary = resultModel.summary,
            title = resultModel.title,
            vegan = resultModel.vegan,
            vegetarian = resultModel.vegetarian,
            veryHealthy = resultModel.veryHealthy,
            extendedIngredients = resultModel.extendedIngredientModels.map {
                ExtendedIngredientMapper.fromData(it)
            }
        )
    }
}