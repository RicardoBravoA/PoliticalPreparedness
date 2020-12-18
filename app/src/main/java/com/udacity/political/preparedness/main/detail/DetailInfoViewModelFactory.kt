package com.udacity.political.preparedness.main.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.data.repository.ElectionDetailDataRepository
import com.udacity.political.preparedness.domain.usecase.ElectionDetailUseCase

@Suppress("UNCHECKED_CAST")
class DetailInfoViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailInfoViewModel::class.java)) {

            val dataRepository = ElectionDetailDataRepository()
            val useCase = ElectionDetailUseCase(dataRepository)

            return DetailInfoViewModel(app.baseContext, useCase) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}
