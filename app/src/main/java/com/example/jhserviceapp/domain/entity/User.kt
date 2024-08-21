package com.example.jhserviceapp.domain.entity

class User(
    val number: String,
    val name: String,
) {
    override fun toString(): String {
        return "$number,$name"
    }
}

