package com.udacity.political.preparedness.util

import android.text.util.Linkify
import android.widget.TextView
import java.util.regex.Pattern

fun TextView.hyperlink(patternToMatch: String, link: String) {
    text = patternToMatch
    val filter = Linkify.TransformFilter { _, _ -> link }
    Linkify.addLinks(
        this, Pattern.compile(patternToMatch), null, null,
        filter
    )
}