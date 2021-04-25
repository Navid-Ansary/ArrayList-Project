import java.util.ArrayList;

public class PlayList 
{
    public static int MAX_NUMBER_SONGS = 10;
    private String listName;
    private ArrayList<Song> songs;
    private ArrayList<Integer> stars;

    /**
    this method is the constructor for the name of the playlist
    @param the name the user wants the playlist to be
    @return the playlist's name
     **/
    public PlayList(String name) 
    {
        listName = name;
        songs = new ArrayList<Song>();
        stars = new ArrayList<Integer>();
    }

    /**
    this method gets the star rating from the ArrayList
    @param none 
    @return the stars from the ArrayList
     **/
    public ArrayList<Integer> getStars() 
    {
        return stars;
    }

    /**
    this method finds the average rating from the list of stars
    @param none
    @return the average from the ratings as a decimal
     **/
    public double averageRating() 
    {
        int count = 0;
        double average = 0.0;
        int sum = 0;
        for(int i = 0; i < stars.size(); i++)
        {
            sum += stars.get(i);
            count++;
        }
        average = (double) sum / count;
        return average;
    }

    /**
    this method 
    @param 
    @return 
     **/
    public double averageRating(Artist artist) 
    {
        int count = 0;
        double average = 0;
        int sum = 0;
        for (int i = 0; i < stars.size(); i++)
        {
            if(songs.get(i).getArtist().equals(artist))
            {
                sum+= stars.get(i);
                count++;
            }
        }
        average = (double) sum / count;
        return average;
    }

    /**
    this method gets the songs from the ArrayList
    @param none
    @return the songs
     **/
    public ArrayList<Song> getSongs() 
    {
        return songs;
    }

    /**
    this method returns a list of songs from that specifc artist
    @param an artist object
    @return a list of songs from that artist
     **/
    public Song[] getSongs(Artist artist) 
    {
        int count = 0;
        for(int i = 0; i < songs.size(); i++)
        {
            if(songs.get(i).getArtist().equals(artist))
            {
                count++;
            }
        }
        Song []arraySongs = new Song[count];
        int count2 = 0;
        for(int i = 0; i < songs.size(); i++)
        {
            if(songs.get(i).getArtist().equals(artist))
            {
                arraySongs[count2] = songs.get(i);
                count2++;
            }
        }
        return arraySongs;
    }

    /**
    this method returns a new ArrayList of all artists associated with the song name from the parameter
    @param the desired song name
    @return an ArrayList of all the artists associated with the song
     **/
    public ArrayList<Artist> getArtist(String songName) 
    {
        ArrayList<Artist> songsArtist = new ArrayList <Artist>();
        for (int i = 0; i < songs.size(); i++)
        {
            if (songs.get(i).getName().equals(songName))
            {
                songsArtist.add(songs.get(i).getArtist());
            }
        }
        return songsArtist;
    }

    /**
    Methos is used to find the index of a song 
    @param a random song
    @return the index of where the song is found
     **/
    private int indexOf(Song someSong) 
    {
        return songs.indexOf(someSong);
    }

    /**
    This methos is used to switch the position of the two songs
    @param two different songs
    @return nothing
     **/
    public void swap(Song song1, Song song2) 
    {
        int spot1 = indexOf(song1);
        int spot2 = indexOf(song2);
        int tempSpot = stars.get(spot1);

        songs.set(spot1, song2);
        stars.set(spot1, stars.get(spot2));
        songs.set(spot2, song1);
        stars.set(spot2, tempSpot);

    }

    /**
    Method is used to add another song to the ArrayList songs if the value does not exceed 10
    @param the song and the rating 
    @return true or false if the song was added or not
     **/
    public boolean add(Song _song, int _stars) 
    {
        if(songs.size() < MAX_NUMBER_SONGS)
        {
            songs.add(_song);
            stars.add(_stars);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
    method is used to remove a song fom the ArrayList
    @param song that needs to be removed
    @return nothing
     **/
    public void removeSong(Song song) 
    {
        for(int i = 0; i < songs.size(); i++)
        {
            if (songs.get(i).equals(song))
            {
                songs.remove(i);
                stars.remove(i);
                i--;
            }
        }
    }

    /**
    Method is used remove all occurrences of the songs by the certain artist
    @param artist that needs to be removed
    @return nothing
     **/
    public void removeArtist(Artist artist) 
    {
        for(int i = 0; i < songs.size(); i++)
        {
            if(songs.get(i).getArtist().equals(artist))
            {
                songs.remove(i);
                stars.remove(i);
                i--;
            }
        }
    }

    /**
    this method removes the songs that are lower than desired rating
    @param the cutoff of the ratings
    @return nothing
     **/
    public void removeLowStars(int cutOff) 
    {
        for(int i = 0; i < stars.size(); i++)
        {
            if (stars.get(i)<= cutOff)
            {
                songs.remove(i);
                stars.remove(i);
                i--;
            }
        }
    }

    public PlayList sortByRating()
    {
        PlayList sorted = new PlayList("Sorted");
        for(int i = 0; i < stars.size(); i++)
        {
            int temp = stars.get(i);
            int possibleIndex = i;
            while (possibleIndex > 0 && temp > stars.get(possibleIndex - 1))
            {
                stars.set(possibleIndex, possibleIndex - 1);
                possibleIndex--;
            }
            stars.set(possibleIndex, temp);
        }
        return sorted.sortByRating();
    }

    public PlayList shuffle()
    {
        PlayList shuffled = new PlayList("Shuffled");
        return shuffled;
    }

    public String toString() {
        String r = "PlayList[ \n ";

        for (int i = 0; i < songs.size(); i++) {
            Song s = songs.get(i);
            int strs = stars.get(i);
            r += "\t [" + i + "] " + s.getName() + " by " + s.getArtist().getName() + ", rating : " + strs + "\n ";
        }
        r += "]";
        return r;
    }

}
