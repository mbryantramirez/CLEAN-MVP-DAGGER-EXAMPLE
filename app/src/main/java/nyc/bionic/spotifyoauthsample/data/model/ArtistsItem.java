package nyc.bionic.spotifyoauthsample.data.model;

import com.squareup.moshi.Json;

public class ArtistsItem{

	@Json(name = "name")
	private String name;

	@Json(name = "href")
	private String href;

	@Json(name = "id")
	private String id;

	@Json(name = "type")
	private String type;

	@Json(name = "external_urls")
	private ExternalUrls externalUrls;

	@Json(name = "uri")
	private String uri;

	public String getName(){
		return name;
	}

	public String getHref(){
		return href;
	}

	public String getId(){
		return id;
	}

	public String getType(){
		return type;
	}

	public ExternalUrls getExternalUrls(){
		return externalUrls;
	}

	public String getUri(){
		return uri;
	}
}