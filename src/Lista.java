import javax.swing.*;

public class Lista {

    public Personaje inicio;
    public int tamano;

    public Lista() {
        inicio = null;
        tamano = 0;

        agregar("Mordecai", "Azulejo", "Trabajador del parque",
                "Pájaro azul alto y tranquilo, le gusta jugar videojuegos y evita responsabilidades.");
        agregar("Rigby", "Mapache", "Trabajador del parque",
                "Impulsivo y desordenado, es el mejor amigo de Mordecai y también fanático de los videojuegos.");
        agregar("Benson", "Máquina de chicles", "Jefe del parque",
                "Jefe malhumorado pero justo, constantemente grita a sus empleados para que trabajen.");
        agregar("Papaleta", "Humanoide de dulce", "Co-dueño del parque",
                "Inocente, amable y excéntrico, tiene una visión infantil del mundo.");
        agregar("Musculoso", "Humano musculoso", "Trabajador del parque",
                "Bromista rudo y molesto, pero en el fondo tiene un buen corazón.");
        agregar("Fantasmano", "Fantasma", "Trabajador del parque",
                "Fantasma flotante con una mano en la cabeza, suele gritar y hacer bromas.");
        agregar("Skips", "Yeti", "Técnico del parque",
                "Sabio, fuerte y eterno, siempre sabe cómo resolver los problemas sobrenaturales.");
    }

    public void mostrarLista(JTextArea txtCont) {
        if (inicio == null) {
            txtCont.setText("Lista vacía");
        } else {
            StringBuilder listaStr = new StringBuilder();
            Personaje actual = inicio;
            while (actual != null) {
                listaStr.append("Nombre: ").append(actual.nombre).append("\n")
                        .append("Descripción: ").append(actual.descripcion).append("\n")
                        .append("-----------------------\n");
                actual = actual.siguiente;
            }
            txtCont.setText(listaStr.toString());
        }
    }


    public void actualizarLista(JTextArea txtCont){
        mostrarLista(txtCont);
    }


    public void ordenarBurbuja() {
        if (inicio == null || inicio.siguiente == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Personaje prev = null;
            Personaje actual = inicio;

            while (actual != null && actual.siguiente != null) {
                Personaje siguiente = actual.siguiente;

                if (actual.nombre.compareToIgnoreCase(siguiente.nombre) > 0) {
                    // Intercambiar nodos actual y siguiente
                    if (prev == null) {
                        // actual es el primero, cambiar inicio
                        inicio = siguiente;
                    } else {
                        prev.siguiente = siguiente;
                    }

                    actual.siguiente = siguiente.siguiente;
                    siguiente.siguiente = actual;

                    swapped = true;
                    prev = siguiente; // 'siguiente' está ahora delante de 'actual'
                } else {
                    prev = actual;
                    actual = actual.siguiente;
                }
            }
        } while (swapped);

        JOptionPane.showMessageDialog(null, "Lista ordenada");
    }

    public int buscarLineal(String nombre, JTextArea txtCont) {
        Personaje actual = inicio;
        int posicion = 0;

        while (actual != null) {
            if (actual.nombre.equalsIgnoreCase(nombre)) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1;
    }

    public Personaje [] convertirAArray(){
        Personaje[] array = new Personaje[tamano];
        Personaje actual = inicio;
        int i = 0;
        while (actual != null){
            array[i++] = actual;
            actual = actual.siguiente;
        }
        return array;
    }


    public boolean eliminar(String nombre, JTextArea txtCont) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "Lista Vacía");
            return false;
        }

        if (inicio.nombre.equalsIgnoreCase(nombre)) {
            inicio = inicio.siguiente;
            tamano--;
            actualizarLista(txtCont);
            return true;
        }

        Personaje actual = inicio;
        while (actual.siguiente != null &&
                !actual.siguiente.nombre.equalsIgnoreCase(nombre)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            actualizarLista(txtCont);
            return true;
        }

        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
        return false;
    }


    public void agregar(String nombre, String especie, String ocupacion, String descripcion){
        Personaje nuevoPersonaje = new Personaje(nombre, especie, ocupacion, descripcion);
        if (inicio == null){
            inicio = nuevoPersonaje;
        } else {
            Personaje actual = inicio;

            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoPersonaje;
        }
        tamano++;
    }

    public void agregarYActualizar(String nombre, String especie, String ocupacion, String descripcion, JTextArea txtCont){
        Personaje nuevoPersonaje = new Personaje(nombre, especie, ocupacion, descripcion);
        if (inicio == null){
            inicio = nuevoPersonaje;
        } else {
            Personaje actual = inicio;

            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoPersonaje;
        }
        tamano++;
        actualizarLista(txtCont);
    }
}










