package com.example.turtlemintassignment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/turtlemintassignment/ApiInterface;", "", "getComments", "Lretrofit2/Call;", "", "Lcom/example/turtlemintassignment/IssuesResponseModel;", "commentId", "", "getIssues", "app_release"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "repos/square/okhttp/issues")
    public abstract retrofit2.Call<java.util.List<com.example.turtlemintassignment.IssuesResponseModel>> getIssues();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "{commentId}/comments")
    public abstract retrofit2.Call<java.util.List<com.example.turtlemintassignment.IssuesResponseModel>> getComments(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "commentId")
    java.lang.String commentId);
}