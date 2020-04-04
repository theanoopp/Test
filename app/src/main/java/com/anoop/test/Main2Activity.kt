package com.anoop.test

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anoop.test.db.EmpViewModel
import com.anoop.test.model.Employee
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), EmpAdapter.AdapterInterface {

    private lateinit var viewModel: EmpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar!!.title = "CRUD"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(EmpViewModel::class.java)

        emp_list.setHasFixedSize(true)
        emp_list.layoutManager = LinearLayoutManager(this)
        emp_list.recycledViewPool.setMaxRecycledViews(1, 0)

        val list: ArrayList<Employee> = ArrayList()


        val adapter = EmpAdapter(list, this, this)
        emp_list.adapter = adapter

        viewModel.getAll().observe(this@Main2Activity, Observer {

            adapter.addItems(it)
        }
        )

        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddEmployeeActivity::class.java))
        }
    }

    override fun onDelete(employee: Employee) {
        viewModel.delete(employee)
    }

    override fun onUpdate(employee: Employee) {
        val intent = Intent(this,AddEmployeeActivity::class.java)
        intent.putExtra("name",employee.name)
        intent.putExtra("phone",employee.phone)
        intent.putExtra("email",employee.email)
        intent.putExtra("address",employee.address)
        intent.putExtra("id",employee.id)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            super.onBackPressed()
        }

        return true
    }

}
