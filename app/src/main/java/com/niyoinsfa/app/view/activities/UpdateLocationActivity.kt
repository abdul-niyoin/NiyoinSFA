package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityUpdateLocationBinding

class UpdateLocationActivity : BaseActivity() {

    private lateinit var binding:ActivityUpdateLocationBinding

    private lateinit var context: Context

    private var type = "doctor"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        if(intent != null && intent.hasExtra("TYPE")){
            type = intent.getStringExtra("TYPE") as String
        }

        if(type == "doctor"){
            binding.searchBox.hint = getString(R.string.lbl_doctor_search)
            setUpToolbar(getString(R.string.update_doctor_location),binding.toolbar, titleColor = Color.WHITE)
        }
        else if(type == "chemist"){
            binding.searchBox.hint = getString(R.string.lbl_chemist_search)
            setUpToolbar(getString(R.string.update_chemist_location),binding.toolbar, titleColor = Color.WHITE)
        }
        else{
            binding.searchBox.hint = getString(R.string.lbl_stockist_search)
            setUpToolbar(getString(R.string.update_stockist_location),binding.toolbar, titleColor = Color.WHITE)
        }
    }
}