package com.niyoinsfa.app.view.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.niyoinsfa.app.R
import com.niyoinsfa.app.databinding.FragmentAddChemistDcrBinding
import com.niyoinsfa.app.view.activities.BaseActivity
import java.util.*


class AddChemistDcrFragment : Fragment() {

    private lateinit var binding:FragmentAddChemistDcrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddChemistDcrBinding.inflate(inflater, container, false)
        binding.selectedTpView.text = BaseActivity.todayCurrentDateFormatted()
        binding.dateCalendar.setOnClickListener {
            openDatePicker()
        }
        openDatePicker()


        binding.pobDetailsRadioButton.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
                if(isChecked){
                    binding.productwiseLumpsumRadioGroup.visibility = View.VISIBLE
                }
            }
        })

        binding.productwiseLumpsumRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            // checkedId is the RadioButton ID that is currently selected
            when (checkedId) {
                R.id.products_wise_radio_button -> {
                   binding.productwiseChildOptionsRadioGroup.visibility = View.VISIBLE
                   binding.lumpsumDetailWrapper.visibility = View.GONE

                }
                R.id.lumpsum_radio_button -> {
                    binding.lumpsumDetailWrapper.visibility = View.VISIBLE
                    binding.productwiseChildOptionsRadioGroup.visibility = View.GONE
                }

            }
        }

        binding.productwiseChildOptionsRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            // checkedId is the RadioButton ID that is currently selected
            when (checkedId) {
                R.id.direct_radio_button -> {
                    // open dialog
                     binding.qtyrateChildOptionsRadioGroup.visibility = View.GONE
                    val dialogFragment = SearchDialogFragment()
                    dialogFragment.show(childFragmentManager, "SearchDialogFragment")
                }
                R.id.qty_rate_radio_button -> {
                    binding.qtyrateChildOptionsRadioGroup.visibility = View.VISIBLE
                }

            }
        }

        binding.qtyrateChildOptionsRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            // checkedId is the RadioButton ID that is currently selected
            when (checkedId) {
                R.id.mrp_radio_button-> {
                    // open dialog
//                    binding.directChildOptionsRadioGroup.visibility = View.GONE
//                    val dialogFragment = SearchDialogFragment()
//                    dialogFragment.show(childFragmentManager, "SearchDialogFragment")
                }
                R.id.pts_radio_button -> {
//                    binding.directChildOptionsRadioGroup.visibility = View.VISIBLE
                }
                R.id.ptr_radio_button->{
                    val dialogFragment = SearchDialogFragment()
                    dialogFragment.show(childFragmentManager, "SearchDialogFragment")
                }
                R.id.ptss_radio_button->{
                    val dialogFragment = SearchDialogFragment()
                    dialogFragment.show(childFragmentManager, "SearchDialogFragment")
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
        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
        datePickerDialog.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}