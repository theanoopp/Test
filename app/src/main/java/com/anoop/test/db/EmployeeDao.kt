package com.anoop.test.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.anoop.test.model.Employee


@Dao
interface EmployeeDao {

    //Create
    @Insert(onConflict = REPLACE)
    fun insert(employee: Employee)

    //read
    @Query("SELECT * FROM Employee WHERE id = :id")
    fun getById(id: String): Employee

    //update
    @Query("UPDATE Employee SET name =:name, phone =:phone, email =:email,address=:address WHERE id =:id")
    fun update(id: Long, name: String, phone: String, email: String, address: String)

    @Delete
    fun delete(employee: Employee)


    //this method returns messages by conversation id
    @Query("SELECT * FROM Employee")
    fun getAllEmployee(): LiveData<List<Employee>>


}