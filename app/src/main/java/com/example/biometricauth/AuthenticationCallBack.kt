package com.example.biometricauth

import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(api = Build.VERSION_CODES.P)
internal class AuthenticationCallback (
    private val listener: BiometricPromptCompat.OnAuthenticateListener
) : BiometricPrompt.AuthenticationCallback() {

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
        super.onAuthenticationError(errorCode, errString)
        listener.onAuthError(errorCode, errString ?: "")
    }

    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
        super.onAuthenticationSucceeded(result)
        listener.onAuthSuccess()
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
        super.onAuthenticationHelp(helpCode, helpString)
        listener.onAuthHelp(helpCode, helpString ?: "")
    }

    override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        listener.onAuthFailure()
    }
}