package com.vmodev.c18_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tiet_question.text = null
        tiet_question.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 30) {
                til_question.error = getString(R.string.error)
            } else if (text.length <= 30) {
                til_question.error = null
            }
        }

        btn_send_question.setOnClickListener {
            val intent = Intent(this, AnswerActivity::class.java).apply {
                putExtra("question", tiet_question.text.toString())
            }
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if((requestCode == REQUEST_CODE) && (resultCode== RESULT_OK)){
            tv_answer.text = data!!.extras!!.getString("returnData")
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}