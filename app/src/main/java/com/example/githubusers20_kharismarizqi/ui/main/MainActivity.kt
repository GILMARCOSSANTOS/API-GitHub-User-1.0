package com.example.githubusers20_kharismarizqi.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers20_kharismarizqi.R
import com.example.githubusers20_kharismarizqi.ui.main.mainViewModel.MainViewModel
import com.example.githubusers20_kharismarizqi.ui.main.mainViewModel.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*Global declare variables: */
    private lateinit var viewModel: ViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* https://www.youtube.com/watch?v=g8rd5wAmjnw */

        /* Functions: */
        hideActionBar()
        centerActionBar()
        imageViewSearchUser()
        editTexWriteUser()

        /* Variables: */
        adapter = UserAdapter()
        adapter.notifyDataSetChanged()
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)

        rcclrVw_actvtMain_id.setHasFixedSize(true)
        rcclrVw_actvtMain_id.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcclrVw_actvtMain_id.adapter = adapter

    }

    private fun imageViewSearchUser() {
        imgVw_search_actvtMain_id.setOnClickListener {
            searchUser()
        }
    }

    private fun editTexWriteUser() {
        edtTxt_searchUser_actvtMain_id.setOnKeyListener { v, keycode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keycode == KeyEvent.KEYCODE_ENTER) {
                searchUser()
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    private fun searchUser() {
        val query = edtTxt_searchUser_actvtMain_id.text.toString()
        if (query.isEmpty()) return
        showLoading(true)
        viewModel.



    }

    private fun showLoading(state: Boolean) {
        if (state) {
            prgrssBar_actvtMain_id.visibility = View.VISIBLE
        } else {
            prgrssBar_actvtMain_id.visibility = View.INVISIBLE
        }
    }

    private fun centerActionBar() {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.actionbar_title_center)
    }

    private fun hideActionBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }
}