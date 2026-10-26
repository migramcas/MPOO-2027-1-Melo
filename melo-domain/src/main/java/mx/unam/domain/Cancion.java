package mx.unam.domain;

public class Cancion extends ContenidoMultimedia {

    private GeneroMusical genero;
    private int numeroPista;

    private Cancion(Builder builder) {
        super(builder);
        this.genero = builder.genero;
        this.numeroPista = builder.numeroPista;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends ContenidoMultimedia.Builder<Cancion, Builder> {

        private GeneroMusical genero;
        private int numeroPista;

        public Builder genero(GeneroMusical genero) {
            this.genero = genero;
            return self();
        }

        public Builder numeroPista(int numeroPista) {
            this.numeroPista = numeroPista;
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Cancion build() {
            return new Cancion(this);
        }
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }
    
    public int getNumeroPista() {
        return numeroPista;
    }

    public void setNumeroPista(int numeroPista) {
        this.numeroPista = numeroPista;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo canción...");
    }

    @Override
    public String getDescripcion() {
        return "Canción - Pista: " + numeroPista + ", Género: " + genero;
    }
}