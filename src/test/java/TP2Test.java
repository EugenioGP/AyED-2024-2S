import org.junit.Test;
import tp2.BinaryTree;
import tp2.Ejercicio8;
import tp2.Ejercicio9;
import tp2.SumDiff;

public class TP2Test {
    @Test
    public void ejercicio9Test() {
        BinaryTree<Integer> v1 = new BinaryTree<>(20);
        BinaryTree<Integer> v2 = new BinaryTree<>(5);
        BinaryTree<Integer> v3 = new BinaryTree<>(30);
        BinaryTree<Integer> v4 = new BinaryTree<>(-5);
        BinaryTree<Integer> v5 = new BinaryTree<>(10);
        BinaryTree<Integer> v6 = new BinaryTree<>(50);
        BinaryTree<Integer> v7 = new BinaryTree<>(-9);
        BinaryTree<Integer> v8 = new BinaryTree<>(1);
        BinaryTree<Integer> v9 = new BinaryTree<>(4);
        BinaryTree<Integer> v10 = new BinaryTree<>(6);
        v9.addRightChild(v10);
        v6.addRightChild(v9);
        v5.addLeftChild(v8);
        v3.addRightChild(v7);
        v3.addLeftChild(v6);
        v2.addRightChild(v5);
        v2.addLeftChild(v4);
        v1.addRightChild(v3);
        v1.addLeftChild(v2);
        BinaryTree<SumDiff> sumDiffBinaryTree = Ejercicio9.sumAndDif(v1);
        printRecurisve(sumDiffBinaryTree);

    }

    private void printRecurisve(BinaryTree<SumDiff> sumDiffBinaryTree) {
        System.out.println(sumDiffBinaryTree.getData().toString());
        if (sumDiffBinaryTree.getRightChild() != null ) printRecurisve(sumDiffBinaryTree.getRightChild());
        if (sumDiffBinaryTree.getLeftChild() != null ) printRecurisve(sumDiffBinaryTree.getLeftChild());
    }

    @Test
    public void ejercicio8Test() {
        BinaryTree<Integer> v1 = new BinaryTree<>(65);
        BinaryTree<Integer> v2 = new BinaryTree<>(37);
        BinaryTree<Integer> v3 = new BinaryTree<>(81);
        BinaryTree<Integer> v4 = new BinaryTree<>(47);
        BinaryTree<Integer> v5 = new BinaryTree<>(93);

        v3.addRightChild(v5);
        v2.addRightChild(v4);
        v1.addRightChild(v3);
        v1.addLeftChild(v2);

        BinaryTree<Integer> c1 = new BinaryTree<>(65);
        BinaryTree<Integer> c2 = new BinaryTree<>(37);
        BinaryTree<Integer> c3 = new BinaryTree<>(81);
        BinaryTree<Integer> c4 = new BinaryTree<>(47);
        BinaryTree<Integer> c5 = new BinaryTree<>(93);

        BinaryTree<Integer> c6 = new BinaryTree<>(22);
        BinaryTree<Integer> c7 = new BinaryTree<>(76);
        BinaryTree<Integer> c8 = new BinaryTree<>(11);
        BinaryTree<Integer> c9 = new BinaryTree<>(29);
        BinaryTree<Integer> c10 = new BinaryTree<>(85);
        BinaryTree<Integer> c11 = new BinaryTree<>(94);

        c3.addRightChild(c5);
        c2.addRightChild(c4);
        c1.addRightChild(c3);
        c1.addLeftChild(c2);
        c3.addLeftChild(c7);
        c2.addLeftChild(c6);
        c6.addLeftChild(c8);
        c6.addRightChild(c9);
        c5.addLeftChild(c10);
        c5.addRightChild(c11);
        assert Ejercicio8.esPrefijo(v1, c1);

    }
}
