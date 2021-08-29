package com.example.fragmentviewmodelpersistencia

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val selected = MutableLiveData<MutableList<Item>>()


    fun select() {
        var lista= mutableListOf<Item>()
        for(num in 1..5) {
            val a:Item=Item("a ${lista.size}",2)
            lista.add(a)

        }

        selected.value = lista


    }
}
