package com.example.simplenavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_nested_one.view.*

class NestedFragmentOne : Fragment() {
    private var counter=0
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nested_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.counter_text_view.setText(counter.toString())

        view.send_count_button.setOnClickListener {
            val action=NestedFragmentOneDirections.actionNestedFragmentOne2ToNestedFragmentTwo2(counter)
            view.findNavController().navigate(action)
        }


        view.plus_image_button.setOnClickListener {
            counter++
            view.counter_text_view.setText(counter.toString())
        }

        view.minus_image_button.setOnClickListener {
            counter--
            view.counter_text_view.setText(counter.toString())
        }
    }

}
