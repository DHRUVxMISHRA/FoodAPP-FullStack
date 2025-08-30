package com.example.foodapp_fullstack.domain.repo


import com.example.foodapp_fullstack.common.ResultState
import com.example.foodapp_fullstack.data.models.UserData
import kotlinx.coroutines.flow.Flow

interface Repo {

    fun loginWithEmailAndPassword(userData : UserData) : Flow<ResultState<String>>
    fun registerWithEmailAndPassword(userData : UserData) : Flow<ResultState<String>>
}