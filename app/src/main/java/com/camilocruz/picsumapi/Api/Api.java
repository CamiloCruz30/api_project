package com.camilocruz.picsumapi.Api;

import com.camilocruz.picsumapi.models.ImageListModel;
import com.camilocruz.picsumapi.models.SearchImageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://picsum.photos/";

    @GET("v2/list")
    Call<List<ImageListModel>> getImageList();

    @GET("search/id")
    Call<List<SearchImageModel>> getSearchImageList();

}
