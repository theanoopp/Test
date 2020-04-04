package com.anoop.test

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "API CALL"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val result = MYAsyncTask().execute("https://jsonplaceholder.typicode.com/posts/1").get()

        val obj = JSONObject(result)
        val title = obj.get("title") as String
        val body = obj.get("body") as String

        title_text.text = title
        body_text.text = body

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            super.onBackPressed()
        }

        return true
    }
}


