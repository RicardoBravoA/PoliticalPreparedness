package com.udacity.political.preparedness.main.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.data.repository.ElectionDetailDataRepository
import com.udacity.political.preparedness.data.repository.SavedElectionDetailDataRepository
import com.udacity.political.preparedness.domain.usecase.ElectionDetailUseCase
import com.udacity.political.preparedness.domain.usecase.SavedElectionDetailUseCase
import com.udacity.political.preparedness.util.resources.ResourcesProvider

@Suppress("UNCHECKED_CAST")
class DetailInfoViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailInfoViewModel::class.java)) {

            val electionDetailDataRepository = ElectionDetailDataRepository()
            val electionDetailUseCase = ElectionDetailUseCase(electionDetailDataRepository)

            val savedElectionDetailDataRepository =
                SavedElectionDetailDataRepository(app.baseContext)
            val savedElectionDetailUseCase =
                SavedElectionDetailUseCase(savedElectionDetailDataRepository)

            val resources = ResourcesProvider(app.baseContext)

            return DetailInfoViewModel(
                app.baseContext,
                electionDetailUseCase,
                savedElectionDetailUseCase,
                resources
            ) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}
