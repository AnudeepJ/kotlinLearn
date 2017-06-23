package explara.emaxio.exhibitors

import com.google.gson.annotations.SerializedName

/**
 * Created by anudeep on 20/06/17.
 */

class ExhibitorsDto {
    @SerializedName("status")
    var status: String? = null
    @SerializedName("message")
    var message: String? = null
    @SerializedName("exhibitorDetails")
    var exhibitorDetails: List<ExhibitorDetails>? = null

    class CreatedOn {
        @SerializedName("date")
        var date: String? = null
        @SerializedName("timezone_type")
        var timezone_type: Int = 0
        @SerializedName("timezone")
        var timezone: String? = null
    }

    class ExhibitorDetails {
        @SerializedName("id")
        var id: Int = 0
        @SerializedName("eventId")
        var eventId: Int = 0
        @SerializedName("title")
        var title: String? = null
        @SerializedName("image")
        var image: String? = null
        @SerializedName("description")
        var description: String? = null
        @SerializedName("facebookLink")
        var facebookLink: String? = null
        @SerializedName("twitterLink")
        var twitterLink: String? = null
        @SerializedName("linkedinLink")
        var linkedinLink: String? = null
        @SerializedName("websiteLink")
        var websiteLink: String? = null
        @SerializedName("contactEmail")
        var contactEmail: String? = null
        @SerializedName("contactNumber")
        var contactNumber: String? = null
        @SerializedName("createdOn")
        var createdOn: CreatedOn? = null
    }
}
