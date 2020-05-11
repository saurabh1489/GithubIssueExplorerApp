package com.sample.abridgeapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.sample.abridgeapp.network.ApiErrorResponse
import com.sample.abridgeapp.network.ApiResponse
import com.sample.abridgeapp.network.ApiSuccessResponse
import com.sample.abridgeapp.network.GithubService
import com.sample.abridgeapp.network.vo.IssueSchema
import com.sample.abridgeapp.vo.Failure
import com.sample.abridgeapp.vo.Issue
import com.sample.abridgeapp.vo.Resource
import com.sample.abridgeapp.vo.Success

class IssueRepository(private val apiService: GithubService) {

    fun getIssues(user: String, repository: String): LiveData<Resource<List<Issue>>> {
        val issueList = apiService.fetchIssues(user, repository)
        return Transformations.map(issueList) { apiResponse ->
            when (apiResponse) {
                is ApiSuccessResponse -> Success(apiResponse.data.map { it.toIssue() })
                is ApiErrorResponse -> Failure(apiResponse.errorMessage)
            }

        }
    }

}