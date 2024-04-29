package Proxy;

public class Song {
    private Integer songID;
    private String title;
    private String artists;
    private String album;
    private int duration;

    public Song(Integer songID, String title, String artists, String album, int duration){
        this.songID = songID;
        this.title = title;
        this.artists = artists;
        this.album = album;
        this.duration = duration;
    }
    public Integer getSongID(){
        return songID;
    }
    public String getTitle(){
        return title;
    }
    public String getArtists(){
        return artists;
    }
    public String getAlbum(){
        return album;
    }
    public int getDuration(){
        return duration;
    }

}


