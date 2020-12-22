package com.udacity.political.preparedness.util

import android.widget.Spinner

fun Spinner.selectValue(value: String) {
    for (i in 0 until count) {
        if (getItemAtPosition(i) == value) {
            setSelection(i)
            break
        }
    }
}