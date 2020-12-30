package com.example.android4a.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.android4a.data.local.models.UserLocal

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM users WHERE email LIKE :email  AND password LIKE :password LIMIT 1")
    fun findByName(email: String,password: String): UserLocal?

    @Insert
    fun insert(vararg users: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}