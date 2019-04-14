package nyc.bionic.spotifyoauthsample.data.model;

import com.squareup.moshi.Json;
import java.util.List;

public class ItemsItem{

	@Json(name = "images")
	private List<ImagesItem> images;

	@Json(name = "available_markets")
	private List<String> availableMarkets;

	@Json(name = "release_date_precision")
	private String releaseDatePrecision;

	@Json(name = "type")
	private String type;

	@Json(name = "uri")
	private String uri;

	@Json(name = "total_tracks")
	private int totalTracks;

	@Json(name = "artists")
	private List<ArtistsItem> artists;

	@Json(name = "release_date")
	private String releaseDate;

	@Json(name = "name")
	private String name;

	@Json(name = "album_type")
	private String albumType;

	@Json(name = "href")
	private String href;

	@Json(name = "id")
	private String id;

	@Json(name = "external_urls")
	private ExternalUrls externalUrls;

	public List<ImagesItem> getImages(){
		return images;
	}

	public List<String> getAvailableMarkets(){
		return availableMarkets;
	}

	public String getReleaseDatePrecision(){
		return releaseDatePrecision;
	}

	public String getType(){
		return type;
	}

	public String getUri(){
		return uri;
	}

	public int getTotalTracks(){
		return totalTracks;
	}

	public List<ArtistsItem> getArtists(){
		return artists;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getName(){
		return name;
	}

	public String getAlbumType(){
		return albumType;
	}

	public String getHref(){
		return href;
	}

	public String getId(){
		return id;
	}

	public ExternalUrls getExternalUrls(){
		return externalUrls;
	}
}