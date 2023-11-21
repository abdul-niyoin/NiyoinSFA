package com.niyoinsfa.app.view.fragments

import OptionsAdapter
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.niyoinsfa.app.databinding.FragmentAddProgramBinding
import com.niyoinsfa.app.model.Option
import com.niyoinsfa.app.view.activities.BaseActivity
import java.util.*


class AddProgramFragment : Fragment() {
    private lateinit var binding: FragmentAddProgramBinding
    private lateinit var optionsAdapter: OptionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddProgramBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager =
            GridLayoutManager(activity, 3) // Change the span count as needed.

        val options = listOf(
            Option(1, "Working"),
            Option(2, "Meeting"),
            Option(3, "Leave/Holiday"),
            Option(4, "Camp"),
            Option(5, "Other")
            // Add more options as needed.
        )

        optionsAdapter = OptionsAdapter(options)
        binding.recyclerView.adapter = optionsAdapter

        binding.selectedTpView.text = BaseActivity.todayCurrentDateFormatted()
        binding.dateCalendar.setOnClickListener {
            openDatePicker()
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