package tp2;

public class Ejercicio8 {
    public static boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        if (arbol1.hasLeftChild() && !esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild())) {
            return false;
        }
        if (arbol1.hasRightChild() && !esPrefijo(arbol1.getRightChild(), arbol2.getRightChild())) {
            return false;
        }
        return arbol1.getData().equals(arbol2.getData());
    }
}
