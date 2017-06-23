package assignment.com.kotlinlearn

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by anudeep on 08/06/17.
 */
class TestRecyclerAdapter(items: List<String>) : RecyclerView.Adapter<TestRecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder!!.txtView.text = items.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val view = parent!!.easyInflate(R.layout.list_item)
        val viewHolder: ViewHolder = ViewHolder(view)
        return viewHolder
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtView: TextView = view.findViewById(R.id.txt) as TextView
    }

    val items = items
}




