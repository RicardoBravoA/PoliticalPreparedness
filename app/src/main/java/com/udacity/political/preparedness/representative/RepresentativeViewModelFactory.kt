package com.udacity.political.preparedness.representative

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.data.repository.RepresentativeDataRepository
import com.udacity.political.preparedness.domain.usecase.RepresentativeUseCase

@Suppress("UNCHECKED_CAST")
class RepresentativeViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepresentativeViewModel::class.java)) {

            val representativeDataRepository = RepresentativeDataRepository()
            val representativeUseCase = RepresentativeUseCase(representativeDataRepository)

            return RepresentativeViewModel(
                representativeUseCase
            ) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}
