package com.example.excercisedialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {

    lateinit var btnMainStandard: Button
    lateinit var btnMainActionButton: Button
    lateinit var btnDialogFragment: Button
    lateinit var btnCustomLayout: Button
    lateinit var btnCustom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainStandard = findViewById(R.id.btn_main_standard)
        btnMainActionButton = findViewById(R.id.btn_main_action_button)
        btnDialogFragment = findViewById(R.id.btn_fragment)
        btnCustom = findViewById(R.id.btn_custom_layout)

        /*Dialog Standard & Dialog Action*/
        btnMainStandard.setOnClickListener {
            alertDialogStandard()
        }

        btnMainActionButton.setOnClickListener {
            alertDialogActionButton()
        }

        /*DIALOG CUSTOM*/
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_custom_layout, null)
        btnCustomLayout = view.findViewById(R.id.btn_dismiss_custom_dialog)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(view)
        val dialog =  dialogBuilder.create()
        btnCustom.setOnClickListener {
            dialog.show()
        }

        btnCustomLayout.setOnClickListener {
            Toast.makeText(this,"Dialog Custom Layout Ditutup", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        /*DIALOG FRAGMENT*/
        val dialogFragment = ExampleDialog()
        btnDialogFragment.setOnClickListener {
            dialogFragment.show(supportFragmentManager, null)
        }
    }

    private fun alertDialogStandard() {
        val dialog = AlertDialog.Builder(this)

        dialog.apply {
            setTitle("Hai!")
            setMessage("Semoga harimu menyenangkan :D")
            setCancelable(true)
            show()
        }
    }

    private fun alertDialogActionButton() {
        val dialog = AlertDialog.Builder(this)

        dialog.apply {
            setTitle("Facebook")
            setMessage("Apakah Anda menyukai Facebook?")
            setIcon(R.mipmap.ic_launcher)
            setCancelable(false)
            setPositiveButton("Ya") { _, _ ->
                Toast.makeText(this@MainActivity, "Anda menyukai Facebook", Toast.LENGTH_LONG).show()
            }
            setNegativeButton("Tidak") { _, _ ->
                Toast.makeText(this@MainActivity, "Anda tidak menyukai Facebook", Toast.LENGTH_LONG).show()
            }
            setNeutralButton("Lain Kali") { _, _ ->
                Toast.makeText(this@MainActivity, "Anda tidak menilai Facebook", Toast.LENGTH_LONG).show()
            }
            show()
        }
    }
}