package com.udacity.political.preparedness.main.detail

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.political.preparedness.data.util.isInternet
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.usecase.ElectionDetailUseCase
import com.udacity.political.preparedness.domain.usecase.SavedElectionDetailUseCase
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.launch

class DetailInfoViewModel(
    private val context: Context,
    private val electionDetailUseCase: ElectionDetailUseCase,
    private val savedElectionDetailUseCase: SavedElectionDetailUseCase
) : ViewModel() {

    private val _data = MutableLiveData<ElectionDetailModel>()
    val data: LiveData<ElectionDetailModel>
        get() = _data

    private val _showForm = MutableLiveData<Boolean>()
    val showForm: LiveData<Boolean>
        get() = _showForm

    private val _showErrorForm = MutableLiveData<Boolean>()
    val showErrorForm: LiveData<Boolean>
        get() = _showErrorForm

    private val _fromSaved = MutableLiveData<Boolean>()
    val fromSaved: LiveData<Boolean>
        get() = _fromSaved

    fun fromSaved(value: Boolean) {
        _fromSaved.value = value
    }

    fun validateInternet() {
        val internet = context.isInternet()

        _showForm.value = internet
        _showErrorForm.value = !internet
    }

    fun showData(id: String, address: String) {
        viewModelScope.launch {
            when (val result = electionDetailUseCase.get(id, address)) {
                is ResultType.Success -> {
                    _data.value = result.value
                }
                is ResultType.Error -> {
                    //Do nothing
                }
            }
        }
    }

    fun showOfflineData(id: String) {
        viewModelScope.launch {
            when (val result = savedElectionDetailUseCase.get(id)) {
                is ResultType.Success -> {
                    _data.value = result.value
                }
                is ResultType.Error -> {
                    //Do nothing
                }
            }
        }
    }

    fun saveElection() {
        viewModelScope.launch {
            data.value?.let {
                savedElectionDetailUseCase.save(it)
            }
        }
    }

    fun deleteElection() {
        viewModelScope.launch {
            data.value?.let {
                savedElectionDetailUseCase.delete(it.id)
            }
        }
    }

}