package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.awesomedialog.*
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityTourProgramBinding
import com.niyoinsfa.app.view.fragments.AddDoctorDcrFragment
import com.niyoinsfa.app.view.fragments.AddProgramFragment
import com.niyoinsfa.app.view.fragments.ViewDoctorDcrFragment
import com.niyoinsfa.app.view.fragments.ViewProgramFragment

class TourProgramActivity : BaseActivity() {

    private lateinit var binding:ActivityTourProgramBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTourProgramBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_tour_program),binding.toolbar, titleColor = Color.WHITE)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,AddProgramFragment(),"add_program")
            .commit()

        binding.addBtn.setOnClickListener {
            binding.addBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.addBtn.setTextColor(Color.WHITE)
            binding.viewBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.viewBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                AddProgramFragment(),"add_program")
                .commit()

        }

        binding.viewBtn.setOnClickListener {
            binding.viewBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.viewBtn.setTextColor(Color.WHITE)
            binding.addBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.addBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                ViewProgramFragment(),"view_program")
                .commit()
        }

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AwesomeDialog.build(this@TourProgramActivity)
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