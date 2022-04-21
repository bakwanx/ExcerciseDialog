package com.example.excercisedialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment


class ExampleDialog() : DialogFragment() {
    // TODO: Rename and change types of parameters
    lateinit var name: String
    lateinit var btnTutup: Button
    constructor(name: String):this(){
        this.name = name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_example_dialog, container, false)
        btnTutup = view.findViewById(R.id.btn_tutup)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnTutup.setOnClickListener {
            Toast.makeText(activity,"Ini dialog fragment ditutup", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }

    }


}