package com.quicksort.main;

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partición: Selecciona un pivote y coloca los elementos menores a la izquierda y los mayores a la derecha.
            int pivotIndex = partition(arr, low, high);

            // Llamadas recursivas en las dos sub-listas resultantes.
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Elegimos el último elemento como pivote.
        int i = low - 1; // Índice para los elementos menores.

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                // Intercambiamos arr[i] y arr[j] si arr[j] es menor o igual al pivote.
                i++;
                intercambiar(arr, i, j);
            }
        }

        // Intercambiamos el pivote (arr[high]) con el elemento en arr[i+1].
        intercambiar(arr, i + 1, high);

        // Devolvemos el índice del pivote después de la partición.
        return i + 1;
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array desordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr);

        System.out.println("\nArray ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
