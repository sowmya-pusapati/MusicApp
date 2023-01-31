import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
  private String name;
  private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public boolean findSong(String title)
    {
        for(Song s:songs) {
            if (s.getTitle().equals(title))
                return true;
        }
            return false;

    }

    void addSongToAlbum(String name,double duration){
        Song s=new Song(name,duration);
        if(findSong(s.getTitle()))
        {
            System.out.println("song already present in the list");
        }
        else {
            songs.add(s);
            System.out.println("song added");
        }
          return;

    }

    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playList){
        if(findSong(title)==true){
            for(Song song:songs)
            {
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("song has been added");
                    break;
                }
            }
        }
        else {
            System.out.println("song is not present");
        }
       return;
    }
    public void addToPlaylistFromAlbum(int trackNo,LinkedList<Song> playlist)
    {
        int index=trackNo-1;
        if(index>=0&&index<=songs.size()-1)
        {
            System.out.println("song has been added");
            playlist.add(songs.get(index));
        }
        else {
            System.out.println("invalid track");
        }
        return;
    }
}

