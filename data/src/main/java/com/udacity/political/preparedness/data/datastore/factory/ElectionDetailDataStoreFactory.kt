package com.udacity.political.preparedness.data.datastore.factory

import android.content.Context
import com.udacity.political.preparedness.data.datastore.ElectionDetailDataStore
import com.udacity.political.preparedness.data.service.ElectionDetailServiceDataStore
import com.udacity.political.preparedness.data.storage.ElectionDetailStorageDataStore
import com.udacity.political.preparedness.data.storage.database.ElectionDatabase
import com.udacity.political.preparedness.data.util.isInternet

class ElectionDetailDataStoreFactory(private val context: Context) {

    fun create(): ElectionDetailDataStore {
        val database = ElectionDatabase.getInstance(context)
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