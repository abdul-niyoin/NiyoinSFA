package com.niyoinsfa.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niyoinsfa.app.databinding.UtilityItemDesignBinding
import com.niyoinsfa.app.model.Utility

class UtilityAdapter(private val context: Context,private var utilityOptions:ArrayList<Utility>):RecyclerView.Adapter<UtilityAdapter.ItemViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var mListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mListener = listener
    }

    open class ItemViewHolder(private val binding:UtilityItemDesignBinding,
                              private val mListener: OnItemClickListener):RecyclerView.ViewHolder(binding.root){

           fun dataBinding(utility: Utility,position: Int){
                 binding.utilityTitle.text = utility.title
                 if(utility.icon != 0){
                     binding.utilityIcon.setImageResource(utility.icon)
                 }
//               if (position%2 == 1){
//                   binding.root.setCardBackgroundColor(Color.parseColor("#90ee90"))
//               }
//               else{
//                   binding.root.setCardBackgroundColor(Color.parseColor("#ffffff"))
//               }
//              binding.tasbeehItemTitle.text = tasbeeh.title
//               binding.tasbeehItemNotes.text = tasbeeh.notes
//               binding.tasbeehItemCount.text = "${tasbeeh.count}"
//               if(tasbeeh.image_status == 1){
//                   Glide
//                       .with(binding.root.context)
//                       .load(tasbeeh.image)
//                       .centerCrop()
//                       .placeholder(R.drawable.random_1_green)
//                       .into(binding.tasbeehItemSelectedImage)
//               }
//               else{
//                   binding.tasbeehItemSelectedImage.setImageResource(R.drawable.random_1_green)
//               }
//               binding.tasbeehItemContinueBtn.setOnClickListener {
//                   mListener.onItemClick(layoutPosition)
//               }
//
               binding.root.setOnClickListener {
                   mListener.onItemClick(layoutPosition)
               }
           }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val bindingLayout = UtilityItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(bindingLayout,mListener!!)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = utilityOptions[position]
        holder.dataBinding(item,position)
    }

    override fun getItemCount(): Int {
        return utilityOptions.size
    }

}