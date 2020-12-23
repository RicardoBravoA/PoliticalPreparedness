package com.udacity.political.preparedness.main.election

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.usecase.ElectionUseCase
import com.udacity.political.preparedness.domain.usecase.SavedElectionDetailUseCase
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.launch

class ElectionsViewModel(
    private val electionUseCase: ElectionUseCase,
    private val savedElectionDetailUseCase: SavedElectionDetailUseCase
) : ViewModel() {

    private val _electionList = MutableLiveData<List<ElectionModel>>()
    val electionList: LiveData<List<ElectionModel>>
        get() = _electionList

    private val _savedElectionList = MutableLiveData<List<ElectionDetailModel>>()
    val savedElectionList: LiveData<List<ElectionDetailModel>>
        get() = _savedElectionList


    fun showData() {
        viewModelScope.launch {
            when (val result = electionUseCase.get()) {
                is ResultType.Success -> {
                    _electionList.value = result.value
                }
                is ResultType.Error -> {
                    Log.i("z- error", result.value.toString())
                }
            }
        }
    }

    fun showSavedElections() {
        viewModelScope.launch {
            when (val result = savedElectionDetailUseCase.getAll()) {
                is ResultType.Success -> {
                    _savedElectionList.value = result.value
                }
                is ResultType.Error -> {
                    Log.i("z- error", result.value.toString())
                }
            }
        }
    }

}