package com.example.simplenavigation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_nested_one.view.*

class NestedFragmentOne : Fragment() {
    private var counter = 0
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
            val action =
                NestedFragmentOneDirections.actionNestedFragmentOne2ToNestedFragmentTwo2(counter)
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

        //DEEP LINKS
        view.open_input_data_fragment.setOnClickListener {
            when (view.deep_link_radio_group.checkedRadioButtonId) {
                R.id.explicit_radio_button -> {
                    try {
                        val pendingIntent = NavDeepLinkBuilder(context!!)
                            .setGraph(R.navigation.nav_graph)
                            .setDestination(R.id.inputDataFragment)
                            .setArguments(Bundle().apply {
                                putString("name", "nooone")
                                putInt("count", counter)
                            })
                            .createPendingIntent()
                            .send()
                    } catch (ex: Exception) {
                        Toast.makeText(context, "Ошибка ${ex.message}", Toast.LENGTH_LONG).show()
                    }
                }

                R.id.impicit_radio_button -> {
                    try {
                        val deepLink =
                            Uri.parse("app://com.example.simplenavigation/inputDataFragment/$counter")
                        findNavController().navigate(deepLink)
                    } catch (ex: Exception) {
                        Toast.makeText(context, "Ошибка ${ex.message}", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }

}
