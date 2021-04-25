public class Song {

  private Artist artist;
  private String name;

    /**
    this method is a constructor for the Song class
    @param Artist object and the artist's name
    @return artist, name
    **/
    public Song(Artist _artist, String _name) 
    {
      artist = _artist;
      name = _name;
    }

    /**
    this method gets the name of the song
    @param none
    @return the name
    **/
    public String getName() 
    {
      return name;
    }

    /** 
    this method gets the artist of the song
    @param none
    @return the artist's name
    **/
    public Artist getArtist() 
    {
      return artist;
    }

    /**
    this method checks to see if both objects have the same name and artist
    @param the song that wants to be compared to the current song
    @return whether or not the song has the same name and artist
    **/
    public boolean equals(Song other) 
    {

      if (name.equals(other.getName()) && artist.equals(other.getArtist()))
      {
        return true;
      }
      else 
      {
        return false;
      }
    }

    /**
    this method is the toString
    @param none
    @return artist name
    **/
    public String toString() 
    {
      return artist + " " + name;
    }
}