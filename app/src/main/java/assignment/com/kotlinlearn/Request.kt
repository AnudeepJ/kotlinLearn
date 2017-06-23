package assignment.com.kotlinlearn

import java.net.URL

/**
 * Created by anudeep on 08/06/17.
 */
class Request {

    fun run(url: String): String {
        val string = URL(url).readText()
        return string
    }
}