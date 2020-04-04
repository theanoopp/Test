package com.anoop.test.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.anoop.test.model.Employee
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class EmpViewModel(application: Application) : AndroidViewModel(application) {

    private var appDatabase: AppDatabase? = null


    init {
        appDatabase = AppDatabase.getDatabase(this.getApplication())
    }

    fun getAll(): LiveData<List<Employee>> {
        return appDatabase!!.employeeDao().getAllEmployee()
    }

    fun add(employee: Employee) {

        CoroutineScope(Dispatchers.IO).launch {

            withContext(Dispatchers.IO) {
                appDatabase!!.employeeDao().insert(employee)
            }
        }

    }

    fun delete(employee: Employee) {

        CoroutineScope(Dispatchers.IO).launch {

            withContext(Dispatchers.IO) {
                appDatabase!!.employeeDao().delete(employee)
            }
        }

    }

    fun update(id: Long, name: String, phone: String, email: String, address: String) {

        CoroutineScope(Dispatchers.IO).launch {

            withContext(Dispatchers.IO) {
                appDatabase!!.employeeDao().update(id,name,phone,email,address)
            }
        }

    }

}