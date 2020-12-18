package com.udacity.political.preparedness.util.resources

import android.content.Context
import com.udacity.political.preparedness.R

open class ResourcesProvider(private val context: Context) : ResourcesInterface {

    override fun followElectionText() = context.getString(R.string.follow_election)

    override fun deleteElectionText() = context.getString(R.string.delete_election)
}