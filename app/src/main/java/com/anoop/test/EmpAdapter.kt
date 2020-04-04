package com.anoop.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.anoop.test.model.Employee


class EmpAdapter(
    private var items: List<Employee>,
    private val context: Context,
    private val callBack: AdapterInterface
) :
    RecyclerView.Adapter<EmpAdapter.EmployeeVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeVH {
        return EmployeeVH(
            LayoutInflater.from(context).inflate(
                R.layout.single_emp_item,
                parent,
                false
            )
        )
    }

    fun addItems(messageList: List<Employee>) {
        this.items = messageList
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: EmployeeVH, position: Int) {

        val item = items[position]


        holder.name.text = item.name
        holder.phone.text = item.phone
        holder.email.text = item.email
        holder.address.text = item.address

        holder.itemView.setOnClickListener {

            val options = arrayOf<CharSequence>("Update", "Delete")
            val builder = AlertDialog.Builder(holder.itemView.context)
            builder.setTitle("Employee")

            builder.setItems(options) { _, i ->
                when (i) {
                    0 -> callBack.onUpdate(item)
                    1 -> callBack.onDelete(item)
                }
            }

            builder.show()
        }

    }


    override fun getItemCount(): Int {
        return items.size
    }


    class EmployeeVH(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val phone: TextView = view.findViewById(R.id.phone)
        val email: TextView = view.findViewById(R.id.email)
        val address: TextView = view.findViewById(R.id.address)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

    interface AdapterInterface {

        fun onDelete(employee: Employee)
        fun onUpdate(employee: Employee)

    }

}