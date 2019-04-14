package nyc.bionic.spotifyoauthsample.data.model;

import java.util.List;
import com.squareup.moshi.Json;

public class Albums{

	@Json(name = "next")
	private String next;

	@Json(name = "total")
	private int total;

	@Json(name = "offset")
	private int offset;

	@Json(name = "previous")
	private String previous;

	@Json(name = "limit")
	private int limit;

	@Json(name = "href")
	private String href;

	@Json(name = "items")
	private List<ItemsItem> items;

	public String getNext(){
		return next;
	}

	public int getTotal(){
		return total;
	}

	public int getOffset(){
		return offset;
	}

	public String getPrevious(){
		return previous;
	}

	public int getLimit(){
		return limit;
	}

	public String getHref(){
		return href;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}