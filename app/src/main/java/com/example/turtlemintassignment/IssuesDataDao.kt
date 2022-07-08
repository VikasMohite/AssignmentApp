package com.example.turtlemintassignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IssuesDataDao {

    @Insert
    fun insertIssues(issuesData: IssuesData)

    @Query("SELECT * FROM tbl_issues")
    fun getIssuesData(): List<IssuesData>

    @Query("SELECT * FROM tbl_issues WHERE issueId=:issueId")
    fun getIssueById(issueId: Int?): List<IssuesData>

    @Insert
    fun insertComments(commentsData: CommentsData)

    @Query("SELECT * FROM tbl_comments WHERE issueId=:issueId")
    fun getCommentsById(issueId: Int?): List<CommentsData>
}