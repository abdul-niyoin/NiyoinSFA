package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.awesomedialog.*
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityDoctorBinding
import com.niyoinsfa.app.view.fragments.AddDoctorDcrFragment
import com.niyoinsfa.app.view.fragments.AddDoctorFragment
import com.niyoinsfa.app.view.fragments.ViewDoctorDcrFragment
import com.niyoinsfa.app.view.fragments.ViewDoctorFragment

class DoctorActivity : BaseActivity() {

    private lateinit var binding:ActivityDoctorBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_doctor),binding.toolbar, titleColor = Color.WHITE)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,
            AddDoctorFragment(),"add_doctor")
            .commit()

        binding.addBtn.setOnClickListener {
            binding.addBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.addBtn.setTextColor(Color.WHITE)
            binding.viewBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.viewBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                AddDoctorFragment(),"add_doctor")
                .commit()
        }

        binding.viewBtn.setOnClickListener {
            binding.viewBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.viewBtn.setTextColor(Color.WHITE)
            binding.addBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.addBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                ViewDoctorFragment(),"view_doctor")
                .commit()
        }

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AwesomeDialog.build(this@DoctorActivity)
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