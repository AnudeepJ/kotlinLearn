package assignment.com.kotlinlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

class JavaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java)

        Observable.just("Some string").subscribe { s -> Log.d(TAG, s) }


        val person = Person("Anudeep", 27)
        Observable.just(person).subscribe { person -> Log.d(TAG, person.Name) }


        Observable.just(person).subscribe { person2 -> Log.d(TAG, person2.Name) }
        //
        //        Observable.just("First item", "Second item")
        //                .doOnNext(e -> Log.d("APP", "on-next:" +
        //                        Thread.currentThread().getName() + ":" + e))
        //                .subscribe(e -> Log.d("APP", "subscribe:" +
        //                        Thread.currentThread().getName() + ":" + e));

        Observable.just("First Item", "Second Item").doOnNext { s -> Log.d(TAG, "On Next: " + s + Thread.currentThread().name) }.doOnDispose {
            Log.d(TAG, "doOnDispose")
            Log.d(TAG, "doOnDispose")
            Log.d(TAG, "doOnDispose")
        }.subscribe { s -> Log.d(TAG, "On Next: " + s + Thread.currentThread().name) }
    }

    companion object {

        private val TAG = JavaActivity::class.java.simpleName
    }
}
