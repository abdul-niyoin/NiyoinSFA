import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import com.niyoinsfa.app.R
import com.niyoinsfa.app.model.Option

class OptionsAdapter(private val options: List<Option>) : RecyclerView.Adapter<OptionsAdapter.ViewHolder>() {

    private var selectedOptionId: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_option_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val option = options[position]
        holder.bind(option,position)
    }

    override fun getItemCount(): Int {
        return options.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val radioGroup: RadioGroup = itemView.findViewById(R.id.radio_group)
        private val radioOption: RadioButton = itemView.findViewById(R.id.radio_option)
//        private val textOption: TextView = itemView.findViewById(R.id.text_option)

        fun bind(option: Option,position: Int) {
            radioOption.text = option.text
            radioOption.isChecked = position == selectedOptionId

            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val copyOfLastCheckedPosition: Int = selectedOptionId
                selectedOptionId = layoutPosition
                itemView.post {
                    notifyItemChanged(copyOfLastCheckedPosition)
                    notifyItemChanged(selectedOptionId)
                }

            }
        }
    }
}