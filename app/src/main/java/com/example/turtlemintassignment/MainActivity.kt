package com.example.turtlemintassignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var issuesAdapter: IssuesAdapter
    var issueList: List<IssuesData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkAndDisplayData()
    }

    fun checkAndDisplayData() {
        issueList = getDataFromDb()
        if (issueList != null && issueList!!.count() > 0) {
            setData()
        } else {
            if (checkForInternet(this)) {
                callIssuesAPI()
            } else {
                showToast(this, NO_INTERNET_CON)
            }
        }
    }

    fun callIssuesAPI() {
        showProgressDialog(this)
        val api =
            RetrofitAPIClient.getClient("https://api.github.com/").create(ApiInterface::class.java)
        val call = api.getIssues()
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
                hideProgressDialog()
                showToast(applicationContext, SOMETHING_WENT_WRONG)
            }
        })
    }

    fun storeInDb(resp: List<IssuesResponseModel>) {
        for (value in resp) {
            val data = IssuesData(
                null,
                value.id!!,
                value.number!!,
                value.title!!,
                value.updated_at!!,
                if (value.body != null) value.body!! else "",
                value.user!!.login!!,
                value.user!!.avatar_url!!,
                value.comments_url!!
            )
            val db: AppDatabase = AppDatabase.getDbInstance(this)
            db.issueDao().insertIssues(data)
        }
    }

    fun getDataFromDb(): List<IssuesData> {
        val db: AppDatabase = AppDatabase.getDbInstance(this)
        val dataList = db.issueDao().getIssuesData()
        return dataList
    }

    fun setData() {
        println("Size >> " + issueList!!.size)
        setAdapter(issueList!!)
    }

    fun setAdapter(issuesList: List<IssuesData>) {
        issuesAdapter = IssuesAdapter(this, issuesList) { issuesResponseModel ->
            val intent = Intent(this, CommentsActivity::class.java)
            intent.putExtra("issueId", issuesResponseModel.issueId)
            intent.putExtra("commentId", issuesResponseModel.commentId)
            intent.putExtra("body", issuesResponseModel.body)
            intent.putExtra("commentURL", issuesResponseModel.comment_url)
            startActivity(intent)
        }
        val rcv = findViewById<RecyclerView>(R.id.rcv_issues)
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = issuesAdapter
    }
}