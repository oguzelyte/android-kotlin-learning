package com.example.anothertest.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.util.Log
import android.widget.Toast
import com.example.anothertest.Constants
import com.example.anothertest.R
import com.example.anothertest.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

//private const val TAG = "logmsg"

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        olibutton.setOnClickListener{
            // if not in same class have to reference activity name and value MainActivity.TAG
            Log.i(TAG, "Button was clicked")

            val message: String = usermsg.text.toString()

            // remove hardcoded strings
            showToast(resources.getString(R.string.button_clicked), Toast.LENGTH_LONG)

            // replaced by show toast function
            //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            // explicit intent
            val intent = Intent(this, SecondActivity::class.java)

            // retrieve value from hardcoded constants file
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        olibutton2.setOnClickListener{
            Log.i("MainActivity", "Button was clicked")

            val message: String = usermsg.text.toString()

            // implicit intent
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to: "))
        }

        olibutton3.setOnClickListener{
            Log.i("MainActivity", "Button was clicked")

            val message: String = usermsg.text.toString()

            // implicit intent
            val intent = Intent(this, HobbiesActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        Log.i(TAG, "onCreate")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
