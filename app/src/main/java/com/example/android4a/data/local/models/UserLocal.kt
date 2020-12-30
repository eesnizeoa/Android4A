package com.example.android4a.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android4a.domain.entity.User

@Entity(tableName = "users")
data class UserLocal(
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
){
    @PrimaryKey (autoGenerate = true) var uid: Int?=null
}

fun User.toData() : UserLocal {
    return UserLocal(
        email = this.email,
        password = this.password
    )
}

fun UserLocal.toEntity() : User {
    return User(
        email = this.email,
        password = this.password
    )
}