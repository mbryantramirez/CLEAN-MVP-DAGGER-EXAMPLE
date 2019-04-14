package nyc.bionic.spotifyoauthsample.util;

import io.reactivex.Observable;
import nyc.bionic.spotifyoauthsample.data.model.NewReleasesResponse;
import retrofit2.http.GET;

public interface SpotifyService {

  @GET("browse/new-releases")
  Observable<NewReleasesResponse> getNewReleasesResponse();

}
