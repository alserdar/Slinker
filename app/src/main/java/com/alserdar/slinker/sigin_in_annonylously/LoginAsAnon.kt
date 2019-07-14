package com.alserdar.slinker.sigin_in_annonylously

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.alserdar.slinker.Home
import com.alserdar.slinker.Launcher
import com.alserdar.slinker.R
import com.alserdar.slinker.connection_stability.availableNetwork
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login_as_anon.*

class LoginAsAnon : AppCompatActivity() {



    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    private var currentCountry:String? = intent.extras!!.getString("currentCountry")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_as_anon)


        auth = FirebaseAuth.getInstance()

        if (availableNetwork(this))
        {

            signInAnonymously()

            Handler().postDelayed(
                {


                },3000
            )
        }else
        {
            val launcher = Intent(this , Launcher::class.java)
            startActivity(launcher)
            finish()
        }


    }

    private fun signInAnonymously() {

        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser

                    val createUser = hashMapOf(
                        "userName" to GenerateNames().GenerateName(),
                        "email" to user!!.email,
                        "country" to currentCountry,
                        "phoneNumber" to user.phoneNumber)


                    db.collection("UserInformation" ).document(user.uid)
                        .set(createUser)
                        .addOnSuccessListener {
                            val launcher = Intent(this , Home::class.java)
                            startActivity(launcher)
                            finish()
                        }
                        .addOnFailureListener {
                            val launcher = Intent(this , Launcher::class.java)
                            startActivity(launcher)
                            finish()
                        }

                } else {
                    val i = Intent(this , Launcher::class.java)
                    startActivity(i)
                }
            }
    }

    override fun onBackPressed() {

    }
}
