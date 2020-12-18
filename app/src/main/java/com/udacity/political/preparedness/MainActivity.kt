package com.udacity.political.preparedness

import android.os.Bundle
import com.udacity.political.preparedness.common.LocationActivity

class MainActivity : LocationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

    }

}