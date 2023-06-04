package models.Beans;

public class Canciones {
    private int idCancion;
    private String nombreCancion;
    private String idBanda;
    private int favorito;

    public Canciones(int idCancion, String nombreCancion, String idBanda) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.idBanda = idBanda;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(String idBanda) {
        this.idBanda = idBanda;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }
}
