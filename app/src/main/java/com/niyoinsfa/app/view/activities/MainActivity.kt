package com.niyoinsfa.app.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding:ActivityMainBinding

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this


        binding.tourProgramCard.setOnClickListener {
            startActivity(Intent(context,TourProgramActivity::class.java))
        }

        binding.doctorDcrCard.setOnClickListener {
            startActivity(Intent(context,DoctorDcrActivity::class.java))
        }

        binding.chemistDcrCard.setOnClickListener {
            startActivity(Intent(context,ChemistDcrActivity::class.java))
        }

        binding.stockistDcrCard.setOnClickListener {
            startActivity(Intent(context,StockistDcrActivity::class.java))
        }

        binding.expenseCard.setOnClickListener {
            startActivity(Intent(context,ExpenseActivity::class.java))
        }

        binding.extraActivityCard.setOnClickListener {
            startActivity(Intent(context,ExtraActivityActivity::class.java))
        }

        binding.edetailingCard.setOnClickListener {
            startActivity(Intent(context,EDetailingActivity::class.java))
        }

        binding.reportsCard.setOnClickListener {
            startActivity(Intent(context,ReportActivity::class.java))
        }

        binding.utilityCard.setOnClickListener {
            startActivity(Intent(context,UtilityActivity::class.java))
        }

        binding.giftSampleCard.setOnClickListener {
            startActivity(Intent(context,GiftSampleActivity::class.java))
        }

    }
}