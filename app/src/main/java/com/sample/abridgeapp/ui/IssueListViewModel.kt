package com.sample.abridgeapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sample.abridgeapp.repository.IssueRepository
import com.sample.abridgeapp.vo.Issue
import com.sample.abridgeapp.vo.Resource

class IssueListViewModel(private val repository: IssueRepository): ViewModel() {

    fun getIssuesList(): LiveData<Resource<List<Issue>>> = repository.getIssues("square", "okhttp")

}