package com.example.foodapp_fullstack.domain.useCases

import com.example.foodapp_fullstack.common.ResultState
import com.example.foodapp_fullstack.data.models.UserData
import com.example.foodapp_fullstack.domain.repo.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(val repo : Repo) {

        fun loginUser(userData : UserData) : Flow<ResultState<String>> {

            return repo.loginWithEmailAndPassword(userData)
        }
    }
