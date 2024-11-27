package com.example.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.shoppinglist.ui.theme.ShoppingListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingListTheme {
                Scaffold(Modifier.fillMaxSize()) { innerPadding ->
                    Ui(Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



class x
{
    fun s() {

        val name: String? = "strip"
        println(name?.let { it.uppercase() })
        println(name)
    }

    fun main(){
        val obj = x()
    }
}


