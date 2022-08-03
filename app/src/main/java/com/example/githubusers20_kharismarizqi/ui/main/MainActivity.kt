package com.example.githubusers20_kharismarizqi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.githubusers20_kharismarizqi.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Functions: */
        hideActionBar()
        centerActionBar()
        imageViewSearchUser()
    }

    private fun imageViewSearchUser(){
        imgVw_search_actvtMain_id.setOnClickListener {
            if (imgVw_search_actvtMain_id.isClickable){
                Toast.makeText(this, "sdsd", Toast.LENGTH_SHORT).show()
                prgrssBar_actvtMain_id.visibility = View.VISIBLE
            }
        }
    }

    private fun centerActionBar() {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.actionbar_title_center)
    }

    private fun hideActionBar(){
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }
}