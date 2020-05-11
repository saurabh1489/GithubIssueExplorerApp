package com.sample.abridgeapp.network

import androidx.lifecycle.LiveData
import com.sample.abridgeapp.network.vo.IssueSchema
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/repos/{owner}/{repo}/issues")
    fun fetchIssues(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): LiveData<ApiResponse<List<IssueSchema>>>

}