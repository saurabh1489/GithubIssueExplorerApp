package com.sample.abridgeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.abridgeapp.R
import com.sample.abridgeapp.network.ApiClient
import com.sample.abridgeapp.repository.IssueRepository
import com.sample.abridgeapp.util.ViewModelFactory
import com.sample.abridgeapp.vo.Failure
import com.sample.abridgeapp.vo.Success
import kotlinx.android.synthetic.main.fragment_layout.*

class IssueListFragment : Fragment() {

    lateinit var viewModel: IssueListViewModel
    val repository = IssueRepository(ApiClient.getClient())
    lateinit var adapter: IssueListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_layout, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(repository)
        ).get(IssueListViewModel::class.java)
        setupRecyclerView()
        observeIssueList()
    }

    private fun setupRecyclerView() {
        adapter = IssueListAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

    }

    private fun observeIssueList() {
        viewModel.getIssuesList().observe(this, Observer { resource ->
            when (resource) {
                is Success -> adapter.submitList(resource.data)
                is Failure -> showErrorMessage(resource.message)
            }
        })
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun create() = IssueListFragment()
    }

}