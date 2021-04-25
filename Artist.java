import java.util.ArrayList;

public class Artist {

    private String artistName;
    private ArrayList<Song> songs; 

    /**
    this method is the constructor for this class
    @param String name
    @return artistName
     **/
    public Artist(String name) 
    {
        artistName = name;
        songs = new ArrayList<Song>();
    }

    /**
    this method gets teh songs from the ArrayList songs
    @param none
    @return the songs of the artist in the list 
     **/
    public ArrayList<Song> getSongs() 
    {
        return songs;
    }

    /**
    this method gets the name of the artist
    @param none
    @return the artist's name
     **/
    public String getName() 
    {
        return artistName;
    }

    /**
    this method checks to see if the artists names are the same
    @param another artist's name
    @return if the artists' names are the same 
     **/
    public boolean equals(Artist other) 
    {
        if(artistName.equals(other.getName()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
    Method is Used to Add newsongs to playlist
    @param the song that wants to be added
    @return nothing
     **/
    public void addSong(String song) 
    {
        Song s = new Song(this, song);
        songs.add(s);
    }

    /**
    Method is used to remove a song from the artist
    @param the song name
    @return nothing
     **/
    public void removeSong(String song) 
    {
        Song s1 = new Song (this, song);
        songs.remove(s1);
    }

    /**
    this method is the toString 
    @param none
    @return the artist name
     **/
    public String toString() 
    {
        return artistName;
    }
}