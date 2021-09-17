package com.vmodev.c18_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.activity_main.*

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        tiet_answer.text = null
        tiet_answer.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 30) {
                til_answer.error = getString(R.string.error)
            } else if (text.length <= 30) {
                til_answer.error = null
            }
        }
        val bundle = intent.extras
        if(bundle!=null)
        {
            tv_question.text = bundle.getString("question")
        }
        btn_send_answer.setOnClickListener {
            finish()
        }
    }

    override fun finish() {
        val intent = Intent()
        intent.putExtra("returnData", tiet_answer.text.toString())
        setResult(RESULT_OK, intent)
        super.finish()
    }
}