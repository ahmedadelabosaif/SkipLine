package com.example.skiplineplayground

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue

class VolleySingleton private constructor(context: Context) {
    private var mRequestQueue: RequestQueue

    // applicationContext is key, it keeps you from leaking the
    // Activity or BroadcastReceiver if someone passes one in.
    private val requestQueue: RequestQueue
        get() {
            return mRequestQueue
        }

    init {
        mCtx = context
        mRequestQueue = requestQueue
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        requestQueue.add(req)
    }

    companion object {
        private var mInstance: VolleySingleton? = null
        private var mCtx: Context? = null

        @Synchronized
        fun getInstance(context: Context): VolleySingleton {
            if (mInstance == null) {
                mInstance = VolleySingleton(context)
            }
            return mInstance as VolleySingleton
        }
    }
}




