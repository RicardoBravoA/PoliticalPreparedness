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
import com.udacity.political.preparedness.util.resources.ResourcesProvider
import kotlinx.coroutines.launch

class DetailInfoViewModel(
    private val context: Context,
    private val electionDetailUseCase: ElectionDetailUseCase,
    private val savedElectionDetailUseCase: SavedElectionDetailUseCase,
    private val resourcesProvider: ResourcesProvider
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

    private val fromSaved = MutableLiveData<Boolean>()
    private val electionId = MutableLiveData<String>()

    private val _buttonText = MutableLiveData<String>()
    val buttonText: LiveData<String>
        get() = _buttonText

    private val _navigate = MutableLiveData<Boolean>()
    val navigate: LiveData<Boolean>
        get() = _navigate

    fun init(id: String, fromSavedValue: Boolean) {
        fromSaved.value = fromSavedValue
        electionId.value = id

        if (fromSavedValue) {
            _buttonText.value = resourcesProvider.deleteElectionText()
            showOfflineData(id)
        } else {
            _buttonText.value = resourcesProvider.followElectionText()
            validateInternet()
        }
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

    fun actionButton() {
        fromSaved.value?.let {
            if (it) {
                deleteElection()
            } else {
                saveElection()
            }
        }
    }

    private fun showOfflineData(id: String) {
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

    private fun saveElection() {
        viewModelScope.launch {
            data.value?.let {
                savedElectionDetailUseCase.save(it)
                _navigate.value = true
            }
        }
    }

    private fun deleteElection() {
        viewModelScope.launch {
            data.value?.let {
                savedElectionDetailUseCase.delete(it.id)
                _navigate.value = true
            }
        }
    }

}