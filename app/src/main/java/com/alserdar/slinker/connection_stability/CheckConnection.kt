package com.alserdar.slinker.connection_stability

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

fun availableNetwork(activity: AppCompatActivity):Boolean{
    val connectivityManager=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo=connectivityManager.activeNetworkInfo
    return  networkInfo!=null && networkInfo.isConnected
}