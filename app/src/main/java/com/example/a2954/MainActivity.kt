package com.example.a2954

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(/*context=*/this)
        val firebaseAppCheck = FirebaseAppCheck.getInstance()
        firebaseAppCheck.installAppCheckProviderFactory(
            DebugAppCheckProviderFactory.getInstance()
        )
    }

    private fun callApiExample1() {
        FirebaseAppCheck.getInstance()
            .getAppCheckToken(false)
            .addOnSuccessListener { tokenResponse ->
                val appCheckToken = tokenResponse.token
                Log.d("Token1", appCheckToken);
            }
    }

    private fun callApiExample2() {
        FirebaseAppCheck.getInstance()
            .getAppCheckToken(true)
            .addOnSuccessListener { tokenResponse ->
                val appCheckToken = tokenResponse.token
                Log.d("Token2", appCheckToken);
            }
    }

    fun testBtn(view: View) {
        callApiExample1()
        callApiExample2()
    }
}