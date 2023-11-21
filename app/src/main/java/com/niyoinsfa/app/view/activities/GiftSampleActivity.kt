package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityGiftSampleBinding
import com.niyoinsfa.app.view.fragments.AddDoctorFragment
import com.niyoinsfa.app.view.fragments.GiftReportFragment
import com.niyoinsfa.app.view.fragments.SampleReportFragment
import com.niyoinsfa.app.view.fragments.ViewDoctorFragment

class GiftSampleActivity : BaseActivity() {

    private lateinit var binding:ActivityGiftSampleBinding

    private lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiftSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_gift_sample_report),binding.toolbar, titleColor = Color.WHITE)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,
            GiftReportFragment(),"gift_report")
            .commit()

        binding.giftWrapperLayout.setOnClickListener {
            binding.giftWrapperLayout.setBackgroundColor(getColor(R.color.primary))
            binding.sampleWrapperLayout.setBackgroundResource(R.drawable.btnsolid1)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                GiftReportFragment(),"gift_report")
                .commit()
        }

        binding.sampleWrapperLayout.setOnClickListener {
            binding.giftWrapperLayout.setBackgroundResource(R.drawable.btnsolid1)
            binding.sampleWrapperLayout.setBackgroundColor(getColor(R.color.primary))
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                SampleReportFragment(),"sample_report")
                .commit()
        }
    }
}