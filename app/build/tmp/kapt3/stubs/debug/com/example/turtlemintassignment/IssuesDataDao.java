package com.example.turtlemintassignment;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\'J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/example/turtlemintassignment/IssuesDataDao;", "", "getCommentsById", "", "Lcom/example/turtlemintassignment/CommentsData;", "issueId", "", "(Ljava/lang/Integer;)Ljava/util/List;", "getIssueById", "Lcom/example/turtlemintassignment/IssuesData;", "getIssuesData", "insertComments", "", "commentsData", "insertIssues", "issuesData", "app_debug"})
public abstract interface IssuesDataDao {
    
    @androidx.room.Insert()
    public abstract void insertIssues(@org.jetbrains.annotations.NotNull()
    com.example.turtlemintassignment.IssuesData issuesData);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tbl_issues")
    public abstract java.util.List<com.example.turtlemintassignment.IssuesData> getIssuesData();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tbl_issues WHERE issueId=:issueId")
    public abstract java.util.List<com.example.turtlemintassignment.IssuesData> getIssueById(@org.jetbrains.annotations.Nullable()
    java.lang.Integer issueId);
    
    @androidx.room.Insert()
    public abstract void insertComments(@org.jetbrains.annotations.NotNull()
    com.example.turtlemintassignment.CommentsData commentsData);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM tbl_comments WHERE issueId=:issueId")
    public abstract java.util.List<com.example.turtlemintassignment.CommentsData> getCommentsById(@org.jetbrains.annotations.Nullable()
    java.lang.Integer issueId);
}