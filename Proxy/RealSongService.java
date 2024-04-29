package Proxy;

import java.util.*;

public class RealSongService implements SongService{
    private Map<Integer, Song> songMap = new HashMap<>();

    public RealSongService(){
        songMap.put(1, new Song(1, "Song1", "Artist1", "album1", 180));
        songMap.put(2, new Song(2, "Song2", "Artist2", "album2", 280));
        songMap.put(3, new Song(3, "Song3", "Artist3", "album3", 222));
        songMap.put(4, new Song(4, "Song4", "Artist4", "album4", 340));
        songMap.put(5, new Song(5, "Song5", "Artist5", "album5", 120));
    }
    @Override
    public Song searchById(Integer songID) {
        try {
            // simulate server call delay
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return songMap.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
       try {
           Thread.sleep(1000);
       }catch(InterruptedException e){
           e.printStackTrace();
       }
       List<Song> result = new ArrayList<>();
       for (Song song : songMap.values()){
           if(song.getTitle().equals(title)){
               result.add(song);
           }
       }
       return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        List<Song> result = new ArrayList<>();
        for(Song song : songMap.values()){
            if(song.getAlbum().equals(album)){
                result.add(song);
            }
        }
        return result;
    }
}
