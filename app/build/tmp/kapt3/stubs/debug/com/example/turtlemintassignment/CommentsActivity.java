package com.example.turtlemintassignment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0012\u0010\'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0014\u0010.\u001a\u00020$2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u0006\u0010/\u001a\u00020$J\u0014\u00100\u001a\u00020$2\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0017R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u001e\u0010 \u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b\u00a8\u00063"}, d2 = {"Lcom/example/turtlemintassignment/CommentsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "commentId", "", "getCommentId", "()Ljava/lang/Integer;", "setCommentId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "commentURL", "", "getCommentURL", "()Ljava/lang/String;", "setCommentURL", "(Ljava/lang/String;)V", "commentsAdapter", "Lcom/example/turtlemintassignment/CommentsAdapter;", "getCommentsAdapter", "()Lcom/example/turtlemintassignment/CommentsAdapter;", "setCommentsAdapter", "(Lcom/example/turtlemintassignment/CommentsAdapter;)V", "commentsList", "", "Lcom/example/turtlemintassignment/CommentsData;", "getCommentsList", "()Ljava/util/List;", "setCommentsList", "(Ljava/util/List;)V", "issueBody", "getIssueBody", "setIssueBody", "issueId", "getIssueId", "setIssueId", "callCommentsAPI", "", "checkAndDisplayData", "getCommentsDataFromDb", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setAdapter", "setData", "storeInDb", "resp", "Lcom/example/turtlemintassignment/IssuesResponseModel;", "app_debug"})
public final class CommentsActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer issueId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer commentId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String issueBody;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String commentURL;
    public com.example.turtlemintassignment.CommentsAdapter commentsAdapter;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.example.turtlemintassignment.CommentsData> commentsList;
    
    public CommentsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getIssueId() {
        return null;
    }
    
    public final void setIssueId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCommentId() {
        return null;
    }
    
    public final void setCommentId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIssueBody() {
        return null;
    }
    
    public final void setIssueBody(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommentURL() {
        return null;
    }
    
    public final void setCommentURL(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.turtlemintassignment.CommentsAdapter getCommentsAdapter() {
        return null;
    }
    
    public final void setCommentsAdapter(@org.jetbrains.annotations.NotNull()
    com.example.turtlemintassignment.CommentsAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.turtlemintassignment.CommentsData> getCommentsList() {
        return null;
    }
    
    public final void setCommentsList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.turtlemintassignment.CommentsData> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public final void checkAndDisplayData() {
    }
    
    public final void callCommentsAPI() {
    }
    
    public final void storeInDb(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.turtlemintassignment.IssuesResponseModel> resp) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.turtlemintassignment.CommentsData> getCommentsDataFromDb() {
        return null;
    }
    
    public final void setData() {
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.turtlemintassignment.CommentsData> commentsList) {
    }
}