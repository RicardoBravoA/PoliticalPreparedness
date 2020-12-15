package com.udacity.political.preparedness.data.datastore

import android.content.Context
import com.udacity.political.preparedness.data.service.ElectionServiceDataStore
import com.udacity.political.preparedness.data.storage.ElectionStorageDataStore
import com.udacity.political.preparedness.data.storage.database.ElectionDatabase
import com.udacity.political.preparedness.data.util.isInternet

class ElectionDataStoreFactory(private val context: Context) {

    fun create(): ElectionDataStore {
        val database = ElectionDatabase.getInstance(context)
        val value = if (context.isInternet()) Preference.CLOUD else Preference.DB

        return if (Preference.CLOUD == value) {
            ElectionServiceDataStore(database.electionDao)
        } else {
            ElectionStorageDataStore(database.electionDao)
        }
    }

    enum class Preference {
        CLOUD, DB
    }

}