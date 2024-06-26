package com.jeezzzz.fireebasefirestoretut

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailET = findViewById<EditText>(R.id.emailET)
        val messageET = findViewById<EditText>(R.id.messageET)
        val button = findViewById<Button>(R.id.button)
        val showButton=findViewById<Button>(R.id.nextButton)
        showButton.setOnClickListener {
            val email = emailET.text.toString()
            val intent=Intent(this,MainActivity2::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }

        button.setOnClickListener {
        val email = emailET.text.toString()
        val message = messageET.text.toString()

        val user = User(email, message)


            FirebaseInstance.db.collection("users")
                .document(user.email)
                .set(user)
                .addOnSuccessListener { documentReference ->
                    Log.d("hello", "DocumentSnapshot added with ID: ${user.email}")
                    Toast.makeText(this,"${user.email} added", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Log.w("bye", "Error adding document", e)
                    Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }
}