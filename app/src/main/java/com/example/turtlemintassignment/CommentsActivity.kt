package com.example.turtlemintassignment

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {

    var issueId: Int? = null
    var commentId: Int? = null
    var issueBody: String? = null
    var commentURL: String? = null
    lateinit var commentsAdapter: CommentsAdapter
    var commentsList: List<CommentsData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        issueId = intent.getIntExtra("issueId", 0)
        commentId = intent.getIntExtra("commentId", 0)
        issueBody = intent.getStringExtra("body")
        commentURL = intent.getStringExtra("commentURL")

        val action: ActionBar? = supportActionBar
        action!!.setDisplayHomeAsUpEnabled(true)

        val tv_issuesInfo = findViewById<TextView>(R.id.tv_issuesInfo)
        tv_issuesInfo.text = issueBody

        checkAndDisplayData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun checkAndDisplayData() {
        commentsList = getCommentsDataFromDb()
        if (commentsList != null && commentsList!!.count() > 0) {
            setData()
        } else {
            if (checkForInternet(this)) {
                callCommentsAPI()
            } else {
                showToast(this, NO_INTERNET_CON)
            }
        }
    }

    fun callCommentsAPI() {
        showProgressDialog(this)
        val api =
            RetrofitAPIClient.getClient("https://api.github.com/repos/square/okhttp/issues/")
                .create(ApiInterface::class.java)
        val call = api.getComments(commentId.toString())
        call.enqueue(object :
            retrofit2.Callback<List<IssuesResponseModel>> {
            override fun onResponse(
                call: Call<List<IssuesResponseModel>>?,
                response: Response<List<IssuesResponseModel>>?
            ) {
                hideProgressDialog()
                if (response?.body() != null) {
                    storeInDb(response.body()!!)
                    checkAndDisplayData()
                } else {
                    showToast(applicationContext, SOMETHING_WENT_WRONG)
                }
            }

            override fun onFailure(call: Call<List<IssuesResponseModel>>?, t: Throwable) {
                showToast(applicationContext, SOMETHING_WENT_WRONG)
                hideProgressDialog()
            }

        })
    }

    fun storeInDb(resp: List<IssuesResponseModel>) {
        for (value in resp) {
            val data = CommentsData(
                null,
                issueId!!,
                if (value.body != null) value.body!! else ""
            )
            val db: AppDatabase = AppDatabase.getDbInstance(this)
            db.issueDao().insertComments(data)
        }
    }

    fun getCommentsDataFromDb(): List<CommentsData> {
        val db: AppDatabase = AppDatabase.getDbInstance(this)
        val dataList = db.issueDao().getCommentsById(issueId)
        return dataList
    }

    fun setData() {
        setAdapter(commentsList!!)
    }

    fun setAdapter(commentsList: List<CommentsData>) {
        commentsAdapter = CommentsAdapter(this, commentsList)
        val rcv = findViewById<RecyclerView>(R.id.rcv_comments)
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = commentsAdapter
    }
}