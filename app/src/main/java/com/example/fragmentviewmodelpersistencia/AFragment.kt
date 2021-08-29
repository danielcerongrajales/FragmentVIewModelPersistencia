package com.example.fragmentviewmodelpersistencia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import com.example.fragmentviewmodelpersistencia.databinding.FragmentABinding


class AFragment : Fragment() {
    private var _binding: FragmentABinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

     private  val modelo: SharedViewModel by activityViewModels()
/*    private  val modelo: SharedViewModel by navGraphViewModels(R.id.nav_graph)*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentABinding.inflate(inflater, container, false)
        val view = binding.root

        binding.button.setOnClickListener {
            val a =Item("a ${modelo.selected.value?.size}",2)
            modelo.selected.value?.add(a)
            modelo.selected.value = modelo.selected.value
            it.findNavController().navigate(R.id.action_AFragment_to_BFragment)

        }
        modelo.selected.observe(this.viewLifecycleOwner, { item ->
                binding.textView2.text = item[item.size-1].a

        })

        return view

    }


}