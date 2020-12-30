package com.example.android4a.domain.usecase

import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User){
        userRepository.createUser(user)
    }
}