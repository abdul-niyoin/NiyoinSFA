package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityEdetailingBinding

class EDetailingActivity : BaseActivity() {

    private lateinit var binding:ActivityEdetailingBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEdetailingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_e_detailing),binding.toolbar, titleColor = Color.WHITE)
    }
}