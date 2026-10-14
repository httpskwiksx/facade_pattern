public class Main {

    public static void main(String[] args) {

        MediaConversionFacade facade =
                new MediaConversionFacade();

        runConversion(facade, "video.avi", "mp4");
        runConversion(facade, "movie.mkv", "mp4");
        runConversion(facade, "clip.mov", "mkv");

        runConversion(facade, "video.txt", "mp4");
        runConversion(facade, "video.avi", "xyz");
    }

    private static void runConversion(
            MediaConversionFacade facade,
            String fileName,
            String targetFormat
    ) {

        try {
            System.out.println(
                    facade.convert(fileName, targetFormat)
            );

        } catch (IllegalArgumentException e) {

            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

