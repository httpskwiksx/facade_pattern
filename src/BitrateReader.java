public class BitrateReader {

    public int calculateTargetBitrate(
            int sourceBitrateKbps,
            String codec
    ) {

        if (sourceBitrateKbps <= 0) {
            throw new IllegalArgumentException(
                    "Source bitrate must be positive"
            );
        }

        if (codec == null) {
            throw new IllegalArgumentException(
                    "Codec cannot be null"
            );
        }

        double factor = switch (codec) {
            case "H264" -> 0.70;
            case "H265" -> 0.55;
            case "PRORES" -> 1.25;
            case "MPEG4" -> 0.90;
            default -> throw new IllegalArgumentException(
                    "Unsupported codec: " + codec
            );
        };

        return (int) Math.round(sourceBitrateKbps * factor);
    }
}
