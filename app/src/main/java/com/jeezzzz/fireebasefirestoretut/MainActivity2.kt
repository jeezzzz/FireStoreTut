package com.jeezzzz.fireebasefirestoretut

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val email=intent.getStringExtra("email")
        FirebaseInstance.db.collection("users")
            .document(email!!)
            .get()
            .addOnSuccessListener {
                val user=it.toObject(User::class.java)!!
                val text=findViewById<TextView>(R.id.text)
                text.text=user.toString()
            }
            .addOnFailureListener{
                Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
            }


    }
}