package com.example.biometricauth

import android.annotation.TargetApi
import android.content.Context
import android.os.Build

@SuppressWarnings("deprecation")
@TargetApi(Build.VERSION_CODES.M)
internal class BiometricPrompt(
    private var context: Context,
    private var builder: Builder
) {

    class Builder(private val context: Context) {
        var title: String? = null
            private set
        var subtitle: String? = null
            private set
        var description: String? = null
            private set
       // var btnNegativeText: String = context.getString(R.string.cancel)
      //      private set

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setSubtitle(subtitle: String): Builder {
            this.subtitle = subtitle
            return this
        }

        fun setDescription(description: String): Builder {
            this.description = description
            return this
        }

//        fun setButtonNegative(text: String): Builder {
//            this.btnNegativeText = text
//            return this
//        }
        fun build() = BiometricPrompt(context, this)
    }
}