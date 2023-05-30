package com.example.demo.entity;

public class EntMusic {
	
	private int id;
	private String song;//曲名
	private String genre;
	private String artist;
	private int acosticness;
	private int danceability;
	private int energy;
	private int instrumentalness;
	private int liveness;
	private int loudness;
	private int tempo;
	private String key;
	private int link;
	
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

	public int getAcosticness() {
		return acosticness;
	}

	public void setAcosticness(int acosticness) {
		this.acosticness = acosticness;
	}

	public int getDanceability() {
		return danceability;
	}

	public void setDanceability(int danceability) {
		this.danceability = danceability;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getInstrumentalness() {
		return instrumentalness;
	}

	public void setInstrumentalness(int instrumentalness) {
		this.instrumentalness = instrumentalness;
	}

	public int getLiveness() {
		return liveness;
	}

	public void setLiveness(int liveness) {
		this.liveness = liveness;
	}

	public int getLoudness() {
		return loudness;
	}

	public void setLoudness(int loudness) {
		this.loudness = loudness;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	
}
