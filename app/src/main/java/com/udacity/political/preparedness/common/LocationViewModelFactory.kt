package com.udacity.political.preparedness.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.data.datastore.factory.GeocodeDataStoreFactory
import com.udacity.political.preparedness.data.repository.GeocodeDataRepository
import com.udacity.political.preparedness.domain.usecase.GeocodeUseCase
import com.udacity.political.preparedness.main.detail.DetailInfoViewModel

@Suppress("UNCHECKED_CAST")
class LocationViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailInfoViewModel::class.java)) {

            val dataRepository = GeocodeDataRepository(GeocodeDataStoreFactory())
            val useCase = GeocodeUseCase(dataRepository)

            return LocationViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}