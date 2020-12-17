package com.udacity.political.preparedness.data.datastore.factory

import com.udacity.political.preparedness.data.datastore.GeocodeDataStore
import com.udacity.political.preparedness.data.service.GeocodeServiceDataStore

class GeocodeDataStoreFactory() {

    fun create(): GeocodeDataStore {
        return GeocodeServiceDataStore()
    }

}