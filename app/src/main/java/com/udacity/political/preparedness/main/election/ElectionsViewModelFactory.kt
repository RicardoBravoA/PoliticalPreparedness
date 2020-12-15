package com.udacity.political.preparedness.main.election

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ElectionsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ElectionsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ElectionsViewModel() as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}
