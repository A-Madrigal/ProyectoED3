package proyecto3_ed;

import java.util.Scanner;

public class Proyecto3_ED {

    public static void main(String[] args) {
        NodoArbol raiz = new NodoArbol("Carlos", "M");
        NodoArbol nodo2 = new NodoArbol("Maria", "F");
        NodoArbol nodo3 = new NodoArbol("Luis", "M");

        raiz.setNodoizq(nodo2);
        nodo2.setNodoizq(new NodoArbol("Ana", "F"));
        nodo2.setNododer(new NodoArbol("Jorge", "M"));

        raiz.setNododer(nodo3);
        nodo3.setNodoizq(new NodoArbol("Alicia", "F"));
        nodo3.setNododer(new NodoArbol("Andres", "F"));

        Scanner OP = new Scanner(System.in);
        int opci = 0;
        while (opci != 4) {
            System.out.println("POR FAVOR DIGITE UNA DE LAS OPCIONES...!");

            System.out.println("1-Nombre de todos los progenitores Femeninos de Carlos");
            System.out.println("2-Inorden, Preorden y PostOrden ");
            System.out.println("3-Insertar al arbol genealogico de Carlos");
            System.out.println("-------------------");
            System.out.println("4-SALIR DEL SISTEMA");
            System.out.println(" ");
            opci = OP.nextInt();
            switch (opci) {
                case 1:
                    if (raiz != null) {
                        System.out.println(nodo2.getDato());
                        System.out.println(nodo2.getNodoizq());
                        System.out.println(nodo3.getNodoizq());
                    }
                    break;
                case 2:
                    System.out.println("InOrden:");
                    InOrden(raiz);

                    System.out.println("\nPreOrden:");
                    PreOrden(raiz);

                    System.out.println("\nPostOrden:");
                    PostOrden(raiz);
                    break;
                case 3:
                    Scanner tec = new Scanner(System.in);
                    System.out.println("Digite el nombre: ");
                    String Nombre;
                    Nombre = tec.nextLine();
                    System.out.println("Digite el genero: F o M");
                    String Genero;
                    Genero = tec.nextLine();
                    NodoArbol nodo4 = new NodoArbol(Nombre, Genero);
                    System.out.println("La persona ingresada es:\n " + nodo4.getDato());
                    System.out.println(nodo4.getGenero());
                    break;
                default:
                    System.out.println("SALIENDO DEL SISTEMA.....");
                    break;
            }
        }
    }

    public static void InOrden(NodoArbol raiz) {
        if (raiz != null) {
            InOrden(raiz.getNodoizq());
            System.out.println(raiz.getDato());
            InOrden(raiz.getNododer());
        }
    }

    public static void PreOrden(NodoArbol raiz) {
        if (raiz != null) {
            System.out.println(raiz.getDato());
            PreOrden(raiz.getNodoizq());
            PreOrden(raiz.getNododer());
        }
    }

    public static void PostOrden(NodoArbol raiz) {
        if (raiz != null) {
            PostOrden(raiz.getNodoizq());
            PostOrden(raiz.getNododer());
            System.out.println(raiz.getDato());
        }
    }
}
