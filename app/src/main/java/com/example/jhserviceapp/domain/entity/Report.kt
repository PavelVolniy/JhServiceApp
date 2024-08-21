package com.example.jhserviceapp.domain.entity

interface Report {
    val id: Long?
    val numberLoader: String
    val date: Long
    val hours: Int
    val description: String
    val userName: String
    val userNumber: String
    val placeOfOperations: String
    val typeOfOperations: String
    val internalComments: String
}