package com.example.foodapp_fullstack.presentation.navigation

import kotlinx.serialization.Serializable

sealed class SubNavigation{

    @Serializable
    object LoginSignUpScreen : SubNavigation()


    @Serializable
    object MainHomeScreen : SubNavigation()

}


sealed class Routes{

    @Serializable
    object LoginScreen : Routes()

    @Serializable
    object SignUpScreen : Routes()

    @Serializable
    object DeliveryScreen : Routes()

    @Serializable
    object QuickScreen : Routes()

    @Serializable
    object DiningScreen : Routes()

    @Serializable
    object ProfileScreen : Routes()

    @Serializable
    object ParticularCardScreen : Routes()

    @Serializable
    object FinalCheckOutScreen : Routes()

    @Serializable
    object SearchBarScreen : Routes()

}