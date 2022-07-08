package com.example.turtlemintassignment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_issues")
data class IssuesData(
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "issueId") var issueId: Int?,
    @ColumnInfo(name = "commentId") var commentId: Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "updated_at") val updated_at: String?,
    @ColumnInfo(name = "body") val body: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "avatar_url") val avatar_url: String?,
    @ColumnInfo(name = "comment_url") val comment_url: String?,
)