package assignment.com.kotlinlearn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import explara.emaxio.net.RequestDto
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        Observable.just("Use this observable carefully").subscribe { s -> txt.text = s }
//
//
//        val p1: Person = Person("Anudeep", 27)
//        val disposable: Disposable = Observable.just(p1).subscribe { p1 -> txt.text = p1.Name }
//        Observable.just("First Item", "Second Item")
//                .subscribeOn(Schedulers.io())
//                .doOnSubscribe { log("doOnSubscribe") }
//                .doOnDispose { log("doOnDispose") }
//                .doOnComplete { log("doOnComplete") }
//                .doOnEach { log("doOnEach") }
//                .doOnTerminate { log("doOnTerminate") }
//                .doFinally { log("doFinally") }
//                .doOnNext { s -> log("doOnNext: " + s) }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { log("subscribe ") }
//
//        val observable = PublishSubject.create<Int>()
//
//        observable.subscribeOn(Schedulers.computation())
//
//        observable.subscribe { integer -> Log.d(TAG, integer.toString()) }
//
////        observable.toFlowable(BackpressureStrategy.MISSING).subscribe { integer -> log(integer.toString()) }
//
////        for (j in 1..1000000) {
////            observable.onNext(j)
////
////        }
//
//        val completable = Completable.fromAction { log("completable action") }
//        completable.subscribe { log("on complete") }
//
////        for(i in 1000.. 0) {
////
////        }


        val apimanager: ApiManager = ApiManager()
        val apiRequest: RequestDto = RequestDto("0f1eafe861681de53aa511f3570ee44a266275c5", "769", "657")


        apimanager.fetchExhibitors(apiRequest).subscribe {
            response ->
            Log.d(TAG, response.message)
        }


//        val fetchExhibitorsWIthourRx = apimanager.fetchExhibitorsWIthourRx(apiRequest)
//        fetchExhibitorsWIthourRx.enqueue(object : Callback<ExhibitorresponseDto> {
//            override fun onResponse(call: Call<ExhibitorresponseDto>?, response: Response<ExhibitorresponseDto>?) {
//
//                Log.d(TAG, response!!.body().message)
//            }
//
//            override fun onFailure(call: Call<ExhibitorresponseDto>?, t: Throwable?) {
//
//                Log.d(TAG, t!!.localizedMessage)
//            }
//        })


//        { "accessToken": "0f1eafe861681de53aa511f3570ee44a266275c5", "eventId": "769", "appId":"657" }
        apimanager.fetchExhibitors(apiRequest)
                .subscribe { exhibitors -> log(exhibitors.message) }
//        doAsync {
//            val call = apimanager.fetchExhibitorsWIthourRx(apiRequest)
//            val result = call.execute().body()
//
//        }


        val javaApiManager: JavaApiManager = JavaApiManager()
        val fetchExhibitorswithCall: Call<ExhibitorresponseDto> = javaApiManager.fetchExhibitorswithCall(apiRequest)

//
//        fetchExhibitorswithCall.enqueue(object : Callback<ExhibitorresponseDto> {
//            override fun onResponse(call: Call<ExhibitorresponseDto>, response: Response<ExhibitorresponseDto>) {
//                Log.d(TAG, response.body().message)
//            }
//
//            override fun onFailure(call: Call<ExhibitorresponseDto>, t: Throwable) {
//                Log.d(TAG, t.localizedMessage)
//
//            }
//        })

//        doAsync {
//            val message = fetchExhibitorswithCall.execute().body().message
//            Log.d(TAG, message)
//        }


//        val fetchExhibitorswithoutCall = javaApiManager.fetchExhibitorswithoutCall(apiRequest)
//        val message = fetchExhibitorswithoutCall.message
//        Log.d(TAG, message)


    }


    private fun log(stage: String, item: String) {
        Log.d("APP", stage + ":" + Thread.currentThread().name + ":" +
                item)
    }

    private fun log(stage: String) {
        Log.d("APP", stage + ":" + Thread.currentThread().name)
    }
}
