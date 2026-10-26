package mx.unam.domain;

public class Playlist {

    private final String nombre;
    private final String creator;
    private final int numberOfSongs;

    private Playlist(Builder builder) {
        this.nombre = builder.name;
        this.creator = builder.creator;
        this.numberOfSongs = builder.numberOfSongs;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String creator;
        private int numberOfSongs;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder creator(String creator) {
            this.creator = creator;
            return this;
        }

        public Builder numberOfSongs(int numberOfSongs) {
            this.numberOfSongs = numberOfSongs;
            return this;
        }

        public Playlist build() {
            return new Playlist(this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getCreator() {
        return creator;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }
}
