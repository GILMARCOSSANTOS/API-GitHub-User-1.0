package com.example.githubusers20_kharismarizqi.ui.main

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers20_kharismarizqi.R
import com.example.githubusers20_kharismarizqi.ui.main.mainViewModel.MainViewModel
import com.example.githubusers20_kharismarizqi.ui.main.mainViewModel.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*Global declare variables: */
    private var viewModel: MainViewModel? = null
    private var adapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* https://www.youtube.com/watch?v=g8rd5wAmjnw */

        /* Functions: */
        hideActionBar()
        centerActionBar()
        imageViewSearchUser()
        editTexWriteUser()
        getSearchUser()
        recyclerViewSettings()
        settings()
    }

    private fun settings() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
    }

    private fun recyclerViewSettings() {
        adapter = UserAdapter()
        adapter!!.notifyDataSetChanged()
        rcclrVw_actvtMain_id.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcclrVw_actvtMain_id.setHasFixedSize(true)
        rcclrVw_actvtMain_id.adapter = adapter
    }

    private fun imageViewSearchUser() {
        imgVw_search_actvtMain_id.setOnClickListener {
            searchUser()
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            prgrssBar_actvtMain_id.visibility = View.VISIBLE
        } else {
            prgrssBar_actvtMain_id.visibility = View.GONE
        }
    }

    private fun getSearchUser() {
        viewModel?.getSearchUsers()?.observe(this) {
            if (it != null) {
                adapter?.setList(it)
                showLoading(false)
            }
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
        viewModel?.setSearchUsers(query)
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