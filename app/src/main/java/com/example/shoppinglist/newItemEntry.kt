package com.example.shoppinglist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun NewShoppingItem(
    item: ItemData,
    onEdit: () -> Unit,
    onDelete: () -> Unit
){
    Row(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                BorderStroke(2.dp, Color(0xFF7430A9)),
                RoundedCornerShape(30)
            ),
        Arrangement.SpaceEvenly
    ){
        Text(item.name, Modifier.padding(4.dp))
        Text("${item.quantity} ${item.unit}", Modifier.padding(4.dp))
        IconButton({onEdit}) {
            Icon(Icons.Default.Edit, null)
        }
        IconButton({onDelete}) {
            Icon(Icons.Default.Delete, null)
        }
    }


}
