package com.example.skiplineplayground

import android.content.Context
import android.content.Intent

class SharedPrefManager private constructor(context: Context) {

    //this method will checker whether user is already logged in or not
    val isLoggedIn: Boolean
        get() {
            val sharedPreferences =
                ctx?.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences?.getString(KEY_FIRSTNAME, null) != null
        }

    //this method will give the logged in user
    val user: User
        get() {
            val sharedPreferences =
                ctx?.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return User(
                sharedPreferences?.getString(KEY_EMAIL, null),
                sharedPreferences?.getString(KEY_FIRSTNAME, null),
                sharedPreferences?.getString(KEY_LASTNAME, null),
                sharedPreferences?.getString(KEY_PHONE, null),
                sharedPreferences?.getString(KEY_PASSWORD, null)
            )
        }

    init {
        ctx = context
    }

    //this method will store the user data in shared preferences
    fun userLogin(user: User) {
        val sharedPreferences = ctx?.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString(KEY_EMAIL, user.email)
        editor?.putString(KEY_FIRSTNAME, user.firstName)
        editor?.putString(KEY_LASTNAME, user.lastName)
        editor?.putString(KEY_PHONE, user.phone)
        editor?.putString(KEY_PASSWORD, user.password)
        editor?.apply()
    }

    //this method will logout the user
    fun logout() {
        val sharedPreferences = ctx?.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.clear()
        editor?.apply()
        ctx?.startActivity(Intent(ctx, LoginActivity::class.java))
    }

    companion object {
        private const val SHARED_PREF_NAME = "skiplineregisterlogin"
        private const val KEY_EMAIL = "email"
        private const val KEY_FIRSTNAME = "firstName"
        private const val KEY_LASTNAME = "lastName"
        private const val KEY_PHONE = "phone"
        private const val KEY_PASSWORD = "password"
        private var mInstance: SharedPrefManager? = null
        private var ctx: Context? = null

        @Synchronized
        fun getInstance(context: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(context) }
            return mInstance as SharedPrefManager
        }
    }
}