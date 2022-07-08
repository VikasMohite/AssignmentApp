package com.example.turtlemintassignment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_comments")
data class CommentsData(
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "issueId") var issueId: Int?,
    @ColumnInfo(name = "body") val body: String?,
)