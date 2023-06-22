package listadobleenlazada;
/* Autor: Alejandro Pérez Durán.
 * Fecha de creación: 30 de Septiembre de 2014.
 */

public class Lista {

    private Nodo cabeza;

    public Lista() {
        cabeza = null;
    }

    public Lista insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.siguiente = cabeza;
        if (cabeza != null) {
            cabeza.anterior = nuevo;
        }
        cabeza = nuevo;
        return this;
    }

    public Lista insertarDespues(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.siguiente = anterior.siguiente;
        if (anterior.siguiente != null) {
            anterior.siguiente.anterior = nuevo;
        }
        anterior.siguiente = nuevo;
        anterior.anterior = anterior;
        return this;
    }

    public Nodo buscarLista(int dato) { //Dato: Dato que se busca en la lista.
        //cabeza: miembro de lista, referencia al nodo inicial
        Nodo indice;
        for (indice = cabeza; indice != null; indice = indice.siguiente) {
            if (dato == indice.dato) {
                return indice;
            }
        }
        return null;
    }

    public void eliminar(int entrada) {
        Nodo actual;
        boolean encontrado = false;
        actual = cabeza;
// bucle de búsqueda
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.dato == entrada);
            if (!encontrado) {
                actual = actual.siguiente;
            }
        }
// Enlace de nodo anterior con siguiente
        if (actual != null) {// distingue entre nodo cabecera o del resto de la lista
            if (actual == cabeza) {
                cabeza = actual.siguiente;
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = null;
                }
            } else {
                if (actual.siguiente != null) // no es el ultimo nodo
                {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                } else // último nodo
                {
                    actual.anterior.siguiente = null;
                }
                actual = null;
            }
        }
    }

    public void visualizar() {
        Nodo n;
        n = cabeza;
        while (n != null) {
            System.out.println("\nDato: " + n.dato + " ");
            System.out.println("Direccción: " + n);
            System.out.println("Siguiente: " + n.siguiente);
            System.out.println("Anterior: " + n.anterior);
            n = n.siguiente;
        }
    }
}