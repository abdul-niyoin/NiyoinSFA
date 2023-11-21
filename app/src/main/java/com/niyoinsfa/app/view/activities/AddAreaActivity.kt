package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }
}