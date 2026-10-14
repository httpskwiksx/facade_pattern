import java.util.Locale;

public class AudioMixer {

    public int mixChannels(int sourceChannels, String targetFormat) {

        if (sourceChannels <= 0) {
            throw new IllegalArgumentException(
                    "Audio channels must be positive"
            );
        }

        if (targetFormat == null || targetFormat.isBlank()) {
            throw new IllegalArgumentException(
                    "Target format cannot be empty"
            );
        }

        String format = targetFormat.trim()
                .toLowerCase(Locale.ROOT);

        int maxChannels = switch (format) {
            case "mp4", "avi" -> 2;
            case "mkv", "mov" -> 6;
            default -> throw new IllegalArgumentException(
                    "Unsupported audio format: " + format
            );
        };

        return Math.min(sourceChannels, maxChannels);
    }
}
