package com.udacity.political.preparedness.main.election

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.political.preparedness.domain.usecase.ElectionUseCase
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.launch

//TODO: Construct ViewModel and provide election datasource
class ElectionsViewModel(private val electionUseCase: ElectionUseCase) : ViewModel() {

    //TODO: Create live data val for upcoming elections

    //TODO: Create live data val for saved elections

    //TODO: Create val and functions to populate live data for upcoming elections from the API and saved elections from local database

    //TODO: Create functions to navigate to saved or upcoming election voter info

    fun showData() {
        viewModelScope.launch {
            when (val result = electionUseCase.get()) {
                is ResultType.Success -> {
                    Log.i("z- data", result.value.toString())
                }
                is ResultType.Error -> {
                    Log.i("z- error", result.value.toString())
                }
            }
        }
    }

}