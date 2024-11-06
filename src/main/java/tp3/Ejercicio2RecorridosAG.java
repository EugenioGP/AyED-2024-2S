package tp3;

import java.util.ArrayList;
import java.util.List;


public class Ejercicio2RecorridosAG {

    private static boolean isOdd(Integer n) {
        return (n % 2) != 0;
    }

    /***
     *
     * @param a the tree
     * @param n value
     * @return Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
     * pasados como parámetros, recorrido en preorden.
     */
    public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n) {
        List<Integer> oddNumbersGreaterThanN = new ArrayList<>();
        numerosImparesMayoresQuePreOrdenRecursive(a, n, oddNumbersGreaterThanN);
        return oddNumbersGreaterThanN;
    }

    private static void numerosImparesMayoresQuePreOrdenRecursive(GeneralTree<Integer> a, Integer n, List<Integer> oddNumbersGreaterThanN) {
        if (isOdd(a.getData()) && a.getData() > n) oddNumbersGreaterThanN.add(a.getData());
        for(GeneralTree<Integer> child : a.getChildren()) {
            numerosImparesMayoresQuePreOrdenRecursive(child, n, oddNumbersGreaterThanN);
        }
    }

    /***
     *
     * @param a the tree
     * @param n value
     * @return Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
     * pasados como parámetros, recorrido en inorden.
     */
    public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
        List<Integer> oddNumbersGreaterThanN = new ArrayList<>();
        numerosImparesMayoresQueInOrdenRecursive(a, n, oddNumbersGreaterThanN);
        return oddNumbersGreaterThanN;
    }

    private static void numerosImparesMayoresQueInOrdenRecursive(GeneralTree<Integer> a, Integer n, List<Integer> oddNumbersGreaterThanN) {
        if (a.hasChildren()) numerosImparesMayoresQueInOrdenRecursive(a.getChildren().get(0), n, oddNumbersGreaterThanN);
        if (isOdd(a.getData()) && a.getData() > n) oddNumbersGreaterThanN.add(a.getData());
        for (int i = 1; i < a.getChildren().size(); i++) {
            numerosImparesMayoresQueInOrdenRecursive(a.getChildren().get(i), n, oddNumbersGreaterThanN);
        }
    }

    /***
     *
     * @param a the tree
     * @param n value
     * @return Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
     * pasados como parámetros, recorrido en postorden.
     */
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
        //TODO
        return null;
    }

    /***
     *
     * @param a the tree
     * @param n value
     * @return Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
     * pasados como parámetros, recorrido por niveles.
     */
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
        //TODO
        return null;
    }
}
