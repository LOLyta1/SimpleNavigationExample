package com.example.simplenavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_input_data.view.*
class InputDataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input_data, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.send_button.setOnClickListener {
            val count= navArgs<InputDataFragmentArgs>().value.count

            val action=InputDataFragmentDirections.actionInputDataFragmentToDataViewFragment(view.name_edit_text.text.toString(),count)
             view.findNavController().navigate(action)
        }
    }
}
