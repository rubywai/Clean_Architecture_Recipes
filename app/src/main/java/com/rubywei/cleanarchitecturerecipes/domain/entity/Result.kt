package com.rubywei.cleanarchitecturerecipes.domain.entity

import com.example.foody.models.ExtendedIngredient

data class Result(
    val aggregateLikes: Int,

    val cheap: Boolean,

    val dairyFree: Boolean,

    val extendedIngredients: List<ExtendedIngredient>,

    val glutenFree: Boolean,

    val recipeId: Int,

    val image: String,

    val readyInMinutes: Int,

    val sourceName: String?,

    val sourceUrl: String,

    val summary: String,

    val title: String,

    val vegan: Boolean,

    val vegetarian: Boolean,

    val veryHealthy: Boolean,
)