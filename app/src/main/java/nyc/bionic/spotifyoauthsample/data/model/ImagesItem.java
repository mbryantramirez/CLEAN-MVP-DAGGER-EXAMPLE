package nyc.bionic.spotifyoauthsample.data.model;

import com.squareup.moshi.Json;

public class ImagesItem{

	@Json(name = "width")
	private int width;

	@Json(name = "url")
	private String url;

	@Json(name = "height")
	private int height;

	public int getWidth(){
		return width;
	}

	public String getUrl(){
		return url;
	}

	public int getHeight(){
		return height;
	}
}