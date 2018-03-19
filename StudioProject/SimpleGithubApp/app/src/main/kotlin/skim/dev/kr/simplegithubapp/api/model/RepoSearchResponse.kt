package skim.dev.kr.simplegithubapp.api.model

import com.google.gson.annotations.SerializedName

class RepoSearchResponse(@field:SerializedName("total_count")
                         val totalCount: Int, val items: List<GithubRepo>)
