package CollectionV1.example.Collection;
package collectionv1.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsSpeedTest {
    private static final int N = 100_000;

    public static void main(String[] args) {
        testArrayListAddEnd();
        testLinkedListAddEnd();

        testArrayListAddBeginning();
        testLinkedListAddBeginning();

        testArrayListRandomAccess();
        testLinkedListRandomAccess();

        testArrayListRemoveMiddle();
        testLinkedListRemoveMiddle();
    }

    // ================= ADD TO END =================
    private static void testArrayListAddEnd() {
        List<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.printf("ArrayList add to end: %d ms%n", (end - start) / 1_000_000);
    }

    private static void testLinkedListAddEnd() {
        List<Integer> list = new LinkedList<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.printf("LinkedList add to end: %d ms%n", (end - start) / 1_000_000);
    }

    // ================= ADD TO BEGINNING =================
    private static void testArrayListAddBeginning() {
        List<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(0, i);
        }
        long end = System.nanoTime();
        System.out.printf("ArrayList add to beginning: %d ms%n", (end - start) / 1_000_000);
    }

    private static void testLinkedListAddBeginning() {
        List<Integer> list = new LinkedList<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(0, i);
        }
        long end = System.nanoTime();
        System.out.printf("LinkedList add to beginning: %d ms%n", (end - start) / 1_000_000);
    }

    // ================= RANDOM ACCESS =================
    private static void testArrayListRandomAccess() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);

        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            int x = list.get(i);
        }
        long end = System.nanoTime();
        System.out.printf("ArrayList random access: %d ms%n", (end - start) / 1_000_000);
    }

    private static void testLinkedListRandomAccess() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) list.add(i);

        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            int x = list.get(i);
        }
        long end = System.nanoTime();
        System.out.printf("LinkedList random access: %d ms%n", (end - start) / 1_000_000);
    }

    // ================= REMOVE FROM MIDDLE =================
    private static void testArrayListRemoveMiddle() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);

        long start = System.nanoTime();
        for (int i = 0; i < N / 2; i++) {
            list.remove(list.size() / 2); // always remove middle
        }
        long end = System.nanoTime();
        System.out.printf("ArrayList remove from middle: %d ms%n", (end - start) / 1_000_000);
    }

    private static void testLinkedListRemoveMiddle() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) list.add(i);

        long start = System.nanoTime();
        for (int i = 0; i < N / 2; i++) {
            list.remove(list.size() / 2); // always remove middle
        }
        long end = System.nanoTime();
        System.out.printf("LinkedList remove from middle: %d ms%n", (end - start) / 1_000_000);
    }
}

