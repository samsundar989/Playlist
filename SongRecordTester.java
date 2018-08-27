package hw1;

import static org.junit.Assert.*;


import org.junit.jupiter.api.*;

public class SongRecordTester {
	
	SongRecord drake;

	SongRecord drakeCopy;
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void onSetUp() throws Exception{
		drake = new SongRecord("Headlines","Drake",3,56);
		drakeCopy = new SongRecord("Headlines","Drake",3,56);
		
	}
	
	@Test
	public void testToString() {
		
		System.out.println(drake.toString());
	}
	
	@Test
	public void testEquals() {
		assertTrue(drake.equals(drakeCopy));
				
				
	}
	

}
