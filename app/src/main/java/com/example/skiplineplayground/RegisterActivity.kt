package com.example.skiplineplayground

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var emailEdt: EditText
    private lateinit var nameEdt: EditText
    private lateinit var phoneEdt: EditText
    private lateinit var passwordEdt: EditText
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val signUpBtn = findViewById<Button>(R.id.sign_up_btn)
        val logInTxt = findViewById<TextView>(R.id.log_in_txt)
        progressBar = findViewById(R.id.loading)
        emailEdt = findViewById(R.id.e_mail)
        nameEdt = findViewById(R.id.user_name)
        phoneEdt = findViewById(R.id.phone)
        passwordEdt = findViewById(R.id.password)


        //signUp btn
        signUpBtn.setOnClickListener {
            registerUser()
            //Toast.makeText(this, "You Registered", Toast.LENGTH_SHORT).show()
        }

        logInTxt.setOnClickListener { showLogin() }
    }

    //trimming input
    private fun registerUser() {
        val email = emailEdt.text.toString().trim { it <= ' ' }
        val name = nameEdt.text.toString().trim { it <= ' ' }
        val phone = phoneEdt.text.toString().trim { it <= ' ' }
        val password = passwordEdt.text.toString().trim { it <= ' ' }

        //first we will do the validations
        //email
        if (TextUtils.isEmpty(email)) {
            emailEdt.error = "Please enter your email"
            emailEdt.requestFocus()
            return
        }

        //matching email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEdt.error = "Enter a valid email"
            emailEdt.requestFocus()
            return
        }

        //username
        if (TextUtils.isEmpty(name)) {
            nameEdt.error = "Please enter your name"
            nameEdt.requestFocus()
            return
        }

        //phone
        if (TextUtils.isEmpty(phone)) {
            phoneEdt.error = "Please enter your phone number"
            phoneEdt.requestFocus()
            return
        }

        //matching phone
        if (!android.util.Patterns.PHONE.matcher(phone).matches()) {
            phoneEdt.error = "Enter a valid phone number"
            phoneEdt.requestFocus()
            return
        }


        //password
        if (TextUtils.isEmpty(password)) {
            passwordEdt.error = "Enter a password"
            passwordEdt.requestFocus()
            return
        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

//        //if everything is fine
//        val stringRequest = object : StringRequest(
//            Method.POST, URLs.URL_REGISTER,
//            Response.Listener { response ->
//                progressBar.visibility = View.GONE
//
//                try {
//                    //converting response to json object
//                    val obj = JSONObject(response)
//                    //if no error in response
//                    if (!obj.getBoolean("error")) {
//                        Toast.makeText(
//                            applicationContext,
//                            obj.getString("message"),
//                            Toast.LENGTH_SHORT
//                        ).show()
//
//                        //getting the user from the response
//                        val userJson = obj.getJSONObject("user")
//
//                        //creating a new user object
//                        val user = User(
//                            userJson.getString("email"),
//                            userJson.getString("firstName"),
//                            userJson.getString("lastName"),
//                            userJson.getString("phone"),
//                            userJson.getString("password")
//                        )
//
//                        //storing the user in shared preferences
//                        SharedPrefManager.getInstance(applicationContext).userLogin(user)
//
//                        //starting the MainActivity activity
//                        finish()
//                        startActivity(Intent(applicationContext, MainActivity::class.java))
//                    } else {
//                        Toast.makeText(
//                            applicationContext,
//                            obj.getString("message"),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//            },
//            Response.ErrorListener { error ->
//                Toast.makeText(
//                    applicationContext,
//                    error.message,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }) {
//            @Throws(AuthFailureError::class)
//            override fun getParams(): Map<String, String> {
//                val params = HashMap<String, String>()
//                params["email"] = email
//                params["username"] = name
//                params["phone"] = phone
//                params["password"] = password
//                return params
//            }
//        }
//
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)
    }

    //Show registrationActivity
    private fun showLogin() {
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }
}