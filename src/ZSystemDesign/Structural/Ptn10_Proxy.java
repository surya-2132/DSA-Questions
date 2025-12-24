package ZSystemDesign.Structural;

import java.util.HashMap;
import java.util.Map;

    /**
     The Proxy Pattern is a structural design pattern that provides
     a surrogate or placeholder for another object to control access to it.

     A proxy acts as an intermediary that implements the same interface as the original object,
     allowing it to intercept and manage requests to the real object.

     Trade Off:
     Increased Complexity: Introducing a proxy layer adds more components to the system, which can make the overall design harder to understand and maintain.
     Potential Delays: The proxy may introduce delays in accessing the actual object, especially when additional logic like permission checks or data fetching is involved.
     Maintenance Overhead: With extra layers and duplicated interfaces, maintaining proxies alongside real objects can increase the development and debugging effort.
     */

public class Ptn10_Proxy {
    public static void main(String[] args) {
        VideoDownloader cacheVideoDownloader = new CachedVideoDownloader();
        System.out.println("User 1 tries to download the video.");
        cacheVideoDownloader.downloadVideo("https://video.com/proxy-pattern");

        System.out.println();

        System.out.println("User 2 tries to download the same video again.");
        cacheVideoDownloader.downloadVideo("https://video.com/proxy-pattern");
    }
}


interface VideoDownloader {
    String downloadVideo(String videoURL);
}

// ========== RealVideoDownloader Class ==========
class RealVideoDownloader implements VideoDownloader {

    @Override
    public String downloadVideo(String videoUrl) {
        System.out.println("Downloading video from URL: " + videoUrl);
        return "Video content from " + videoUrl;
    }
}


// =============== Proxy With Cache ====================
class CachedVideoDownloader implements VideoDownloader {

    private RealVideoDownloader realDownloader;
    private Map<String, String> cache;

    public CachedVideoDownloader() {
        this.realDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }

    @Override
    public String downloadVideo(String videoUrl) {
        if (cache.containsKey(videoUrl)) {
            System.out.println("Returning cached video for: " + videoUrl);
            return cache.get(videoUrl);
        }

        System.out.println("Cache miss. Downloading...");
        String video = realDownloader.downloadVideo(videoUrl);
        cache.put(videoUrl, video);
        return video;
    }
}