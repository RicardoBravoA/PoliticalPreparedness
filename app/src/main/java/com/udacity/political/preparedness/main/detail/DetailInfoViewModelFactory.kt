package com.udacity.political.preparedness.main.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailInfoViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailInfoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailInfoViewModel() as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}
