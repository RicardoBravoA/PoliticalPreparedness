package com.udacity.political.preparedness.data.datastore

import android.content.Context
import com.udacity.political.preparedness.data.service.ElectionDetailServiceDataStore
import com.udacity.political.preparedness.data.storage.ElectionDetailStorageDataStore
import com.udacity.political.preparedness.data.storage.database.ElectionDatabase
import com.udacity.political.preparedness.data.util.isInternet

class GeocodeDataStoreFactory(private val context: Context) {

    fun create(): GeocodeDataStore {
        val value = if (context.isInternet()) Preference.CLOUD else Preference.DB

        return if (Preference.CLOUD == value) {
            ElectionDetailServiceDataStore(database.electionDetailDao)
        } else {
            ElectionDetailStorageDataStore(database.electionDetailDao)
        }
    }

    enum class Preference {
        CLOUD, DB
    }

}