package com.app.spotifydemo;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Song {
	
	
	private String title;
	private String album;
	private String artist;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	
	public static ArrayList<Song> getSongs(){
		
		ArrayList<Song> songs =  new ArrayList<Song>();
		Song s = new Song();
		s.setTitle("Coming Back to Life");
		s.setAlbum("Dark Side of the Moon");
		songs.add(s);
		
		Song s2 = new Song();
		s2.setTitle("Master of Puppets");
		s2.setAlbum("The Black Album");
		songs.add(s2);
		return songs;
	}
   
	
	public static Song fromJSON(JSONObject jsonObject){
		Song song = new Song();
		
		try{
			song.title = jsonObject.getString("name");
			JSONObject res = (JSONObject) jsonObject.get("album");
			song.album=res.getString("name");
			//song.artist = jsonObject.getString("artist");
			
		}
		catch (JSONException e){
			e.printStackTrace();
			return null;
		}
		
		return song;
	}

	public static ArrayList<Song> fromJSONArray(JSONArray jsonArray)
	{
		 ArrayList<Song> songs = new ArrayList<Song>(jsonArray.length());
		for (int i=0; i < jsonArray.length(); i++) {
	          JSONObject songJson = null;
	          try {
	          	songJson = jsonArray.getJSONObject(i);
	          } catch (Exception e) {
	              e.printStackTrace();
	              continue;
	          }

	          Song tweet = Song.fromJSON(songJson);
	          if (tweet != null) {
	          	songs.add(tweet);
	          }
	      }

		return songs;
	}

}
