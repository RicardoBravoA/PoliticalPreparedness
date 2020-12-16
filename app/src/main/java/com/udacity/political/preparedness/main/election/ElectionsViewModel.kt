package com.udacity.political.preparedness.main.election

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.usecase.ElectionUseCase
import com.udacity.political.preparedness.domain.usecase.SavedElectionUseCase
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.launch

//TODO: Construct ViewModel and provide election datasource
class ElectionsViewModel(
    private val electionUseCase: ElectionUseCase,
    private val savedElectionUseCase: SavedElectionUseCase
) : ViewModel() {

    //TODO: Create live data val for upcoming elections

    //TODO: Create live data val for saved elections

    //TODO: Create val and functions to populate live data for upcoming elections from the API and saved elections from local database

    //TODO: Create functions to navigate to saved or upcoming election voter info

    private val _electionList = MutableLiveData<List<ElectionModel>>()
    val electionList: LiveData<List<ElectionModel>>
        get() = _electionList

    private val _savedElectionList = MutableLiveData<List<ElectionModel>>()
    val savedElectionList: LiveData<List<ElectionModel>>
        get() = _savedElectionList


    fun showData() {
        viewModelScope.launch {
            when (val result = electionUseCase.get()) {
                is ResultType.Success -> {
                    Log.i("z- data", result.value.toString())
                    _electionList.value = result.value
                }
                is ResultType.Error -> {
                    Log.i("z- error", result.value.toString())
                }
            }
        }
    }

    fun loadSavedElections() {
        viewModelScope.launch {
            when (val result = savedElectionUseCase.get()) {
                is ResultType.Success -> {
                    Log.i("z- data", result.value.toString())
                    _savedElectionList.value = result.value
                }
                is ResultType.Error -> {
                    Log.i("z- error", result.value.toString())
                }
            }
        }
    }

}