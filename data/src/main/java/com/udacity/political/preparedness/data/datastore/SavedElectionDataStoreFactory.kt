package com.udacity.political.preparedness.data.datastore

import android.content.Context
import com.udacity.political.preparedness.data.storage.SavedElectionStorageDataStore
import com.udacity.political.preparedness.data.storage.database.ElectionDatabase

class SavedElectionDataStoreFactory(private val context: Context) {

    fun create(): ElectionDataStore {
        val database = ElectionDatabase.getInstance(context)

        return SavedElectionStorageDataStore(database.savedElectionDao)
    }

}