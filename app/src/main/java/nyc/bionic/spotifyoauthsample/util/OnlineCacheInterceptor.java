package nyc.bionic.spotifyoauthsample.util;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class OnlineCacheInterceptor implements Interceptor {

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Response response = chain.proceed(chain.request());
    int maxAge = 60;
    return response.newBuilder()
        .header("Cache-Control", "public, max-age=" + maxAge)
        .removeHeader("").build();
  }
}
