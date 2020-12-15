package com.udacity.political.preparedness.main.election

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ElectionsViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ElectionsViewModel::class.java)) {
           v al asteroidDataRepository = ElectionDataRepository(AsteroidDataStoreFactory(app))
            val asteroidUseCase = AsteroidUseCase(asteroidDataRepository)
            return ElectionsViewModel() as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}
