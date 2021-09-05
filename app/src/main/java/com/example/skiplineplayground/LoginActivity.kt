package com.example.skiplineplayground

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var nameEdt: EditText
    private lateinit var passwordEdt: EditText
    internal lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn = findViewById<Button>(R.id.login_btn)
        val signUpTxt = findViewById<TextView>(R.id.sign_up_txt)
        progressBar = findViewById(R.id.loading)
        nameEdt = findViewById(R.id.user_name)
        passwordEdt = findViewById(R.id.password)

        //signIn btn
        loginBtn.setOnClickListener {
            userLogin()
            //Toast.makeText(this, "You loggedIn", Toast.LENGTH_SHORT).show()
        }

        signUpTxt.setOnClickListener { showRegistration() }
    }

    private fun userLogin() {
        //first getting the values
        val name = nameEdt.text.toString()
        val password = passwordEdt.text.toString()

        //validating inputs
        //username
        if (TextUtils.isEmpty(name)) {
            nameEdt.error = "Please enter your name"
            nameEdt.requestFocus()
            return
        }

        //password
        if (TextUtils.isEmpty(password)) {
            passwordEdt.error = "Please enter your password"
            passwordEdt.requestFocus()
            return
        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

//        //if everything is fine
//        val stringRequest = object : StringRequest(
//            Method.POST, URLs.URL_LOGIN,
//            Response.Listener { response ->
//                progressBar.visibility = View.GONE
//
//                try {
//                    //converting response to json object
//                    val obj = JSONObject(response)
//
//                    //if no error in response
//                    if (!obj.getBoolean("error")) {
//                        Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_SHORT).show()
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
//                        //starting the MainActivity
//                        finish()
//                        startActivity(Intent(applicationContext, MainActivity::class.java))
//                    } else {
//                        Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_SHORT).show()
//                    }
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//            },
//
//            Response.ErrorListener { error -> Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show() })
//        {
//            @Throws(AuthFailureError::class)
//            override fun getParams(): Map<String, String> {
//                val params = HashMap<String, String>()
//                params["email"] = name
//                params["password"] = password
//                return params
//            }
//        }
//
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)
    }

    //Show registrationActivity
    private fun showRegistration() {
        finish()
        intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }
}