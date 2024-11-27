package com.example.shoppinglist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditFunction(item: ItemData, onEditDone: (String, Int, String) -> Unit) {

//variable declare
    var changeName by remember{ mutableStateOf(item.name)}
    var changeQuantity by remember{ mutableStateOf(item.quantity.toString())}
    var changeUnit by remember{ mutableStateOf(item.unit)}
    var isEditing by remember{ mutableStateOf(item.isEditing)}

    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        Arrangement.SpaceEvenly
    ) {
        Column {
            BasicTextField(
                changeName,
                { changeName = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding()
            )
            Row(Modifier.padding(4.dp)) {
                BasicTextField(
                    changeQuantity,
                    { changeQuantity = it },
                    singleLine = true,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding()
                )

                BasicTextField(
                    changeUnit,
                    { changeUnit = it },
                    singleLine = true,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding()
                )
            }

            Button({
                onEditDone(changeName, changeQuantity.toIntOrNull() ?: 1, changeUnit)
            }) { Text("Save") }
        }

    }
}