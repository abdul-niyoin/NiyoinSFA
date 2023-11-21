package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityChemistDcrBinding
import com.niyoinsfa.app.databinding.ActivityStockistDcrBinding
import com.niyoinsfa.app.view.fragments.*

class StockistDcrActivity : BaseActivity() {

    private lateinit var binding:ActivityStockistDcrBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStockistDcrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_stocking_dcr),binding.toolbar, titleColor = Color.WHITE)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,
            AddStockistDcrFragment(),"add_stockist_dcr")
            .commit()

        binding.addBtn.setOnClickListener {
            binding.addBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.addBtn.setTextColor(Color.WHITE)
            binding.viewBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.viewBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                AddStockistDcrFragment(),"add_stockist_dcr")
                .commit()
        }

        binding.viewBtn.setOnClickListener {
            binding.viewBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.viewBtn.setTextColor(Color.WHITE)
            binding.addBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.addBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                ViewStockistDcrFragment(),"view_stockist_dcr")
                .commit()
        }
    }
}