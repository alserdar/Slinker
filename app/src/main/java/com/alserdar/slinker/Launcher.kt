package com.alserdar.slinker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.alserdar.slinker.connection_stability.availableNetwork
import com.alserdar.slinker.sigin_in_annonylously.DetectCountry
import com.alserdar.slinker.sigin_in_annonylously.LoginAsAnon
import com.google.firebase.auth.FirebaseAuth

class Launcher : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)



        if (availableNetwork(this))
        {
            Handler().postDelayed(
                {

                    val yeah:Boolean =  FirebaseAuth.getInstance().currentUser != null

                    if (yeah)
                    {
                        val i = Intent(this , Home::class.java)
                        startActivity(i)
                    }else
                    {
                        val i = Intent(this , DetectCountry::class.java)
                        startActivity(i)
                    }

                },2000
            )
        }else
        {

        }

    }
}
