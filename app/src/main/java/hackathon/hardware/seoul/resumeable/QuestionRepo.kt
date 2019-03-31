package hackathon.hardware.seoul.resumeable


import com.google.gson.annotations.SerializedName

/**
 * SIM
 * Created by KimWonJun on 6/3/2018.
 */
class QuestionRepo {
    @SerializedName("id")
    internal var id: String? = null
    @SerializedName("writer")
    internal var writer: String? = null
    @SerializedName("content")
    internal var content: String? = null
    @SerializedName("date")
    internal var date: String? = null
}