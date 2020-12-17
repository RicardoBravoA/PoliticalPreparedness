package com.udacity.political.preparedness.util

import android.view.View

fun View.visible(value: Boolean) {
    visibility = if (value) {
        View.VISIBLE
    } else {
        View.GONE
    }
}