package com.example.skiplineplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.budiyev.android.codescanner.*

class ScannerFragment : Fragment() {

    private lateinit var codeScanner: CodeScanner
    private lateinit var barcode: String

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scanner, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
        val activity = requireActivity()

        codeScanner = CodeScanner(activity, scannerView)
        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats =
            CodeScanner.ALL_FORMATS // list of type BarcodeFormat, ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not
        //codeScanner.startPreview()

        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {

                val transaction = activity.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.drawer_host_fragment, ScannedItemFragment())
                transaction.disallowAddToBackStack()
                transaction.commit()


//                Toast.makeText(activity, "Scan Result :${it.text}", Toast.LENGTH_LONG).show()
//                val intent = Intent(activity, ScannedItemActivity::class.java)
//                intent.putExtra("productCode", "6221031491887")
//                intent.putExtra("productName", "دوريتوس 5ج")
//                intent.putExtra("kind", "كيس")
//                intent.putExtra("price", "5ج")
//                intent.putExtra("pDate", "")
//                intent.putExtra("exDate", "")

                //starting the ScannedItemActivity
//                startActivity(intent)

//                barcode = it.text
//                val stringRequest = object : StringRequest(
//                    Method.GET, URLs.URL_ITEM_INFORMATION+"/$barcode",
//                    Response.Listener { response ->
//                        try {
//                            //converting response to json object
//                            val obj = JSONObject(response)
//
//                            //if no error in response
//                            if (!obj.getBoolean("error")) {
//                                Toast.makeText(
//                                    activity,
//                                    obj.getString("message"),
//                                    Toast.LENGTH_SHORT
//                                ).show()
//
//                                //getting the DATA from the response
//                                val dataJson = obj.getJSONObject("data")
//
//                                //creating a new DATA object
//                                val data = Data(
//                                    dataJson.getString("productName"),
//                                    dataJson.getString("kind"),
//                                    dataJson.getString("price"),
//                                    dataJson.getString("pDate"),
//                                    dataJson.getString("exDate")
//                                )
//
//                                //storing the Data
//                                val intent =
//                                    Intent(requireContext(), ScannedItemActivity::class.java)
//                                intent.putExtra("productName", data.productName)
//                                intent.putExtra("kind", data.kind)
//                                intent.putExtra("price", data.price)
//                                intent.putExtra("pDate", data.pDate)
//                                intent.putExtra("exDate", data.exDate)
//                                //starting the MainActivity
//                                startActivity(intent)
//                            } else {
//                                Toast.makeText(
//                                    activity,
//                                    obj.getString("message"),
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                        } catch (e: JSONException) {
//                            e.printStackTrace()
//                        }
//                    },
//                    Response.ErrorListener { error ->
//                        Toast.makeText(
//                            activity,
//                            error.message,
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }) {
//                    @Throws(AuthFailureError::class)
//                    override fun getParams(): Map<String, String> {
//                        val params = HashMap<String, String>()
//                        params["barcode"] = it.text
//                        return params
//                    }
//                }
//
//                VolleySingleton.getInstance(requireContext()).addToRequestQueue(stringRequest)

            }
        }

        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            activity.runOnUiThread {
                Toast.makeText(
                    activity, "Error: ${it.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

//        scannerView.setOnClickListener {
//            codeScanner.startPreview()
//        }
    }


    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

}