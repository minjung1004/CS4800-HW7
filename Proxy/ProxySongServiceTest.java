package Proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProxySongServiceTest {
    @Test
    @DisplayName("Testing search by id cached")
    public void testSearchById_Cached() {
        RealSongService testRealSongService = new RealSongService();
        ProxySongService testProxySongService = new ProxySongService(testRealSongService);

        // Fetched from RealSongService
        Song song1 = testProxySongService.searchById(1);
        // Fetched from cache
        Song song2 = testRealSongService.searchById(1);

        assertEquals(song1, song2);
    }

    @Test
    @DisplayName("Testing search by title cached")
    public void testSearchByTitle_Cached() {
        RealSongService testRealSongService = new RealSongService();
        ProxySongService testProxySongService = new ProxySongService(testRealSongService);

        // Fetched from RealSongService
        List<Song> song1 = testProxySongService.searchByTitle("Song2");
        // Fetched from cache
        List<Song> song2 = testRealSongService.searchByTitle("Song2");

        assertEquals(song1, song2);
    }

    @Test
    @DisplayName("Testing search by album cached")
    public void testSearchByAlbum_Cached() {
        RealSongService testRealSongService = new RealSongService();
        ProxySongService testProxySongService = new ProxySongService(testRealSongService);

        // Fetched from RealSongService
        List<Song> song1 = testProxySongService.searchByAlbum("album3");
        // Fetched from cache
        List<Song> song2 = testRealSongService.searchByAlbum("album3");

        assertEquals(song1, song2);
    }


}