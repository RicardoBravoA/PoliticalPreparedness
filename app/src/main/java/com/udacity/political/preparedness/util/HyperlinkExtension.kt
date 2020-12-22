package com.udacity.political.preparedness.util

import android.content.Context
import android.content.Intent
import android.net.Uri
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

fun Context.openWebView(url: String) {
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(url)
    startActivity(i)
}