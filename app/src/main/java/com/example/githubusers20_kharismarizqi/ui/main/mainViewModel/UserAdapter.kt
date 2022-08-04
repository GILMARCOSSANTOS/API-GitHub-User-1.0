package com.example.githubusers20_kharismarizqi.ui.main.mainViewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.githubusers20_kharismarizqi.R
import com.example.githubusers20_kharismarizqi.ui.data.model.User
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val context: Context
        get() {
            TODO()
        }
    private val list = ArrayList<User>()

    fun setList(user: ArrayList<User>) {
        list.clear()
        list.addAll(user)
        notifyDataSetChanged()
    }


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.apply {
                Glide.with(itemView)
                    .load(user.avatar)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(imgVw_search_actvtMain_id)
                txtVw_userName_itemUser_id.text = user.login
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val itemGitHub = LayoutInflater.from(context).inflate(
            R.layout.item_user,
            parent, false
        )
        val holder = UserViewHolder(itemGitHub)
        return holder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}