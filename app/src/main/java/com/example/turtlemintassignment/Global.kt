package com.example.turtlemintassignment

import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

const val SOMETHING_WENT_WRONG = "Something went wrong. Please try after sometime."
const val NO_INTERNET_CON = "No internet connection. Please turn on internet connection."
const val MM_DD_YYYY = "mm-DD-yyyy"
const val YYYY_MM_DD_T_HH_MM_SSZ = "yyyy-mm-DD'T'HH:MM:ss'Z'"
var progressDialog: ProgressDialog? = null

fun showToast(context: Context, str: String?) {
    Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
}

fun get200Chars(str: String?): String {
    return if (str != null && str.isNotEmpty() && str.count() > 200) str.substring(
        0,
        200
    ) else str!!
}

fun convertDate(datetime: String?, inputPattern: String?, outputPattern: String): String {
    val inpFormat = SimpleDateFormat(inputPattern, Locale.getDefault())
    val outFormat = SimpleDateFormat(outputPattern, Locale.getDefault())
    var date: Date? = null
    var str: String = ""
    try {
        date = inpFormat.parse(datetime)
        str = outFormat.format(date)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return str
}

fun showProgressDialog(context: Context) {
    try {
        progressDialog = ProgressDialog(context)
        progressDialog!!.setTitle(null)
        progressDialog!!.setMessage("Please wait.. while data is loading...")
        progressDialog!!.isIndeterminate = false
        progressDialog!!.setCanceledOnTouchOutside(false)
        progressDialog!!.setCancelable(false)
        if (progressDialog != null && !progressDialog!!.isShowing) {
            progressDialog!!.show()
        }
    } catch (e: Exception) {
    }
}

fun hideProgressDialog() {
    try {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog!!.dismiss()
        }
    } catch (e: Exception) {
    }
}

fun checkForInternet(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    } else {
        @Suppress("DEPRECATION") val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false
        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
}