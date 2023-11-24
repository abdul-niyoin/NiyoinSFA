package com.niyoinsfa.app.view.fragments

import android.Manifest
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.IBinder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.niyoinsfa.app.R
import com.niyoinsfa.app.adapters.CustomAdapter
import com.niyoinsfa.app.databinding.FragmentAddDoctorBinding
import com.niyoinsfa.app.services.LocationService
import com.niyoinsfa.app.utils.Constants
import com.niyoinsfa.app.utils.MultiSpinner
import com.permissionx.guolindev.PermissionX
import java.util.*


class AddDoctorFragment : Fragment() ,MultiSpinner.MultiSpinnerListener{

    private lateinit var binding: FragmentAddDoctorBinding
    private var locationService: LocationService? = null
    private var isBound = false
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as LocationService.LocalBinder
            locationService = binder.getService()
            isBound = true

            locationService?.requestSingleLocationUpdate(object : LocationService.LocationListener {
                override fun onLocationResult(location: Location) {
                    // Handle the location result
                    // You can use location.latitude and location.longitude here
                    val latitude = location.latitude
                    val longitude = location.longitude
                    binding.btnLatitude.text = "$latitude"
                    binding.btnLongitude.text = "$longitude"
                }

                override fun onLocationUnavailable() {
                    // Handle the case where the location is unavailable
                }
            })
        }

        override fun onServiceDisconnected(p0: ComponentName?) {

        }
    }
    private var dateType = 0
    private var timeType = 0
    private var daysList = Constants.daysList
    val selectedItems = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkLocationPermission()) {
            bindLocationService()
        } else {
            PermissionX.init(requireActivity())
                .permissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .request { allGranted, grantedList, deniedList ->
                    if (allGranted) {
                        bindLocationService()
                        //Toast.makeText(this, "Location permission granted successfully", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(requireActivity(), "Permission Deny", Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }
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

                if (dateType == 0) {
                    binding.doaTv.text = selectedDate
                } else {
                    binding.dobTv.text = selectedDate
                }
            },
            year, month, day
        )

        datePickerDialog.show()
    }

    private fun openTimePicker() {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        // Create a TimePickerDialog
        val timePickerDialog = TimePickerDialog(
            requireActivity(),
            TimePickerDialog.OnTimeSetListener { view: TimePicker?, selectedHour: Int, selectedMinute: Int ->
                // Do something with the selected time
                val selectedTime = "$selectedHour:$selectedMinute"
                // You can use selectedTime as needed
                if (timeType == 0) {
                    binding.timeFromTv.text = selectedTime
                } else {
                    binding.timeToTv.text = selectedTime
                }
            },
            hour,
            minute,
            true // set to true if you want 24-hour format
        )

        // Show the TimePickerDialog
        timePickerDialog.show()
    }

    private fun checkLocationPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            requireActivity(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun bindLocationService() {
        val intent = Intent(requireActivity(), LocationService::class.java)
        requireActivity().bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddDoctorBinding.inflate(layoutInflater, container, false)

        binding.state11SpecializeRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            // checkedId is the RadioButton ID that is currently selected
            when (checkedId) {
                R.id.state11_radio_button -> {
                    binding.focusProductWrapper.visibility = View.VISIBLE

                }
                R.id.specialized_wise_radio_button -> {
                    binding.focusProductWrapper.visibility = View.GONE
                }

            }
        }

        binding.doaCalendarView.setOnClickListener {
            dateType = 0
            openDatePicker()
        }

        binding.dobCalendarView.setOnClickListener {
            dateType = 1
            openDatePicker()
        }

        binding.timeFromClockView.setOnClickListener {
            timeType = 0
            openTimePicker()
        }

        binding.timeToClockView.setOnClickListener {
            timeType = 1
            openTimePicker()
        }

//        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, daysList)
//
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.select_dialog_multichoice)
//
//        binding.daysSpinner.adapter = adapter
//        binding.daysSpinner.setSelection(0, false)
//        binding.daysSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parentView: AdapterView<*>?,
//                selectedItemView: View?,
//                position: Int,
//                id: Long
//            ) {
//                // Handle item selection if needed
//            }
//
//            override fun onNothingSelected(parentView: AdapterView<*>?) {
//                // Do nothing here
//            }
//        })
//
//        binding.daysSpinner.setOnTouchListener { _, event ->
//            if (event.action == MotionEvent.ACTION_UP) {
//                binding.daysSpinner.performClick()
//            }
//            false
//        }

        binding.daysSpinner.setItems(daysList,"Select",this)

//        binding.daysSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parentView: AdapterView<*>?,
//                selectedItemView: View?,
//                position: Int,
//                id: Long
//            ) {
//                val selectedItem = daysList[position]
//                if (selectedItems.contains(selectedItem)) {
//                    selectedItems.remove(selectedItem)
//                } else {
//                    selectedItems.add(selectedItem)
//                }
//
//                Toast.makeText(
//                    requireActivity(),
//                    "Selected Items: ${selectedItems.joinToString()}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//
//            override fun onNothingSelected(parentView: AdapterView<*>?) {
//                // Do nothing here
//            }
//        })

        return binding.root
    }

    override fun onItemsSelected(selected: BooleanArray?) {

    }


}