package hackathon.hardware.seoul.resumeable


import com.google.gson.annotations.SerializedName

/**
 * Created by Kinetic on 2018-06-02.
 */

class LocationRepo {
    @SerializedName("lat")
    var lat = "1"

    @SerializedName("lng")
    var lng = "1"

    @SerializedName("placeName")
    var placeName = "NullPointer_Catch"
}