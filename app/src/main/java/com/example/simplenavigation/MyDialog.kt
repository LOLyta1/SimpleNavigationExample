package com.example.simplenavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_my_dialog.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyDialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.dialog_save_button.setOnClickListener {
            val name = navArgs<MyDialogArgs>().value.name
            val count = navArgs<MyDialogArgs>().value.count
            val action = MyDialogDirections.actionMyDialogToDataViewFragment(name, count)
            this.findNavController().navigate(action)
        }
        view.dialog_cancel_button.setOnClickListener {
            dismiss()
        }
    }

}
