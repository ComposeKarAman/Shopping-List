package com.example.shoppinglist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Ui(modifier: Modifier) {

//enable variables
    var qtyEnabled by remember { mutableStateOf(false) }
    var unitEnable by remember { mutableStateOf(false) }
    var enableQuantity by remember { mutableStateOf(false) }
    var alertEnable by remember { mutableStateOf(false) }
//lazyColumn variables
    var sItems by remember{ mutableStateOf(listOf<ItemData>())}
//  outlinedTextField Variables
    var itemName by remember { mutableStateOf("") }
    var ipQuantity by remember { mutableStateOf("") }
//  dropdown Variables
    var dropdownQty by remember { mutableIntStateOf(1) }
    var dropDisplayBtn by remember { mutableStateOf("1") }
    var dropdownUnit by remember { mutableStateOf("Qty") }

//UI starts here
    Column(modifier.fillMaxSize()) {
        Button({
            alertEnable = true
            itemName = ""
            ipQuantity = ""
            dropdownQty = 1
            dropDisplayBtn = "1"
            dropdownUnit = "Qty"
            enableQuantity = false
        },
            Modifier.align(Alignment.CenterHorizontally)) {
            Text("Add Item")
        }

        /*LazyColumn the container that holds and manages the list*/
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            /*items(listOfItems) tells the LazyColumn what data to display*/
            items(sItems) {
                /*(variable name) x -> /*code*/ is where you define how each item in the list should look and behave*/
                itemVar ->
                if (itemVar.isEditing){
                    EditFunction(
                        item = itemVar,
                        onEditDone = { editedName, editedQuantity, editUnit ->
                        sItems = sItems.map { it.copy(isEditing = false) }
                        val editedItem = sItems.find { it.id == itemVar.id }
                        editedItem?.let {
                            it.name = editedName
                            it.quantity = editedQuantity
                            it.unit = editUnit
                        }
                    })
                }else{
                    NewShoppingItem(itemVar,
                        onEdit = {
                        sItems = sItems.map { it.copy(isEditing = it.id == itemVar.id) }
                    },
                        onDelete = {
                        sItems = sItems - itemVar
                    })
                }
            }
        }
        }


        if (alertEnable) {
            AlertDialog(
                {alertEnable = false },

                { Row(
                    modifier.fillMaxWidth(),
                    Arrangement.SpaceBetween) {

//              CONFIRM Button
                    Button({
                        alertEnable = false

                        if(itemName.isNotEmpty()){
                            var newEntry = ItemData(
                                id = sItems.size + 1,
                                name = itemName,
                                quantity = dropdownQty,
                                unit = dropdownUnit,

                            )
                            sItems = sItems + newEntry
                        }
                    })
                    {Text("Confirm") }

//              CANCEL Button
                    Button({alertEnable = false})
                    {Text("Cancel") }
                }
                },

                title = {Text("Add Items")},

                text = {
                    Column {
                    //how lambda functions works
//                          var m: (Int) -> (Int) = {it * 5}
//                          Text(m(5).toString())

                        OutlinedTextField(
                            itemName,
                            { itemName = it },
                            label = { Text("add your item here") },
                            modifier = Modifier.padding(4.dp)
                        )

                        Text("Select Quantity")
                        Row(
                            Modifier.fillMaxWidth(),
                            Arrangement.SpaceBetween
                        ){
                            Box {
                                Button({ qtyEnabled = true }) {

                                    Text(dropDisplayBtn)
                                    Icon(
                                        Icons.Default.ArrowDropDown,
                                        contentDescription = "drop down"
                                    )
                                }
                                DropdownMenu(qtyEnabled, { qtyEnabled = false }) {
                                    DropdownMenuItem(
                                        { Text("Custom") },
                                        {
                                            qtyEnabled = false
                                            dropDisplayBtn = "Custom"
                                            enableQuantity = true
                                        })
                                    DropdownMenuItem(
                                        { Text("1") },
                                        {
                                            ipQuantity = ""
                                            dropdownQty = 1
                                            dropDisplayBtn = "1"
                                            qtyEnabled = false
                                            enableQuantity = false
                                        })
                                    DropdownMenuItem(
                                        { Text("2") },
                                        {
                                            ipQuantity = ""
                                            dropdownQty = 2
                                            dropDisplayBtn = "2"
                                            qtyEnabled = false
                                            enableQuantity = false
                                        })
                                    DropdownMenuItem(
                                        { Text("3") },
                                        {
                                            ipQuantity = ""
                                            dropdownQty = 3
                                            dropDisplayBtn = "3"
                                            qtyEnabled = false
                                            enableQuantity = false
                                        }
                                    )
                                }
                            }

                            Box{
                                Button({ unitEnable = true }) {
                                    Text(dropdownUnit)
                                    Icon(
                                        Icons.Default.ArrowDropDown,
                                        contentDescription = "drop down"
                                    )
                                }
                                DropdownMenu(unitEnable, { unitEnable = false }){
                                    DropdownMenuItem(
                                        { Text("Qty") },
                                        {
                                            dropdownUnit = "Qty"
                                            unitEnable = false
                                        }
                                    )
                                    DropdownMenuItem(
                                        { Text("Kg") },
                                        {
                                            dropdownUnit = "Kg"
                                            unitEnable = false
                                        }
                                    )
                                    DropdownMenuItem(
                                        { Text("Grm") },
                                        {
                                            dropdownUnit = "Grm"
                                            unitEnable = false
                                        }
                                    )
                                    DropdownMenuItem(
                                        { Text("Ltr") },
                                        {
                                            dropdownUnit = "Ltr"
                                            unitEnable = false
                                        }
                                    )
                                    DropdownMenuItem(
                                        {Text("Ml")},
                                        {
                                            dropdownUnit = "Ml"
                                            unitEnable = false
                                        }
                                    )
                                }
                            }
                        }

                        if (enableQuantity) {
                            OutlinedTextField(
                                ipQuantity,
                                {
                                    ipQuantity = it
                                    dropdownQty = ipQuantity.toIntOrNull() ?: 1
                                    dropDisplayBtn = ipQuantity
                                },
                                label = { Text("enter custom quantity") }
                            )
                        }
                    }
                }
            )
        }
    }

//Preview Available here
@Preview(showBackground = true)
@Composable
fun UiPreview() {
    Ui(Modifier)
}