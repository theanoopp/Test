package com.anoop.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.anoop.test.db.EmpViewModel
import com.anoop.test.model.Employee
import kotlinx.android.synthetic.main.activity_add_employee.*

class AddEmployeeActivity : AppCompatActivity() {

    private lateinit var viewModel: EmpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)

        viewModel = ViewModelProvider(this).get(EmpViewModel::class.java)

        if (intent.hasExtra("name")) {
            name_input.editText!!.setText(intent.getStringExtra("name"))
            phone_input.editText!!.setText(intent.getStringExtra("phone"))
            email_input.editText!!.setText(intent.getStringExtra("email"))
            address_input.editText!!.setText(intent.getStringExtra("address"))

            add_button.text = "Update"
        }


        add_button.setOnClickListener {

            val name = name_input.editText!!.text.toString()
            val phone = phone_input.editText!!.text.toString()
            val email = email_input.editText!!.text.toString()
            val address = address_input.editText!!.text.toString()

            if (intent.hasExtra("name"))
                viewModel.update(intent.getLongExtra("id", -1), name, phone, email, address)
            else
                viewModel.add(Employee(0, name, phone, email, address))

            finish()

        }
    }
}
