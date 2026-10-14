public class MediaInfo {

    private final String fileName;
    private final String sourceFormat;
    private final int bitrateKbps;
    private final int audioChannels;

    public MediaInfo(String fileName, String sourceFormat,
                     int bitrateKbps, int audioChannels) {

        this.fileName = fileName;
        this.sourceFormat = sourceFormat;
        this.bitrateKbps = bitrateKbps;
        this.audioChannels = audioChannels;
    }

    public String getFileName() {
        return fileName;
    }

    public String getSourceFormat() {
        return sourceFormat;
    }

    public int getBitrateKbps() {
        return bitrateKbps;
    }

    public int getAudioChannels() {
        return audioChannels;
    }
}

