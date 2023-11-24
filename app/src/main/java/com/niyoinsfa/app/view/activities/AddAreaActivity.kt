package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import com.example.awesomedialog.*
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityAddAreaBinding

class AddAreaActivity : BaseActivity() {

    private lateinit var binding:ActivityAddAreaBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAreaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_add_area),binding.toolbar, titleColor = Color.WHITE)

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AwesomeDialog.build(this@AddAreaActivity)
                    .body("You want to leave this form ?")
                    .icon(R.drawable.info_img)
                    .position(AwesomeDialog.POSITIONS.CENTER)
                    .onPositive("Yes", buttonBackgroundColor = R.drawable.primary_bg) {
                        finish()
                    }
                    .onNegative("No",buttonBackgroundColor = R.drawable.red_bg) {

                    }.show()
            }
        })

    }
}