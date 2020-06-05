package marvel.model;

public class MarvelCharacter {
	
	private int id;
	private Object comics;
	private String description;
	private Object events;
	private String modified;
	private String name;
	private String resourceURI;
	private Object series;
	private Object stories;
	private Object thumbnail;
	private Object urls;
	
	// Set and Get methods
	
	public Object getComics() {
		return comics;
	}
	public void setComics(Object comics) {
		this.comics = comics;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object getEvents() {
		return events;
	}
	public void setEvents(Object events) {
		this.events = events;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	public Object getSeries() {
		return series;
	}
	public void setSeries(Object series) {
		this.series = series;
	}
	public Object getStories() {
		return stories;
	}
	public void setStories(Object stories) {
		this.stories = stories;
	}
	public Object getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Object thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Object getUrls() {
		return urls;
	}
	public void setUrls(Object urls) {
		this.urls = urls;
	}

}
