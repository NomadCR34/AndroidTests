package com.example.esperssotest

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class ActivityDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        findViewById<Button>(R.id.btnDialog).setOnClickListener {
            showDialog()
        }
    }

    fun showDialog(){
        val builder: AlertDialog.Builder = this.let {
            AlertDialog.Builder(it)
        }
        builder.setTitle(R.string.name).setMessage(R.string.enterName)
        val inflater = LayoutInflater.from(this)
        val dialogView: View = inflater.inflate(R.layout.dialog_with_edittext, null)
        val editDialogField = dialogView.findViewById<EditText>(R.id.edtDialogField)
        editDialogField.hint = resources.getString(R.string.name)
        builder.setView(dialogView)
        builder.setCancelable(false)
        builder.setNegativeButton("Cancel", null)
        builder.setPositiveButton(R.string.enter) { dialog, id ->
            val name = editDialogField.text.toString()
            if(name.isNotEmpty()) {
                findViewById<TextView>(R.id.txtName).text = name
                dialog.dismiss()
                Toast.makeText(this,buildToastMessage(name),Toast.LENGTH_SHORT).show()
            }
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    companion object{
        fun buildToastMessage(value:String):String{
            return "Your naem is $value."
        }
    }
}