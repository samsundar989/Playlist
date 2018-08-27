package hw1;

/**
 * The Playlist class implements an individual SongRecord class 
 * which contains methods and data for an audio file
 * 
 * 
 * @author Samuel Sundararaman
 *    e-mail: samuel.sundararaman@stonybrook.edu
 *    Stony Brook ID: 111352739
 */

public class Playlist {
	
	private final int MAX_SIZE;
	private int numSongs;
	private SongRecord[] songs = null;
	
	// Invariants:
	// MAX_SIZE always represents the max size of a Playlist object
	
	/**
	 * Constructs an instance of the Playlist class with no SongRecord objects in it
	 *     Postcondition: 
	 *         This Playlist has been initialized to an empty list of SongRecords
	 */
	
	public Playlist() {
		this.MAX_SIZE = 50;
		this.songs = new SongRecord[MAX_SIZE];
		numSongs = 0;
	}
	
	/**
	 * Generates a copy of this Playlist
	 * 
	 * @return a separate copy of current Playlist
	 */
	
	public Object clone() {
		Playlist copy = new Playlist();
		for(int i=0;i<this.size();i++) {
			copy.songs[i] = this.songs[i];
			copy.numSongs++;
		}
		return (Playlist)copy;
		
	}
	
	/**
	 * Compare this Playlist to another object for equality
	 * 
	 * @param obj An object to which this Playlist is compared
	 * @return true if obj refers to a Playlist object with same SongRecords in same order as this Playlist, otherwise
	 * return false
	 */
	
	public boolean equals (Object obj) {
		if(obj==null||!(obj instanceof Playlist)) {
			return false;
		}
		else {
			Playlist comp = (Playlist) obj;
			for(int i=0; i<this.size();i++) {
				if(!this.songs[i].equals(comp.songs[i])) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Determines the number of SongRecords currently in this Playlist
	 *     Preconditions: 
	 *         This SongRecord object has been instantiated
	 *         
	 * @return The number of SongRecords in this Playlist
	 */
	
	public int size() {
		if(songs==null) {
			throw new IllegalArgumentException("SongRecord object has not been instantiated");
		}
		return numSongs;
	}
	
	/**
	 * Adds a song to the desired position in the Playlist
	 * 
	 * @param song The new SongRecord object to add to this Playlist
	 * @param position The position in the Playlist where the song will be inserted
	 * 
	 *     Preconditions:
	 *         This SongRecord object has been instantiated and 1<=position<=songs_currently_in_playlist+1
	 *         The number of SongRecord objects in this Playlist is less than max_songs
	 *         
	 *     Postconditions:
	 *         The new SongRecord is now stored at desired position in Playlist
	 *         All SongRecords that were originally in positions greater than or equal to position are moved back 
	 *         one position
	 *         
	 * @exception IllegalArgumentException
	 * @exception FullPlaylistException
	 *       
    **/
	public void addSong(SongRecord song, int position) {
		if(song==null||position<0||position>this.size()+1) {
			throw new IllegalArgumentException("Invalid Position");
		}
		if(this.size()>=MAX_SIZE) {
			throw new IndexOutOfBoundsException("Full Playlist");
		}
		
		if(songs[position]==null) {
			songs[position] = song;
		}
		else {			
			SongRecord[] temp = new SongRecord[MAX_SIZE];
			for(int i=position;i<this.size();i++) {
				temp[i] = songs[i];
			}
			songs[position] = song;
			for(int x=position+1;x<temp.length;x++) {
				songs[x] = temp[x-1];
			}
		}
		numSongs++;
		
	}
	
	/**
	 * Removes the SongRecord at the given position
	 * 
	 * @param position The position in the Playlist where the song will be removed 
	 * 
	 *     Preconditions:
	 *         This SongRecord object has been instantiated and 1<=position<=songs_currently_in_playlist
	 *         
	 *     Postconditions:
	 *         The SongRecord at the desired position in the Playlist has been removed
	 *         All SongRecords that were originally in positions greater than or equal to position are moved forward 
	 *         one position
	 *     
	 * @exception IllegalArgumentException
	 */
	public void removeSong(int position) {
		if(position<0||position>this.size()) {
			throw new IllegalArgumentException("Invalid Position");
		}
		if(songs==null) {
			throw new IllegalArgumentException("SongRecord object has not been instantiated.");
		}
		
		if(songs[position]!=null) {
			songs[position] = null;
			SongRecord[] temp = new SongRecord[MAX_SIZE];
			temp = songs;
			for(int i=position;i<this.size()-1;i++) {
				songs[i] = temp[i+1];
			}
		}
		numSongs--;
		
	}
	
	/**
	 * Get the SongRecord at the given position in this Playlist object
	 * 
	 * @param position The position of the SongRecord to retrieve
	 * 
	 *     Preconditions:
	 *         This Playlist object has been instantiated and 1<=position<=songs_currently_in_playlist
	 *         
	 * @exception IllegalArgumentException
	 *         
	 * @return The SongRecord at the specified position in this Playlist object
	 */
	public SongRecord getSong(int position) {
		if(position<0||position>this.size()) {
			throw new IllegalArgumentException("Invalid Position");
		}
		return songs[position];
	}
	
	/**
	 * Prints a neatly formatted table of each SongRecord in the Playlist on its own line with its position
	 * number as shown in the sample output
	 * 
	 *     Preconditions:
	 *         This SongRecord object has been instantiated
	 *         
	 *     Postconditions:
	 *         A neatly formatted table of each SongRecord in the Playlist on its own line with its position number 
	 *         has been displayed to the user
	 *         
	 */
	public void printAllSongs() {
		if(songs==null) {
			throw new IllegalArgumentException("SongRecord object has not been instantiated");
		}
		System.out.println(this.toString());
	}
	
	/**
	 * Generates a new Playlist containing all SongRecords in the original Playlist performed by the specified artist
	 * 
	 * @param originalList The original Playlist
	 * @param artist The name of the artist
	 * 
	 *     Preconditions:
	 *         The Playlist referred to by originalList has been instantiated
	 * 
	 * @return a new Playlist object containing all SongRecords in the original Playlist performed by the specified artist
	 */
	public static Playlist getSongsByArtist(Playlist originalList, String artist) {
		if(originalList==null||artist==null) {
			return null;
		}
		Playlist artistList = new Playlist();
		int counter=0;
		for(int i=0;i<originalList.size();i++) {
			if(originalList.songs[i].getSongArtist().equals(artist)) {
				artistList.addSong(originalList.songs[i],counter);
				counter++;
			}
		}
		return artistList;
		
	}
	
	/**
	 * Gets the String representation of this Playlist object, which is a neatly formatted table of each SongRecord in 
	 * the Playlist on its own line with its position number
	 * 
	 * @return The String representation of this Playlist object
	 */
	public String toString() {
		StringBuilder table = new StringBuilder();
		table.append(String.format("%-10s%-18s%-18s%-18s", "Song#", "Title", "Artist","Length"));
		table.append("\n"+"---------------------------------------------------------");
		for(int i=0;i<this.size();i++) {
			table.append("\n"+String.format("%-10s%-26s", i+1, this.songs[i].toString()));
		}
		return table.toString();
		
		
	}

}
