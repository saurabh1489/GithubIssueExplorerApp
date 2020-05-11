package com.sample.abridgeapp.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sample.abridgeapp.vo.Issue
import kotlinx.android.synthetic.main.item_layout.view.*

class IssueViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(issue: Issue) {
        view.title.text = issue.title
        view.number.text = issue.number.toString()
        view.user.text = issue.user.login
        view.createdAt.text = issue.createdAt
    }

}
