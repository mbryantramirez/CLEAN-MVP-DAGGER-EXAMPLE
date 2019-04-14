package nyc.bionic.spotifyoauthsample.data.model;

import com.squareup.moshi.Json;

public class ExternalUrls{

	@Json(name = "spotify")
	private String spotify;

	public String getSpotify(){
		return spotify;
	}
}