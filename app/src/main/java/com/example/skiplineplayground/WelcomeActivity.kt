package com.example.skiplineplayground

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

private const val REQUEST_ID_MULTIPLE_PERMISSIONS = 101

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        setupPermissions()

//        //checking if the user is logged in
//        if (SharedPrefManager.getInstance(this).isLoggedIn) {
//
//            intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//
//        }

        //Debug for logged in user --> ignore or delete
        //false by default
        val loggedIn = true

        //Debug for home activity --> ignore or delete
        if (loggedIn) {
            showHome()
        }

        val registerButton = findViewById<Button>(R.id.register_button)
        val logInButton = findViewById<Button>(R.id.log_in_button)

        //Handling register_button
        registerButton.setOnClickListener {
            showRegistration()
        }

        //Handling login_button
        logInButton.setOnClickListener {
            showLogin()
        }

    }

    //Navigate from WelcomeActivity to HomeActivity
    private fun showHome() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    //Show registrationActivity
    private fun showRegistration() {
        intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    //Show registrationActivity
    private fun showLogin() {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    //Checking for permission
    private fun setupPermissions(): Boolean {
        val camera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        val internet = ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)
        if (camera != PackageManager.PERMISSION_GRANTED) {
            makeCameraRequest()
        }
        if (internet != PackageManager.PERMISSION_GRANTED) {
            makeInternetRequest()
        }
        return true
    }


    //Request CAMERA permission
    private fun makeCameraRequest() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            REQUEST_ID_MULTIPLE_PERMISSIONS
        )
    }

    //Request INTERNET permission
    private fun makeInternetRequest() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.INTERNET),
            REQUEST_ID_MULTIPLE_PERMISSIONS
        )
    }


    //Permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_ID_MULTIPLE_PERMISSIONS -> {

                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission has been denied by user", Toast.LENGTH_LONG)
                        .show()

                    val builder = AlertDialog.Builder(this)
                    builder.setMessage("Permission to access the CAMERA & INTERNET is required for this app.")
                        .setTitle("Permission required")
                    builder.setPositiveButton("OK") { _, _ -> makeCameraRequest() }
                    val dialog = builder.create()
                    dialog.show()
                } else {
                    Toast.makeText(this, "", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }


}