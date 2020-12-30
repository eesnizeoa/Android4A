package com.example.android4a.domain.usecase

import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()

    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`(){
        runBlocking {
            //GIVEN
            val email = ""
            val password = ""
            coEvery { userRepository.getUser(email,password) } returns null

            //WHEN
            val result = classUnderTest.invoke(email,password)

            //THEN
            coVerify(exactly = 1){
                userRepository.getUser(email,password)
            }
            assertEquals(result,null)
        }
    }

    @Test
    fun `invoke with valid email`(){
        runBlocking {
            //GIVEN
            val email = "a@a.c"
            val password = "aac"
            val expectedUser = User("a@a.c","aac")
            coEvery { userRepository.getUser(email,password) } returns expectedUser

            //WHEN
            val result = classUnderTest.invoke(email,password)

            //THEN
            coVerify(exactly = 1){
                userRepository.getUser(email,password)
            }
            assertEquals(result,expectedUser)
        }
    }
}