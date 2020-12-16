package com.udacity.political.preparedness.main.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.political.preparedness.domain.model.ElectionDetailModel
import com.udacity.political.preparedness.domain.usecase.ElectionDetailUseCase
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.launch

class DetailInfoViewModel(private val electionDetailUseCase: ElectionDetailUseCase) : ViewModel() {

    //TODO: Add live data to hold voter info

    private val _data = MutableLiveData<ElectionDetailModel>()
    val data: LiveData<ElectionDetailModel>
        get() = _data

    //TODO: Add var and methods to populate voter info

    //TODO: Add var and methods to support loading URLs

    //TODO: Add var and methods to save and remove elections to local database
    //TODO: cont'd -- Populate initial state of save button to reflect proper action based on election saved status

    /**
     * Hint: The saved state can be accomplished in multiple ways. It is directly related to how elections are saved/removed from the database.
     */

    fun showData(id: String) {
        viewModelScope.launch {
            when (val result = electionDetailUseCase.get(id)) {
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
}