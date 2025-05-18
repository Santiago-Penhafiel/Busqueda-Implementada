public class Personaje {
    public String nombre;
    public String especie;
    public String ocupacion;
    public String descripcion;
    public Personaje siguiente;

    public Personaje(String nombre, String especie, String ocupacion, String descripcion) {
        this.nombre = nombre;
        this.especie = especie;
        this.ocupacion = ocupacion;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Especie: " + especie + "\n" +
                "Ocupación: " + ocupacion + "\n" +
                "Descripción: \"" + descripcion + "\"\n";
    }
}