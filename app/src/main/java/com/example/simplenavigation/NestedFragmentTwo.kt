package com.example.simplenavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_nested_two.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class NestedFragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.fragment_nested_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val argument = navArgs<NestedFragmentTwoArgs>().value.value
        view.received_count_text_view.text = argument.toString()

        view.send_received_count_button.setOnClickListener {
            val action =  NestedFragmentTwoDirections.actionNestedFragmentTwo2ToInputDataFragment(argument)
            findNavController().navigate(action)
        }
    }

}
