package com.niyoinsfa.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.niyoinsfa.app.R

class CustomAdapter(context: Context, resource: Int, objects: List<String>) :
    ArrayAdapter<String>(context, resource, objects) {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private class ViewHolder {
        lateinit var checkBox: CheckBox
        lateinit var textView: TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_item, parent, false)
            viewHolder = ViewHolder()
            viewHolder.checkBox = view.findViewById(R.id.checkBox)
            viewHolder.textView = view.findViewById(R.id.textView)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = getItem(position)
//        if (item != null) {
//            viewHolder.checkBox.isChecked = false // Set the initial state of checkboxes
//            viewHolder.textView.text = item
//        }

        return view
    }
}