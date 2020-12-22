package com.rubywei.cleanarchitecturerecipes.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoodRecipeModel(
    @SerialName("results")
    val resultModels: List<ResultModel>
)