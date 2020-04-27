package com.dewari.ajay.androidnetworkcommunication.activities

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dewari.ajay.androidnetworkcommunication.R
import com.dewari.ajay.androidnetworkcommunication.network.RequestHandler
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Change the url with a GET URL request
        val urlGET = "http://my-json-feed"

        //GET Request
        RequestAsync(this@MainActivity, urlGET, RequestHandler.GET).execute();

        // POST Request
//        doPost()


    }

    private fun doPost() {
        // Change the url with a Post URL request
        val urlPOST = "http://my-json-feed"
        val postDataParams = JSONObject()
        postDataParams.put("name", "Ajay Singh Dewari")
        postDataParams.put("email", "ajdewari@gmail.com")
        postDataParams.put("phone", "+91 7829484225")
        RequestAsync(this@MainActivity, urlPOST, RequestHandler.POST, postDataParams).execute()
    }

    class RequestAsync(private val context: Context, private val url: String, private val requestType:
    String, private val postJSONObject: JSONObject = JSONObject()
    ) : AsyncTask<String?, String?, String?>() {

        override fun doInBackground(vararg p0: String?): String? {
            return when (requestType) {
                RequestHandler.GET -> RequestHandler.requestGET(url)
                RequestHandler.GET -> RequestHandler.sendPost(url, postJSONObject)
                else -> ""
            }
        }

        override fun onPostExecute(s: String?) {
            if (s != null) {
                Toast.makeText(context, s, Toast.LENGTH_LONG).show()
            }
        }
    }
}