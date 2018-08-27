package hw1;

/**
 * The SongRecord class implements an individual SongRecord class 
 * which contains methods and data for an audio file
 * 
 * 
 * @author Samuel Sundararaman
 *    e-mail: samuel.sundararaman@stonybrook.edu
 *    Stony Brook ID: 111352739
 */




public class SongRecord {
	
	private String title; // The title of the audio file
	private String artist; // The artist of the audio file
	private int minutes; // The minute value of the length of the audio file
	private int seconds; // The second value of the length of the audio file
	
	/**
	 * Constructs an instance of the SongRecord class
	 * @param t The title of the audio file
	 * @param a The artist of the audio file
	 * @param min The minute value of the length of the audio file
	 * @param sec The second value of the length of the audio file
	 */
	public SongRecord(String t, String a, int min, int sec) {
		this.title = t;
		this.artist = a;
		this.minutes = min;
		if(sec<10) {
			String newSec = "0"+Integer.toString(sec);
			sec = Integer.parseInt(newSec);
		}
		this.seconds = sec;
		
	}
	
	public String getSongTitle() {
		return this.title;
	}
	
	public String getSongArtist() {
		return this.artist;
	}
	
	public int getSongMinutes() {
		return this.minutes;
	}
	
	public int getSongSeconds() {
		return this.seconds;
	}
	
	public String toString() {
		String data= null;
		data =String.format("%-18s%-18s%-18s", this.getSongTitle(), this.getSongArtist(), this.getSongMinutes()+":"+this.getSongSeconds());
		return data;
	}
	
	public boolean equals(SongRecord temp) {
		if(this.getSongTitle().equals(temp.getSongTitle())&&this.getSongArtist().equals(temp.getSongArtist())&&this.getSongMinutes()==temp.getSongMinutes()&&this.getSongSeconds()==temp.getSongSeconds()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void setSongTitle(String newTitle) {
		this.title = newTitle;
	}
	
	public void setSongArtist(String newArtist) {
		this.artist = newArtist;
	}
	
	public void setSongMinutes(int newMin) {
		if(newMin<0) {
			throw new IndexOutOfBoundsException();
		}
		this.minutes = newMin;
	}
	
	public void setSongSeconds(int newSec) {
		if(newSec<0||newSec>59) {
			throw new IndexOutOfBoundsException();
		}
		if(newSec<10) {
			String sec = "0"+Integer.toString(newSec);
			newSec = Integer.parseInt(sec);
		}
		this.seconds = newSec;
	}

}
