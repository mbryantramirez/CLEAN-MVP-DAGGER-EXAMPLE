package nyc.bionic.spotifyoauthsample.util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitClient {

  private static RetrofitClient instance = null;
  private SpotifyService spotifyService;

  private RetrofitClient() {
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .addInterceptor(new HttpLoggingInterceptor().setLevel(Level.BODY))
        .addInterceptor(new SpotifyOauthInterceptor())
        .build();

    String BASE_URL = "https://api.spotify.com/v1/";
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build();

    spotifyService = retrofit.create(SpotifyService.class);
  }

  public static RetrofitClient getInstance() {
    if (instance == null) {
      instance = new RetrofitClient();
    }
    return instance;
  }

  public SpotifyService getSpotifyService() {
    return spotifyService;
  }
}
