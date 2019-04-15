package nyc.bionic.spotifyoauthsample.util;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import nyc.bionic.spotifyoauthsample.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class SpotifyOauthInterceptor implements Interceptor {

  private String token = null;

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Request request = chain.request();

    if (token == null) {
      ResponseBody responseBody = chain.proceed(getToken()).body();
      try {
        JSONObject jsonObject = new JSONObject(responseBody.string());
        token = "Bearer " + jsonObject.optString("access_token");
      } catch (JSONException e) {
        Log.d(SpotifyOauthInterceptor.class.getName(), "intercept: " + e.getLocalizedMessage());
      }
    }

    request = request.newBuilder().addHeader("Authorization", token).build();

    return chain.proceed(request);
  }


  private Request getToken() {
    String clientId = BuildConfig.ClientID;
    String clientSecret = BuildConfig.ClientSecret;
    String base64BearerToken =
        "Basic " + Base64
            .encodeToString((clientId + ":" + clientSecret).getBytes(), Base64.NO_WRAP);
    RequestBody requestBody = RequestBody
        .create(MediaType.parse("application/x-www-form-urlencoded"),
            "grant_type=client_credentials");
    return new Request.Builder().url("https://accounts.spotify.com/api/token")
        .post(requestBody)
        .header("Authorization", base64BearerToken)
        .header("Content-type", "application/x-www-form-urlencoded;charset=UTF-8")
        .build();
  }
}
