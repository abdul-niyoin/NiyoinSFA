package com.niyoinsfa.app.view.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.FragmentAddEaBinding
import com.niyoinsfa.app.view.activities.BaseActivity
import java.util.*


class AddEaFragment : Fragment() {

    private lateinit var binding:FragmentAddEaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddEaBinding.inflate(inflater, container, false)
        binding.selectedTpView.text = BaseActivity.todayCurrentDateFormatted()
        binding.dateCalendar.setOnClickListener {
            openDatePicker()
        }
        openDatePicker()
        return binding.root
    }

    private fun openDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireActivity(),
            { view, selectedYear, selectedMonth, selectedDay ->
                // Do something with the selected date (e.g., update a TextView).
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                // You can replace this with your desired action.
                binding.selectedTpView.text = selectedDate
            },
            year, month, day
        )
        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
        datePickerDialog.show()
    }
}