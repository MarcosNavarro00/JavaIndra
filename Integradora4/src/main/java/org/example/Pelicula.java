package org.example;

public class Pelicula {

    private String titulo;
    private int espectadores;
    private int salas;
    private long gananciaBruta;
    private long gananciaNeta;

    public Pelicula(String titulo, int espectadores, int salas, long gananciaBruta, long gananciaNeta) {
        this.titulo = titulo;
        this.espectadores = espectadores;
        this.salas = salas;
        this.gananciaBruta = gananciaBruta;
        this.gananciaNeta = gananciaNeta;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getEspectadores() {
        return espectadores;
    }

    public int getSalas() {
        return salas;
    }

    public long getGananciaBruta() {
        return gananciaBruta;
    }

    public long getGananciaNeta() {
        return gananciaNeta;
    }

    @Override
    public String toString() {
        return "\nPelicula{" +
                "titulo='" + titulo + '\'' +
                ", espectadores=" + espectadores +
                ", salas=" + salas +
                ", gananciaBruta=" + gananciaBruta +
                ", gananciaNeta=" + gananciaNeta +
                '}';
    }
}
