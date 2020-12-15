package com.udacity.political.preparedness.main.election

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.data.datastore.ElectionDataStoreFactory
import com.udacity.political.preparedness.data.repository.ElectionDataRepository
import com.udacity.political.preparedness.domain.usecase.ElectionUseCase

@Suppress("UNCHECKED_CAST")
class ElectionsViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ElectionsViewModel::class.java)) {
            val electionDataRepository = ElectionDataRepository(ElectionDataStoreFactory(app))
            val electionUseCase = ElectionUseCase(electionDataRepository)
            return ElectionsViewModel(electionUseCase) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}
