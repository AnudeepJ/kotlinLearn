package assignment.com.kotlinlearn

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by anudeep on 07/06/17.
 */
class RecyclerListAdapter(items: List<Articles>) : RecyclerView.Adapter<RecyclerListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder!!.txtView.text = items[position].title
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

fun ViewGroup.easyInflate(id: Int): View {
    val context = this.context
    val view = LayoutInflater.from(context).inflate(id, this, false)
    return view
}