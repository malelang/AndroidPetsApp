package movil.alejandralandinez.petsapp.util

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText


fun ViewGroup.inflate(layout:Int) = LayoutInflater
        .from(context).inflate(layout, this, false)

fun EditText.text() = text.toString()