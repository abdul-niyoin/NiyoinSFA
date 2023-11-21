package com.niyoinsfa.app.view.activities

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.ActivityLeaveApplicationBinding
import java.util.*

class LeaveApplicationActivity : BaseActivity() {

    private lateinit var binding:ActivityLeaveApplicationBinding

    private lateinit var context: Context

    private var calendarType = "from"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaveApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.leave_application),binding.toolbar, titleColor = Color.WHITE)

        binding.fromDateCalendar.setOnClickListener {
            calendarType = "from"
            showDatePickerDialog()
        }

        binding.toDateCalendar.setOnClickListener {
            calendarType = "to"
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, day ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, day)
                // Handle the selected date
                // Here, you can update a TextView or perform any action with the selected date
                if(calendarType == "from"){
                   binding.fromDateTv.text = "$day/${month+1}/$year"
                }
                else{
                    binding.toDateTv.text = "$day/${month+1}/$year"
                }
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
}