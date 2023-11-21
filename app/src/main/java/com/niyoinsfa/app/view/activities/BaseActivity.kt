package com.niyoinsfa.app.view.activities

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.niyoinsfa.app.R
import java.text.SimpleDateFormat
import java.util.*


open class BaseActivity : AppCompatActivity() {

    private lateinit var solidBtnStyle:ContextThemeWrapper
    private lateinit var outlinedBtnStyle:ContextThemeWrapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        solidBtnStyle = ContextThemeWrapper(this, R.style.btnSolidRounded)
        outlinedBtnStyle = ContextThemeWrapper(this, R.style.btnRoundedOutline)
    }


     fun setUpToolbar(title:String,toolbar:Toolbar,isTitleShow:Boolean = true,titleColor:Int? = null){
        setSupportActionBar(toolbar)
        if (supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeAsUpIndicator(R.drawable.outline_arrow_back_ios_white_24)
            supportActionBar!!.title = title
            if(!isTitleShow){
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            }

          if(titleColor != null){
              toolbar.setTitleTextColor(titleColor)
          }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object{
        var alert: AlertDialog? = null
        // THIS FUNCTION WILL CHECK THE INTERNET CONNECTION AVAILABLE OR NOT
        fun isNetworkAvailable(context: Context): Boolean
        {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val capabilities = connectivityManager.getNetworkCapabilities(
                    connectivityManager.activeNetwork
                )
                if (capabilities != null) {
                    when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                            return true
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                            return true
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                            return true
                        }
                    }
                }
            } else {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected)
                {
                    return true
                }
            }
            return false
        }

        fun getCurrentDigitalTime():String
        {
            val c: Date = Calendar.getInstance().time
            val df = SimpleDateFormat("h:mm:ss a", Locale.getDefault())
            return df.format(c).uppercase(Locale.ENGLISH)
        }

        fun todayCurrentDate():String
        {
            val c: Date = Calendar.getInstance().time
            val df = SimpleDateFormat("E, dd MMM yyyy", Locale.getDefault())
            return df.format(c).uppercase(Locale.ENGLISH)
        }

        fun todayCurrentDateFormatted():String
        {
            val c: Date = Calendar.getInstance().time
            val df = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            return df.format(c).uppercase(Locale.ENGLISH)
        }

        @SuppressLint("HardwareIds")
        fun getAndroidDeviceId(context: Context):String{
            return Settings.Secure.getString(context.contentResolver,Settings.Secure.ANDROID_ID)
        }

        fun showAlert(context: Context, message: String) {
            MaterialAlertDialogBuilder(context)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok") { dialog, which ->
                    dialog.dismiss()
                }
                .create().show()
        }

        fun startLoading(context: Context) {
            val builder = MaterialAlertDialogBuilder(context)
            val layout = LayoutInflater.from(context).inflate(R.layout.custom_loading, null)
            builder.setView(layout)
            builder.setCancelable(false)
            alert = builder.create()
            alert!!.show()
        }

        fun dismiss() {
            if (alert != null) {
                alert!!.dismiss()
            }
        }
    }
}