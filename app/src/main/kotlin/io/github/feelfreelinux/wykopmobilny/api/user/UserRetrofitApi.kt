package io.github.feelfreelinux.wykopmobilny.api.user

import io.github.feelfreelinux.wykopmobilny.APP_KEY
import io.github.feelfreelinux.wykopmobilny.api.REMOVE_USERKEY_HEADER
import io.github.feelfreelinux.wykopmobilny.models.pojo.Profile
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserRetrofitApi {
    @Headers("@: $REMOVE_USERKEY_HEADER")
    @FormUrlEncoded
    @POST("user/login/appkey/$APP_KEY")
    fun getUserSessionToken(@Field("login") login : String, @Field("accountkey", encoded = true) accountkey : String) : Single<Profile>
}