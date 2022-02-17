package com.seif.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneModeChangedReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> handleAirPlaneMode(context, intent)
            Intent.ACTION_BATTERY_CHANGED -> handleBatteryChanged(context, intent)
        }
    }

    private fun handleBatteryChanged(context: Context?, intent: Intent) {
        val batteryPercentage = intent.getIntExtra("level", 0)
        Toast.makeText(context, "battery percentage = $batteryPercentage", Toast.LENGTH_SHORT).show()
    }

    private fun handleAirPlaneMode(context: Context?, intent: Intent?) {
        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state", false)?: return
        if(isAirPlaneModeEnabled){
            Toast.makeText(context, "Air plane mode is enabled", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Air plane mode is disabled", Toast.LENGTH_SHORT).show()
        }
    }
}