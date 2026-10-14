import java.util.Locale;

public class CodecFactory {

    public String selectCodec(String targetFormat) {

        if (targetFormat == null || targetFormat.isBlank()) {
            throw new IllegalArgumentException(
                    "Target format cannot be empty"
            );
        }

        String format = targetFormat.trim()
                .toLowerCase(Locale.ROOT);

        return switch (format) {
            case "mp4" -> "H264";
            case "mkv" -> "H265";
            case "mov" -> "PRORES";
            case "avi" -> "MPEG4";
            default -> throw new IllegalArgumentException(
                    "Unsupported target format: " + format
            );
        };
    }
}

