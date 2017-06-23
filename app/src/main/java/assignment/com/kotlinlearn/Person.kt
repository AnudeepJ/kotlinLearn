package assignment.com.kotlinlearn

import android.content.Context

/**
 * Created by anudeep on 07/06/17.
 */
class Person(name: String, age: Int) {


    var Name: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var Age: Int = 20
        get() {
            return field
        }
        set(value) {
            field = value
        }

    init {
        Name = name
        Age = age
    }


}