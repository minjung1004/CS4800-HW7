package Proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RealSongServiceTest {

    @Test
    @DisplayName("Testing search by ID")
    public void testSearchById() {
        RealSongService testRealDongService = new RealSongService();
        Song song = testRealDongService.searchById(1);

        assertEquals("Song1", song.getTitle());
        assertEquals("Artist1", song.getArtists());
        assertEquals("album1", song.getAlbum());
        assertEquals(180, song.getDuration());
    }

    @Test
    @DisplayName("Testing search by title")
    public void testSearchByTitle() {
        RealSongService testRealSongService = new RealSongService();

        List<Song> songs = testRealSongService.searchByTitle("Song2");

        assertEquals(1, songs.size());
        Song song = songs.get(0);
        assertEquals("Song2" , song.getTitle());
        assertEquals("Artist2", song.getArtists());
        assertEquals("album2", song.getAlbum());
        assertEquals(280, song.getDuration());
    }

    @Test
    @DisplayName("Testing seach by album")
    void testSearchByAlbum() {
        RealSongService testRealSongService = new RealSongService();

        List<Song> songs = testRealSongService.searchByAlbum("album3");

        assertEquals(1, songs.size());
        Song song = songs.get(0);
        assertEquals("Song3", song.getTitle());
        assertEquals("Artist3", song.getArtists());
        assertEquals("album3", song.getAlbum());
        assertEquals(222, song.getDuration());
    }

}