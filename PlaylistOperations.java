package hw1;

import java.util.Scanner;

/**
 * The PlayOperations class tests the methods of the Playlist class and allows
 * the user to manipulate a single Playlist object by performing operations on
 * it
 * 
 * 
 * @author Samuel Sundararaman e-mail: samuel.sundararaman@stonybrook.edu Stony
 *         Brook ID: 111352739
 */

public class PlaylistOperations {

	private static Scanner scanner;

	/**
	 * The main method runs a menu driven application which creates an empty
	 * Playlist and then prompts the user for a menu command selecting the
	 * operation.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Playlist test = new Playlist();
		scanner = new Scanner(System.in);
		String input = "Z";
		while (!input.equals("Q")) {
			System.out.print(
					"\n" + "A) Add Song \n" + "B) Print Songs by Artist \n" + "G) Get Song \n" + "R) Remove Song \n"
							+ "P) Print All Songs \n" + "S) Size \n" + "Q) Quit \n" + "\n" + "Select a menu option: ");
			input = scanner.nextLine();
			if (input.equals("A")) {
				String title;
				String artist;
				int min;
				int sec;
				int pos;
				System.out.print("Enter the song title: ");
				title = scanner.nextLine();
				System.out.print("Enter the song artist: ");
				artist = scanner.nextLine();
				System.out.print("Enter the song length (minutes): ");
				min = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the song length (seconds): ");
				sec = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the position: ");
				pos = Integer.parseInt(scanner.nextLine());
				SongRecord toAdd = new SongRecord(title, artist, min, sec);
				test.addSong(toAdd, pos - 1);
				System.out.println("Song added: " + title + " By " + artist);

			}

			if (input.equals("B")) {
				String artist;
				System.out.print("Enter the artist: ");
				artist = scanner.nextLine();
				if (test.getSongsByArtist(test, artist) == null) {
					System.out.println("Parameter is null");
				} else {
					System.out.println(test.getSongsByArtist(test, artist).toString());
				}

			}

			if (input.equals("G")) {
				int pos;
				System.out.print("Enter the position: ");
				pos = Integer.parseInt(scanner.nextLine());

				System.out.println(String.format("%-10s%-18s%-18s%-18s", "Song#", "Title", "Artist", "Length"));
				System.out.println("-----------------------------------------------------------");
				System.out.println(String.format("%-10s%-26s", pos, test.getSong(pos - 1).toString()));
			}

			if (input.equals("R")) {
				int pos;
				System.out.print("Enter the position: ");
				pos = Integer.parseInt(scanner.nextLine());
				if (test.getSong(pos - 1) == null) {
					System.out.println("No song at position " + pos + " to remove.");
				}
				test.removeSong(pos - 1);
				System.out.println("Song Removed at position " + pos);

			}

			if (input.equals("P")) {

				test.printAllSongs();
			}

			if (input.equals("S")) {

				System.out.println("There are " + test.size() + " song(s) in the current playlist.");
			}

		}
		System.out.println("Program terminating normally... ");
		scanner.close();
		System.exit(0);

	}
}
