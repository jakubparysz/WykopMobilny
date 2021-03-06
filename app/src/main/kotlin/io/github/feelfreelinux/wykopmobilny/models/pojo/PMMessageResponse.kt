package io.github.feelfreelinux.wykopmobilny.models.pojo

import com.squareup.moshi.Json
import io.github.feelfreelinux.wykopmobilny.models.dataclass.Embed

data class PMMessageResponse(
        @Json(name = "author")
        val author: String,

        @Json(name = "author_avatar")
        val authorAvatar : String,

        @Json(name = "author_avatar_med")
        val authorAvatarMed : String,

        @Json(name = "author_avatar_lo")
        val authorAvatarLo : String,

        @Json(name = "author_group")
        val authorGroup : Int,

        @Json(name = "author_sex")
        val authorSex : String,

        @Json(name = "date")
        val date : String,

        @Json(name = "body")
        val body : String,

        @Json(name = "status")
        val status : String,

        @Json(name = "direction")
        val direction : String,

        @Json(name = "embed")
        val embed : Embed?,

        @Json(name = "app")
        val app : String?
)