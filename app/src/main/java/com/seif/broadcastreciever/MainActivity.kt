package com.seif.broadcastreciever

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var receiver: AirPlaneModeChangedReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = AirPlaneModeChangedReceiver()
        // used by the system to determine which apps need to receive which intents
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
//        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {
//            registerReceiver(receiver, it)
//        }

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}