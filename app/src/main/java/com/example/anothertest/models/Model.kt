package com.example.anothertest.models

data class Hobby(var title: String)

object Supplier {

    var hobbies = listOf(
        Hobby("Swimming"),
        Hobby("Talking"),
        Hobby("Walking"),
        Hobby("Singing"),
        Hobby("Dancing"),
        Hobby("Programming"),
        Hobby("Laughing"),
        Hobby("Smiling"),
        Hobby("Jumping")
    )
}