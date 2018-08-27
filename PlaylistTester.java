package hw1;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

public class PlaylistTester {
	Playlist original;
	Playlist copy;
	SongRecord drake;
	SongRecord uzi;
	SongRecord travis;
	SongRecord drake2;
	
	@BeforeEach
	public void setUp() {
		original = new Playlist();
		copy = new Playlist();
		drake = new SongRecord("Headlines","Drake",3,56);
		drake2 = new SongRecord("The Motto","Drake",3,56);
		uzi = new SongRecord("XO Tour Life", "Lil Uzi Vert", 2,35);
		travis = new SongRecord("Watch","Travis Scott", 4,38);
		original.addSong(drake, 0);
		original.addSong(drake2, 1);
		original.addSong(uzi, 2);
		original.addSong(travis, 3);
		
		
	}
	
	@Test
	public void testClone() {
		
	}
	
	@Test
	public void testEquals() {
		
	}
	
	@Test
	public void testSize() {
		
	}
	
	@Test
	public void testAddSong() {
		
	}
	
	@Test
	public void testRemoveSong() {
		
	}
	
	@Test
	public void testGetSong() {
		
	}
	
	@Test
	public void testPrintAllSongs() {
		
	}
	
	@Test
	public void testSongsByArtist() {
		
	}
	
	@Test
	public void testToString() {
		System.out.println(original.toString());
	}

}
