package com.example.fragmentviewmodelpersistencia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import com.example.fragmentviewmodelpersistencia.databinding.FragmentBBinding

class BFragment : Fragment() {
    private var _binding: FragmentBBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val model: SharedViewModel by activityViewModels()
/* private  val model: SharedViewModel by navGraphViewModels(R.id.nav_graph)*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment

        binding.button2.setOnClickListener {
            val a =Item("a ${model.selected.value?.size}",2)
            model.selected.value?.add(a)
            it.findNavController().navigate(R.id.action_BFragment_to_AFragment)
        }


        model.selected.observe(viewLifecycleOwner, { item ->
            binding.textView.text = item[item.size-1].a
        })
        return view
    }


}