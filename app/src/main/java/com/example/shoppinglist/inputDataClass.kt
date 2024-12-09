package com.example.shoppinglist

data class ItemData(
    var id: Int,
    var name: String,
    var quantity: Int,
    var unit: String,
    var isEditing: Boolean = true
)