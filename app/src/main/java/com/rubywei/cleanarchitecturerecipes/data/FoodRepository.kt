package com.rubywei.cleanarchitecturerecipes.data

import com.rubywei.cleanarchitecturerecipes.data.api.FoodApi
import com.rubywei.cleanarchitecturerecipes.domain.entity.Recipe
import com.rubywei.cleanarchitecturerecipes.domain.mapper.RecipeMapper
import com.rubywei.cleanarchitecturerecipes.domain.repository.RecipeRepository
import com.rubywei.cleanarchitecturerecipes.util.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class FoodRepository @Inject constructor(val foodApi: FoodApi,val hasNetwork : Boolean) : RecipeRepository {
    override suspend fun getAllRecipes(): NetworkResult<Recipe>? {
        val query : Map<String,String> = HashMap()
        if(hasNetwork){
           val response =  foodApi.getRecipes(query).body()

        }
    }

    private fun handleFoodRecipesResponse(response: Response<Recipe>): NetworkResult<Recipe>? {
        when {
            response.message().toString().contains("timeout") -> {
                return NetworkResult.Error("Timeout")
            }
            response.code() == 402 -> {
                return NetworkResult.Error("API Key Limited.")
            }
            response.body()!!.results.isNullOrEmpty() -> {
                return NetworkResult.Error("Recipes not found.")
            }
            response.isSuccessful -> {
                val foodRecipes = response.body()
                return NetworkResult.Success(foodRecipes!!)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }
    }

}
