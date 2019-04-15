package nyc.bionic.spotifyoauthsample.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class OfflineCacheInterceptor implements Interceptor {

  private ConnectivityManager connectivityManager;

  public OfflineCacheInterceptor(ConnectivityManager connectivityManager) {
    this.connectivityManager = connectivityManager;
  }

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Request request = chain.request();
    if (!isInternetAvailable()) {
      int maxStale = 60 * 60 * 24 * 10;
      request = request.newBuilder()
          .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
          .removeHeader("Pragma")
          .build();
    }
    return chain.proceed(request);
  }

  private boolean isInternetAvailable() {
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    return networkInfo != null && networkInfo.isConnected();
  }
}
