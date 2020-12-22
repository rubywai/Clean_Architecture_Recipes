package com.rubywei.cleanarchitecturerecipes.domain.mapper

import com.rubywei.cleanarchitecturerecipes.data.model.ExtendedIngredientModel
import com.rubywei.cleanarchitecturerecipes.domain.entity.ExtendedIngredient

class ExtendedIngredientMapper {
    companion object {
        fun toData(extendedIngredient: ExtendedIngredient): ExtendedIngredientModel =
            ExtendedIngredientModel(
                amount = extendedIngredient.amount,
                consistency = extendedIngredient.consistency,
                name = extendedIngredient.name,
                image = extendedIngredient.image,
                original = extendedIngredient.original,
                unit = extendedIngredient.unit
            )

        fun fromData(ingredientModel: ExtendedIngredientModel): ExtendedIngredient =
            ExtendedIngredient(
                amount = ingredientModel.amount,
                consistency = ingredientModel.consistency,
                name = ingredientModel.name,
                image = ingredientModel.image,
                original = ingredientModel.original,
                unit = ingredientModel.unit
            )
    }

}