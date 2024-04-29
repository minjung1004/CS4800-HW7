package Proxy;

import javax.sound.sampled.Port;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxySongService implements SongService{
    private RealSongService realSongService;
    private Map<Integer, Song> songCache;
    private Map<String, List<Song>> titleCache;
    private Map<String, List<Song>> albumCache;

    public ProxySongService(RealSongService realSongService){
        this.realSongService = realSongService;
        this.songCache = new HashMap<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if(songCache.containsKey(songID)){
            System.out.println("Retreiving song metadata from cache forn songID: " + songID);
            return songCache.get(songID);
        } else {
            Song song = realSongService.searchById(songID);
            songCache.put(songID, song);
            return song;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if(titleCache.containsKey(title)) {
            System.out.println("Retrieving song metadata from cache for title: " + title);
            return titleCache.get(title);
        } else {
            List<Song> songs = realSongService.searchByTitle(title);
            titleCache.put(title, songs);
            return songs;
        }
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if(albumCache.containsKey(album)) {
            System.out.println("Retrieving song metadata from cache for album: " + album);
            return albumCache.get(album);
        } else {
            List<Song> songs = realSongService.searchByAlbum(album);
            albumCache.put(album, songs);
            return songs;
        }
    }
}
