package listadobleenlazada;

/* Autor: Alejandro Pérez Durán.
 * Fecha de creación: 30 de Septiembre de 2014.
 */
public class Nodo {

    int dato;
    Nodo siguiente;
    Nodo anterior;

    Nodo(int entrada) {
        dato = entrada;
        siguiente = null;
        anterior = null;
    }
}