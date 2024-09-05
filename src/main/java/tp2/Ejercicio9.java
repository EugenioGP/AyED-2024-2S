package tp2;

public class Ejercicio9 {

    public static BinaryTree<SumDiff> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<SumDiff> newRoot = sumAndDifRecursive(arbol, 0, 0);
        if (arbol == null || arbol.getData() == null) return new BinaryTree<SumDiff>();
        return newRoot;
    }

    private static BinaryTree<SumDiff> sumAndDifRecursive(BinaryTree<Integer> node, int fatherValue, int fatherSum) {
        int data = node.getData();
        int sum = fatherSum + data;
        int diff = data - fatherValue;
        SumDiff sumDiff = new SumDiff();
        sumDiff.sum = sum;
        sumDiff.diff = diff;
        BinaryTree<SumDiff> newNode = new BinaryTree<>(sumDiff);
        if (node.getLeftChild() != null) newNode.addLeftChild(sumAndDifRecursive(node.getLeftChild(), data, sum));
        if (node.getRightChild() != null) newNode.addRightChild(sumAndDifRecursive(node.getRightChild(), data, sum));
        return newNode;
    }
}
