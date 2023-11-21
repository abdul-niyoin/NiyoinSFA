package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityReportBinding
import com.niyoinsfa.app.view.fragments.AddDoctorDcrFragment
import com.niyoinsfa.app.view.fragments.CoreUtilityFragment
import com.niyoinsfa.app.view.fragments.ReportFragment

class ReportActivity : BaseActivity() {

    private lateinit var binding:ActivityReportBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_reports),binding.toolbar, titleColor = Color.WHITE)

//        supportFragmentManager.beginTransaction().add(R.id.fragment_container,
//            ReportFragment(),"add_report")
//            .commit()
//
//        binding.btnReport.setOnClickListener {
//            binding.btnReport.setBackgroundResource(R.drawable.btnsolidrounded)
//            binding.btnReport.setTextColor(Color.WHITE)
//            binding.btnCoreUtility.setBackgroundResource(R.drawable.btnroundedoutline)
//            binding.btnCoreUtility.setTextColor(Color.BLACK)
//            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
//                ReportFragment(),"add_report")
//                .commit()
//        }
//
//        binding.btnCoreUtility.setOnClickListener {
//            binding.btnCoreUtility.setBackgroundResource(R.drawable.btnsolidrounded)
//            binding.btnCoreUtility.setTextColor(Color.WHITE)
//            binding.btnReport.setBackgroundResource(R.drawable.btnroundedoutline)
//            binding.btnReport.setTextColor(Color.BLACK)
//            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
//                CoreUtilityFragment(),"core_utility_report")
//                .commit()
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(android.R.id.home == item.itemId){
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}