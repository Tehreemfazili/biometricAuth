package com.example.biometricauth

import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biometricauth.biometricPrompt.OnAuthenticateListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_authenticate.setOnClickListener {
            showAuthDialog()
        }
    }

    fun showAuthDialog(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            BiometricPromptCompat.Builder(this)
                .setTitle(getString(R.string.fingerprint_dialog_title))
                .setSubtitle("")
                .setDescription(getString(R.string.fingerprint_dialog_description))
                .addOnAuthenticationListener(authListener)
                .build()
                .authenticate(callback)
        }
    }

}
