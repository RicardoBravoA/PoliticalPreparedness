package com.udacity.political.preparedness.main.detail

import android.content.Context
import android.util.Log
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

    //TODO: Add live data to hold voter info

    private val _data = MutableLiveData<ElectionDetailModel>()
    val data: LiveData<ElectionDetailModel>
        get() = _data

    private val _showForm = MutableLiveData<Boolean>()
    val showForm: LiveData<Boolean>
        get() = _showForm

    private val _showErrorForm = MutableLiveData<Boolean>()
    val showErrorForm: LiveData<Boolean>
        get() = _showErrorForm

    //TODO: Add var and methods to populate voter info

    //TODO: Add var and methods to support loading URLs

    //TODO: Add var and methods to save and remove elections to local database
    //TODO: cont'd -- Populate initial state of save button to reflect proper action based on election saved status

    /**
     * Hint: The saved state can be accomplished in multiple ways. It is directly related to how elections are saved/removed from the database.
     */

    init {
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
                    Log.i("z- data", result.value.toString())
                    _data.value = result.value
                }
                is ResultType.Error -> {
                    Log.i("z- error", result.value.toString())
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

    fun deleteElection(id: String) {
        viewModelScope.launch {
            data.value?.let {
                savedElectionDetailUseCase.delete(id)
            }
        }
    }

}