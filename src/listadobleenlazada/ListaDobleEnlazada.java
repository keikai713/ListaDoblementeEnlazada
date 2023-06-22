package listadobleenlazada;

/* Autor: Alejandro Pérez Durán.
 * Fecha de creación: 30 de Septiembre de 2014.
 */
import java.util.Scanner;

public class ListaDobleEnlazada {

    //Creación de un objeto de la clase Scanner
    Scanner escaner = new Scanner(System.in);
    Lista listadoble = new Lista();

    void menu() {
        //Declaración de la varible que se lee en el menú
        byte opcion;
        do {
            System.out.println("\nMENÚ\n");
            System.out.println("1.- Insertar");
            System.out.println("2.- Visualizar");
            System.out.println("3.- Eliminar");
            System.out.println("4.- Búsqueda");
            System.out.println("5.- Salir");
            System.out.println("\nSelecciona una opción");
            opcion = escaner.nextByte();
            switch (opcion) {
                case 1:
                    submenuInsertar();
                    break;
                case 2:
                    listadoble.visualizar();
                    break;
                case 3:
                    System.out.println("\nEscribe el dato del nodo que quieres eliminar:");
                    int dato = escaner.nextInt();
                    listadoble.eliminar(dato);
                    break;
                case 4:
                    System.out.println("\nEscribe el dato del nodo que quieres buscar en la lista:");
                    int datob = escaner.nextInt();
                    Nodo nodob = listadoble.buscarLista(datob);
                    if (nodob == null) {
                        System.out.println("\nEl nodo no se encontró en la lista");
                    } else {
                        System.out.println("\nLa dirección del nodo buscado es:");
                        System.out.println(nodob);
                    }
                    break;
                case 5:
                    System.out.println("\n[PROGRAMA FINALIZADO]");
                    break;
                default:
                    System.out.println("\n[ERROR, VALOR NO VÁLIDO]");
                    break;
            }
        } while (opcion != 5);
    }

    void submenuInsertar() {
        //Variable del submenú
        byte opcion;

        do {
            System.out.println("\nSUBMENÚ INSERTAR\n");
            System.out.println("1.- Insertar a la cabeza de la lista");
            System.out.println("2.- Insertar después de la cabeza");
            System.out.println("3.- Salir");
            System.out.println("\nSelecciona una opción");
            opcion = escaner.nextByte();

            switch (opcion) {
                case 1: {
                    int dato;
                    int k = 5; //Número de nodos que son insertados elementos en la lista
                    for (; k > 0; k--) {
                        System.out.println("\n Esribe el número del nodo:");
                        dato = escaner.nextInt();
                        listadoble.insertarCabezaLista(dato);
                    }
                }
                break;
                case 2: {
                    System.out.println("\nEscribe el número del último nodo de la lista:");
                    int dato = escaner.nextInt();
                    System.out.println("\nEscribe el dato del nodo a insertar:");
                    int datoNuevo = escaner.nextInt();
                    //La variable "ultimoNodo" contendrá la dirección del último nodo de la lista generada con el método insertarCabezaLista.
                    Nodo ultimoNodo = listadoble.buscarLista(dato);
                    //Llamada al método insertarDespues con la variable "ultimoNodo" y el dato del nuevo nodo
                    listadoble.insertarDespues(ultimoNodo, datoNuevo);
                }
                break;
                case 3: {
                    System.out.println("\n[SUBMENÚ INSERTAR FINALIZADO]");
                }
                break;
                default:
                    System.out.println("\n[ERROR, VALOR NO VÁLIDO]");
                    break;
            }
        } while (opcion != opcion);
    }

    public static void main(String[] args) {
        //Creación del objeto que hace instancia con la clase ListaDobleEnlazada
        ListaDobleEnlazada ld = new ListaDobleEnlazada();
        //Llamada al menú principal
        ld.menu();
    }
}