package com.example.anothertest.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.anothertest.Constants
import com.example.anothertest.R
import com.example.anothertest.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Safe call ?.
        // Safe call with let ?.let { }
        val bundle: Bundle? = intent.extras

        // if Bundle becomes null, then the statement will not be executed
        // No null pointer exception - it's avoided
        bundle?.let {
            val msg = bundle.getString(Constants.USER_MSG_KEY)

            //replaced by showtoast extension
            //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            showToast(msg.toString())
            txt_usr_msg.text = msg
        }
    }
}