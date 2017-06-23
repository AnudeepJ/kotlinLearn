package assignment.com.kotlinlearn

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        text_view.text = " Setting text from kotlin"
//        add(2, 3)
//        Toast.makeText(applicationContext, "Value of 2 + 3 is ${add(y = 2, x = 3)}", Toast.LENGTH_LONG).show()
//        add(x = 3, y = 5)

        val recyclerList = findViewById(R.id.recylerListView) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerList.layoutManager = linearLayoutManager
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        val items = listOf("List item 1 ", "List item 2 ", "List item 3 ", "List item 1 ", "List item 2 ", "List item 3 ", "List item 1 ", "List item 2 ", "List item 3 ", "List item 1 ", "List item 2 ", "List item 3 ", "List item 1 ", "List item 2 ", "List item 3 ", "List item 1 ", "List item 2 ", "List item 3 ")


        var a: String = "abbc"
//        a = null

        var b: String? = "def"
        b = null

        toasteasy("length of a is ${a.length} b is ${b?.length}")


        val p1 = Person("Anudeep", 27)
        Log.d(TAG, p1.Name)
        recyclerList.visible()
        p1.toastPerson()

        recyclerList.setOnClickListener { toast("toast") }

        recyclerList.setOnClickListener {}
        recyclerList.setOnClickListener() {}


        doAsync {
            val data = Request().run("https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=83f52f0f1c8941578823728559f01b4d")
            val gson: Gson = Gson()
            val newsFeed: NewsFeed = gson.fromJson(data, NewsFeed::class.java)

            Log.d(TAG, "after download" + newsFeed.articles.size.toString())
            uiThread {
                val recyclerAdapter = RecyclerListAdapter(newsFeed.articles)
                recyclerList.adapter = recyclerAdapter
                toast("Download Completed !")
            }
        }


    }


    fun Context.toasteasy(message: CharSequence, duration: Int = android.widget.Toast.LENGTH_LONG) {
        android.widget.Toast.makeText(this, message, duration).show()
    }


    fun ViewGroup.visible() {
        this.visibility = View.VISIBLE
    }

    fun add(x: Int, y: Int = 5): Int {
        return x + y
    }

    fun Person.toastPerson() {
        Toast.makeText(applicationContext, "age is ${Name}", Toast.LENGTH_LONG).show()
    }

    fun Log.explaralog(message: String) {
        Log.d(TAG, message)
    }


}

