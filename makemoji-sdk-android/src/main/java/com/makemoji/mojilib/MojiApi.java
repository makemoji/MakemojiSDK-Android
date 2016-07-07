package com.makemoji.mojilib;

import com.google.gson.JsonObject;
import com.makemoji.mojilib.model.Category;
import com.makemoji.mojilib.model.MojiModel;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Scott Baar on 1/9/2016.
 */
public interface MojiApi {
    String BASE_URL = "https://api.makemoji.com/sdk/";

    @GET("emoji/index/trending")
    Call<List<MojiModel>> getTrending();

    @GET("emoji/index/{category}")
    Call<List<MojiModel>> getByCategory(@Path("category") String category);

    @GET("emoji/categories")
    Call<List<Category>> getCategories();

    @GET("emoji/index/used/1/255/{deviceId}")
    Call<List<MojiModel>> getRecentlyUsed(@Path("deviceId") String deviceId);

    @GET("emoji/allflashtags")
    Call<List<MojiModel>> getFlashtags();

    @GET("emoji/index/trendingflashtags")
    Call<List<MojiModel>> getTrendingFlashtags();

    @FormUrlEncoded
    @POST("messages/create")
    Call<JsonObject> sendPressed(@Field("message") String htmlMessage);

    @POST("emoji/viewTrack")
    Call<Void> trackViews( @Body RequestBody array);

    @FormUrlEncoded
    @POST("emoji/clickTrackBatch")
    Call<Void> trackClicks(@Field("emoji") String emoji);

    @GET("emoji/emojiwall")
    Call<Map<String,List<MojiModel>>> getEmojiWallData();

    @FormUrlEncoded
    @POST("emoji/unlockGroup")
    Call<JsonObject> unlockGroup(@Field("category_name")String categoryName);

    @GET("reactions/get/{sha1_content_id}")
    Call<JsonObject> getReactionData(@Path("sha1_content_id") String sha1ContentId);

    @FormUrlEncoded
    @POST("reactions/create/{sha1_content_id}")
    Call<JsonObject> createReaction(@Path("sha1_content_id") String sha1ContentId, @Field("emoji_id") int emojiId,@Field("emoji_type") String emojiType);



}
