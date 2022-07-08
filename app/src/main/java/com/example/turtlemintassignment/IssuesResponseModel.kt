package com.example.turtlemintassignment

class IssuesResponseModel {

    var comments_url: String? = null
    var id: Int? = null
    var number: Int? = null
    var title: String? = null
    var updated_at: String? = null
    var body: String? = null
    var user: User? = null

    class User {
        var login: String? = null
        var avatar_url: String? = null
    }
}