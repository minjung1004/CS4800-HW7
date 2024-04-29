package Proxy;

public class Driver {
    public static void main(String[] args) {
        RealSongService realSongService = new RealSongService();
        ProxySongService proxySongService = new ProxySongService(realSongService);

        // Search for songs using the proxy service
        System.out.println("Searching for song with ID 1:");
        System.out.println(proxySongService.searchById(1));

        System.out.println("\nSearching for songs with title 'Song2':");
        System.out.println(proxySongService.searchByTitle("Song2"));

        System.out.println("Searching for song with ID 3:");
        System.out.println(proxySongService.searchById(3));

        System.out.println("\nSearching for songs with album 'album4':");
        System.out.println(proxySongService.searchByAlbum("album4"));

        System.out.println("\nSearching for songs with title 'Song5':");
        System.out.println(proxySongService.searchByTitle("Song5"));

    }
}
