package com.example.demo.entity;

public class EntMusic {
	
	private int id;
	private String song;//曲名
	private String genre;
	private String artist;
	private String url;
	
	public EntMusic() {
		
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
}
