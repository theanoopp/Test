package com.anoop.test.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String,
    var phone: String,
    var email: String,
    var address: String
) : Parcelable