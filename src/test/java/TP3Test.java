import org.junit.Test;
import tp2.BinaryTree;
import tp2.Ejercicio8;
import tp3.Ejercicio2RecorridosAG;
import tp3.GeneralTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TP3Test {

    @Test
    public void ejercicio2numerosImparesMayoresQuePreOrden() {
        Integer n = 7;

        GeneralTree<Integer> v4 = new GeneralTree<>(4);
        GeneralTree<Integer> v7 = new GeneralTree<>(7);
        GeneralTree<Integer> v5 = new GeneralTree<>(5);
        GeneralTree<Integer> v13 = new GeneralTree<>(13, Arrays.asList(v4, v7, v5));

        GeneralTree<Integer> v6 = new GeneralTree<>(6);
        GeneralTree<Integer> e10 = new GeneralTree<>(10);
        GeneralTree<Integer> v18 = new GeneralTree<>(18);
        GeneralTree<Integer> v25 = new GeneralTree<>(25, Arrays.asList(v6, e10, v18));

        GeneralTree<Integer> v9 = new GeneralTree<>(9);
        GeneralTree<Integer> v12 = new GeneralTree<>(12);
        GeneralTree<Integer> v19 = new GeneralTree<>(19);
        GeneralTree<Integer> l10 = new GeneralTree<>(10, Arrays.asList(v9, v12, v19));

        GeneralTree<Integer> v17 = new GeneralTree<>(17, Arrays.asList(v13, v25, l10));
        List<Integer> result = Ejercicio2RecorridosAG.numerosImparesMayoresQuePreOrden(v17, n);
        assert result.get(0) == 17;
        assert result.get(1) == 13;

    }

    @Test
    public void ejercicio2numerosImparesMayoresQueInOrden() {
        Integer n = 7;

        GeneralTree<Integer> v4 = new GeneralTree<>(4);
        GeneralTree<Integer> v7 = new GeneralTree<>(7);
        GeneralTree<Integer> v5 = new GeneralTree<>(5);
        GeneralTree<Integer> v13 = new GeneralTree<>(13, Arrays.asList(v4, v7, v5));

        GeneralTree<Integer> v6 = new GeneralTree<>(6);
        GeneralTree<Integer> e10 = new GeneralTree<>(10);
        GeneralTree<Integer> v18 = new GeneralTree<>(18);
        GeneralTree<Integer> v25 = new GeneralTree<>(25, Arrays.asList(v6, e10, v18));

        GeneralTree<Integer> v9 = new GeneralTree<>(9);
        GeneralTree<Integer> v12 = new GeneralTree<>(12);
        GeneralTree<Integer> v19 = new GeneralTree<>(19);
        GeneralTree<Integer> l10 = new GeneralTree<>(10, Arrays.asList(v9, v12, v19));

        GeneralTree<Integer> v17 = new GeneralTree<>(17, Arrays.asList(v13, v25, l10));
        List<Integer> result = Ejercicio2RecorridosAG.numerosImparesMayoresQueInOrden(v17, n);
        int k = 1;
        assert k / 2 > 0;
        assert result.get(0) == 13;
        assert result.get(1) == 17;
    }
}
