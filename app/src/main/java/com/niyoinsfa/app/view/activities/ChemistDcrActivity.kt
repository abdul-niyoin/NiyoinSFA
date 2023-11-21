package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityChemistDcrBinding
import com.niyoinsfa.app.view.fragments.*

class ChemistDcrActivity : BaseActivity() {

    private lateinit var binding:ActivityChemistDcrBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChemistDcrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_chemist_dcr),binding.toolbar, titleColor = Color.WHITE)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,
            AddChemistDcrFragment(),"add_chemist_dcr")
            .commit()

        binding.addBtn.setOnClickListener {
            binding.addBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.addBtn.setTextColor(Color.WHITE)
            binding.viewBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.viewBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                AddChemistDcrFragment(),"add_chemist_dcr")
                .commit()
        }

        binding.viewBtn.setOnClickListener {
            binding.viewBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.viewBtn.setTextColor(Color.WHITE)
            binding.addBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.addBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                ViewChemistDcrFragment(),"view_chemist_dcr")
                .commit()
        }
    }
}