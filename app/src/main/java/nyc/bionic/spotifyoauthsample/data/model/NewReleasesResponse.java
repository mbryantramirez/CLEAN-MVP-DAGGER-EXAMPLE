package nyc.bionic.spotifyoauthsample.data.model;

import com.squareup.moshi.Json;

public class NewReleasesResponse{

	@Json(name = "albums")
	private Albums albums;

	public Albums getAlbums(){
		return albums;
	}
}