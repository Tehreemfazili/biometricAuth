package com.example.biometricauth

import android.annotation.TargetApi
import android.content.Context
import android.content.DialogInterface
import android.hardware.biometrics.BiometricPrompt
import android.os.Build

class biometricPrompt(private val context: Context,
                      private val title: String,
                      private val subtitle: String,
                      private val description: String,
                      private val btnText: String){

    @TargetApi(Build.VERSION_CODES.P)
    private fun biometricPrompt(biometricCallBack : BiometricPrompt.AuthenticationCallback){
         BiometricPrompt.Builder(context)
            .setTitle(title)
            .setSubtitle(subtitle)
            .setDescription(description)
             .setNegativeButton(btnText, context.mainExecutor, DialogInterface.OnClickListener { dialogInterface, _ ->
                 if (dialogInterface !=null) dialogInterface.dismiss()
                 biometricCallBack.onAuthenticationFailed()
             })
            .build();
    }
}