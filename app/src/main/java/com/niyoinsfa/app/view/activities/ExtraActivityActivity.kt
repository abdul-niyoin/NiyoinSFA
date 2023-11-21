package com.niyoinsfa.app.view.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityExtraActivityBinding
import com.niyoinsfa.app.view.fragments.AddDoctorDcrFragment
import com.niyoinsfa.app.view.fragments.AddEaFragment
import com.niyoinsfa.app.view.fragments.ViewAeFragment
import com.niyoinsfa.app.view.fragments.ViewDoctorDcrFragment

class ExtraActivityActivity : BaseActivity() {

    private lateinit var binding:ActivityExtraActivityBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityExtraActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_extra_activity),binding.toolbar, titleColor = Color.WHITE)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,
            AddEaFragment(),"add_extra_activity")
            .commit()

        binding.addBtn.setOnClickListener {
            binding.addBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.addBtn.setTextColor(Color.WHITE)
            binding.viewBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.viewBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                AddEaFragment(),"add_extra_activity")
                .commit()
        }

        binding.viewBtn.setOnClickListener {
            binding.viewBtn.setBackgroundResource(R.drawable.btnsolidrounded)
            binding.viewBtn.setTextColor(Color.WHITE)
            binding.addBtn.setBackgroundResource(R.drawable.btnroundedoutline)
            binding.addBtn.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                ViewAeFragment(),"view_extra_activity")
                .commit()
        }
    }
}