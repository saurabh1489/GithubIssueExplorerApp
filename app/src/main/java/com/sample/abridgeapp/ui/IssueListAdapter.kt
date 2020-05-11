package com.sample.abridgeapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.sample.abridgeapp.R
import com.sample.abridgeapp.vo.Issue

class IssueListAdapter(val issueList: List<Issue>): ListAdapter<Issue, IssueViewHolder>(
    AsyncDifferConfig.Builder<Issue>(object: ItemCallback<Issue>() {
        override fun areItemsTheSame(oldItem: Issue, newItem: Issue): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Issue, newItem: Issue): Boolean {
            return oldItem == newItem
        }
    }).build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout, parent,  false)
        return IssueViewHolder(view)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}