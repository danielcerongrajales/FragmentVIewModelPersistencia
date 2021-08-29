package com.example.fragmentviewmodelpersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.fragmentviewmodelpersistencia.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory


class MainActivity : AppCompatActivity() {
    private  val model: SharedViewModel by viewModels()/*
  private  val model: SharedViewModel by navGraphViewModels(R.id.nav_graph)*/
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
     model.select()
        model.selected.observe(this, { item ->

            Log.d("TAG", "onCreateView:$item.size")
        })

        binding.button3.setOnClickListener {
            val a =Item("a ${model.selected.value?.size}",2)
            model.selected.value?.add(a)
            model.selected.value = model.selected.value
            /*it.findNavController().navigate(R.id.action_AFragment_to_BFragment)*/

        }

    }
}