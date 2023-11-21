package com.niyoinsfa.app.view.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.FragmentAddDoctorDcrBinding
import com.niyoinsfa.app.view.activities.BaseActivity
import java.util.*


class AddDoctorDcrFragment : Fragment() {

    private lateinit var binding:FragmentAddDoctorDcrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddDoctorDcrBinding.inflate(inflater, container, false)

        binding.selectedTpView.text = BaseActivity.todayCurrentDateFormatted()
        binding.dateCalendar.setOnClickListener {
            openDatePicker()
        }

        binding.indvJointGroup.setOnCheckedChangeListener { group, checkedId ->
            // The checkedId parameter is the ID of the RadioButton that was selected.
            when (checkedId) {
                R.id.individual_radio_btn -> {
                    binding.jointNameWrapper.visibility = View.GONE
                }
                R.id.joint_radio_btn -> {
                    binding.jointNameWrapper.visibility = View.VISIBLE
                }
            }
        }

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

        datePickerDialog.show()
    }
}