package com.udacity.political.preparedness.main.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.political.preparedness.data.repository.ElectionDetailDataRepository
import com.udacity.political.preparedness.data.repository.SavedElectionDetailDataRepository
import com.udacity.political.preparedness.data.storage.database.ElectionDatabase
import com.udacity.political.preparedness.domain.usecase.ElectionDetailUseCase
import com.udacity.political.preparedness.domain.usecase.SavedElectionDetailUseCase

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

            return DetailInfoViewModel(
                app.baseContext,
                electionDetailUseCase,
                savedElectionDetailUseCase
            ) as T
        }
        throw IllegalArgumentException("Unable to construct view model")
    }
}
