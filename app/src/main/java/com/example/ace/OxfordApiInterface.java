package com.example.ace;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public abstract class OxfordApiInterface {
    @GET("entries/{source_lang}/{word_id}/")
    abstract Call<OxfordDictionaryResponse> getDefinition(@Path("source_lang") String source_lang, @Path("word_id") String word_id);
}
