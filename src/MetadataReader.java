import java.util.Locale;

public class MetadataReader {

    public MediaInfo read(String fileName) {

        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException(
                    "File name cannot be empty"
            );
        }

        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex <= 0 || dotIndex == fileName.length() - 1) {
            throw new IllegalArgumentException(
                    "Invalid file extension"
            );
        }

        String format = fileName
                .substring(dotIndex + 1)
                .toLowerCase(Locale.ROOT);

        int bitrate = switch (format) {
            case "avi" -> 2400;
            case "mov" -> 3000;
            case "mp4" -> 1800;
            case "mkv" -> 3200;
            default -> throw new IllegalArgumentException(
                    "Unsupported source format: " + format
            );
        };
        int channels = switch (format) {
            case "mkv", "mov" -> 6;
            default -> 2;
        };

        return new MediaInfo(fileName, format, bitrate, channels);    }
}

