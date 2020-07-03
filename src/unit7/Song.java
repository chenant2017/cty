package unit7;

import java.io.*;

public class Song implements Serializable {
	String title_;
	String artist_;
	String genre_;
	Date releaseDate_;
	
	public Song() {
		title_ = "";
		artist_ = "";
		genre_ = "";
		releaseDate_ = new Date();
	}
	
	public Song(String title, String artist, String genre, Date releaseDate) {
		title_ = title;
		artist_ = artist;
		genre_ = genre;
		releaseDate_ = releaseDate;
	}
	
	public String getTitle() {
		return title_;
	}
	
	public String getArtist() {
		return artist_;
	}
	
	public String getGenre() {
		return genre_;
	}
	
	public Date getReleaseDate() {
		return releaseDate_;
	}
	
	//The writeObject and readObject methods are here so serialization and de-serialization can happen.
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(title_);
		out.writeUTF(artist_);
		out.writeUTF(genre_);
		out.writeInt(releaseDate_.getMonth());
		out.writeInt(releaseDate_.getDay());
		out.writeInt(releaseDate_.getYear());
	}
	
	private void readObject(ObjectInputStream in) throws IOException {
		title_ = in.readUTF();
		artist_ = in.readUTF();
		genre_ = in.readUTF();
		int m = in.readInt();
		int d = in.readInt();
		int y = in.readInt();
		releaseDate_ = new Date(m, d, y);
	}
}
