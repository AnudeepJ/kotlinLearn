package assignment.com.kotlinlearn

/**
 * Created by anudeep on 09/06/17.
 */
data class NewsFeed(val status: String, val articles: List<Articles>) {
    public var somePrivateFiled : String = "";
}

data class Articles(val title: String) {


}