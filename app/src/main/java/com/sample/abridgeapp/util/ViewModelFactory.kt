package com.sample.abridgeapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.abridgeapp.repository.IssueRepository
import com.sample.abridgeapp.ui.IssueListViewModel

class ViewModelFactory(val repository: IssueRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(IssueListViewModel::class.java)) {
           return IssueListViewModel(repository) as T
       }
        throw IllegalArgumentException("ViewModel class doesn't exist!")
    }
}