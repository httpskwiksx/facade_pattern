import java.util.Locale;

public class MediaConversionFacade {

    private final MetadataReader metadataReader =
            new MetadataReader();

    private final CodecFactory codecFactory =
            new CodecFactory();

    private final BitrateReader bitrateReader =
            new BitrateReader();

    private final AudioMixer audioMixer =
            new AudioMixer();

    public String convert(String fileName, String targetFormat) {

        try {
            MediaInfo media = metadataReader.read(fileName);

            String codec = codecFactory.selectCodec(targetFormat);

            String format = targetFormat.trim()
                    .toLowerCase(Locale.ROOT);

            int targetBitrate = bitrateReader.calculateTargetBitrate(
                    media.getBitrateKbps(),
                    codec
            );

            int targetChannels = audioMixer.mixChannels(
                    media.getAudioChannels(),
                    format
            );

            return "Converted " + media.getFileName()
                    + " from " + media.getSourceFormat()
                    + " to " + format
                    + " | codec=" + codec
                    + " | bitrate=" + targetBitrate + " kbps"
                    + " | audioChannels=" + targetChannels;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Conversion failed: " + e.getMessage(), e
            );
        }
    }
}

