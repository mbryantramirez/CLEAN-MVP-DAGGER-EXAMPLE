package nyc.bionic.spotifyoauthsample.di.module;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import nyc.bionic.spotifyoauthsample.data.SpotifyRepository;
import nyc.bionic.spotifyoauthsample.util.OfflineCacheInterceptor;
import nyc.bionic.spotifyoauthsample.util.OnlineCacheInterceptor;
import nyc.bionic.spotifyoauthsample.util.SpotifyOauthInterceptor;
import nyc.bionic.spotifyoauthsample.util.SpotifyService;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {

  @Provides
  @Singleton
  Retrofit providesRetrofit(MoshiConverterFactory moshiConverterFactory,
      RxJava2CallAdapterFactory rxJava2CallAdapterFactory, OkHttpClient okHttpClient) {
    String BASE_URL = "https://api.spotify.com/v1/";
    return new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(moshiConverterFactory)
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .client(okHttpClient)
        .build();
  }

  @Provides
  @Singleton
  OkHttpClient providesOkHttpClient(Cache cache, ConnectivityManager connectivityManager) {
    return new OkHttpClient.Builder().cache(cache)
        .addInterceptor(new HttpLoggingInterceptor().setLevel(Level.BODY))
        .addInterceptor(new SpotifyOauthInterceptor())
        .addInterceptor(new OfflineCacheInterceptor(connectivityManager))
        .addNetworkInterceptor(new OnlineCacheInterceptor())
        .build();
  }

  @Provides
  @Singleton
  SpotifyService providesSpotifyService(Retrofit retrofit) {
    return retrofit.create(SpotifyService.class);
  }

  @Provides
  @Singleton
  ConnectivityManager providesConnectivityManager(Application application) {
    return (ConnectivityManager) application
        .getSystemService(Context.CONNECTIVITY_SERVICE);
  }

  @Provides
  @Singleton
  Cache providesCache(Application application) {
    int cacheSize = 10 * 1024 * 1024;
    return new Cache(application.getCacheDir(), cacheSize);
  }

  @Provides
  @Singleton
  MoshiConverterFactory moshiConverterFactory() {
    return MoshiConverterFactory.create();
  }

  @Provides
  @Singleton
  RxJava2CallAdapterFactory rxJava2CallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  @Provides
  SpotifyRepository providesSpotifyRepository(SpotifyService spotifyService){
    return new SpotifyRepository(spotifyService);
  }
}
