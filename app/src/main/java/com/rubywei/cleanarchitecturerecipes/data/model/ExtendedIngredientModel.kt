package com.rubywei.cleanarchitecturerecipes.data.model

import com.rubywei.cleanarchitecturerecipes.domain.entity.ExtendedIngredient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ExtendedIngredientModel(
    @SerialName("amount")
    val amount: Double,
    @SerialName("consistency")
    val consistency: String,
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("original")
    val original: String,
    @SerialName("unit")
    val unit: String
){
    companion object{
        fun fromData(extendedIngredient: ExtendedIngredient) : ExtendedIngredientModel = ExtendedIngredientModel(
            amount = extendedIngredient.amount,
            consistency = extendedIngredient.consistency,
            name = extendedIngredient.name,
            image = extendedIngredient.image,
            original = extendedIngredient.original,
            unit = extendedIngredient.unit
        )
    }
    fun toData() : ExtendedIngredient = ExtendedIngredient(
        amount = amount,
        consistency = consistency,
        name = name,
        image = image,
        original = original,
        unit = unit
    )
}