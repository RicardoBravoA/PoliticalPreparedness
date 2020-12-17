package com.udacity.political.preparedness.util

import android.text.util.Linkify
import android.widget.TextView

fun TextView.hyperlink(text: String) {
    setText(text)
    Linkify.addLinks(this, Linkify.WEB_URLS)
}