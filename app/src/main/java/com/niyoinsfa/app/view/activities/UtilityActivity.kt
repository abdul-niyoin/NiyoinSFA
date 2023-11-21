package com.niyoinsfa.app.view.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.niyoinsfa.app.R
import com.niyoinsfa.app.adapters.UtilityAdapter
import com.niyoinsfa.app.databinding.ActivityUtilityBinding
import com.niyoinsfa.app.model.Utility
import com.niyoinsfa.app.utils.Constants

class UtilityActivity : BaseActivity() {

    private lateinit var binding:ActivityUtilityBinding

    private lateinit var context: Context

    private lateinit var adapter: UtilityAdapter

    private var utilities = mutableListOf<Utility>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtilityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        setUpToolbar(getString(R.string.lbl_utility),binding.toolbar,true, titleColor = Color.WHITE)

        utilities.add(Utility("Add Doctor","add-doctor",R.drawable.adddoctor))
        utilities.add(Utility("Add Chemist","add-chemist",R.drawable.addchemist))
        utilities.add(Utility("Add Stockist","add-stockist",R.drawable.addstockist))
        utilities.add(Utility("Add Area","add-area",R.drawable.addarea))
        utilities.add(Utility("Update Doctor Location","update-doctor-location",R.drawable.updatedoctorlocation))
        utilities.add(Utility("Update Chemist Location","update-chemist-location",R.drawable.updatechemistlocation))
        utilities.add(Utility("Update Stockist Location","update-stockist-location",R.drawable.updatestockistlocation))
        utilities.add(Utility("Leave Application","leave-application",R.drawable.leaveicon))
        utilities.add(Utility("Change Password","change-password",R.drawable.reset_password))
        utilities.add(Utility("Online Help","online-help",R.drawable.online_help))

        binding.utilityRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.utilityRecyclerview.hasFixedSize()
        adapter = UtilityAdapter(context,utilities as ArrayList<Utility>)
        binding.utilityRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object :UtilityAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val item = utilities[position]
                when(item.slug){
                    "add-doctor"->{
                        startActivity(Intent(context,DoctorActivity::class.java))
                    }
                    "add-chemist"->{
                        startActivity(Intent(context,ChemistActivity::class.java))
                    }
                    "add-stockist"->{
                        startActivity(Intent(context,StockistActivity::class.java))
                    }
                    "add-area"->{
                        startActivity(Intent(context,AddAreaActivity::class.java))
                    }
                    "update-doctor-location"->{
                        startActivity(Intent(context,UpdateLocationActivity::class.java).apply {
                            putExtra("TYPE","doctor")
                        })
                    }
                    "update-chemist-location"->{
                        startActivity(Intent(context,UpdateLocationActivity::class.java).apply {
                            putExtra("TYPE","chemist")
                        })
                    }
                    "update-stockist-location"->{
                        startActivity(Intent(context,UpdateLocationActivity::class.java).apply {
                            putExtra("TYPE","stockist")
                        })
                    }
                    "leave-application"->{
                        startActivity(Intent(context,LeaveApplicationActivity::class.java))
                    }
                    "change-password"->{
                        startActivity(Intent(context,ChangePasswordActivity::class.java))
                    }
                    "online-help"->{
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(Constants.onlineHelpUrl)
                        startActivity(intent)
                    }
                    else->{

                    }
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(android.R.id.home == item.itemId){
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}