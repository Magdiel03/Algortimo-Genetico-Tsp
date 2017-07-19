package clases;

import java.io.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class archivos {

    //PMX
    public static int[] pmx(int[] x, int[] y, int index1, int index2) {

        boolean visited[] = new boolean[x.length + 1]; //all false, are the node visited?

        int[] z = new int[x.length];//same dimensions as x
        for (int i = index1; i <= index2; i++) {
            z[i] = x[i];
            visited[z[i]] = true;
        }
        int k = index1;
        //Traverse parent2
        for (int i = index1; i <= index2; i++) { //para cada elemento del segmente

            if (!visited[y[i]]) {
                k = i;
                int elementToBeCopied = y[i]; //copiando el elemento desde la madre
                do {
                    int V = x[k];
                    //search in the mother ofr the index where the V is.
                    for (int j = 0; j < y.length; j++) {
                        if (y[j] == V) {
                            k = j;
                        }
                    }
                } while (z[k] != 0);
                z[k] = elementToBeCopied;
                visited[z[k]] = true;
            }
        }

        //copy the reminder elements from y
        for (int i = 0; i < z.length; i++) {
            if (z[i] == 0) {
                z[i] = y[i];
            }
        }
        return z;
    }

    public String leerTxt(String direccion) { //direccion del archivo

        String texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                //haz el ciclo, mientras bfRead tiene datos
                temp = temp + bfRead; //guardado el texto del archivo
            }
            texto = temp;
        } catch (Exception e) {
            System.err.println("No se encontro archivo");
        }
        return texto;
    }

    public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static int[] Opt2(int[] array, int limiteinferior, int limitesuperior, int probaexito) {
        int[] Variableauxiliar = new int[array.length];
        int rnd = generarRandom(1, 100);
        for (int i = 0; i < array.length; i++) {
            Variableauxiliar[i] = array[i];
        }
        if (rnd <= probaexito)
        {
            int h = 0;
            for (int i = limiteinferior; i <= limitesuperior; i = i + 1) {
                Variableauxiliar[i] = array[limitesuperior - h];
                h = h + 1;
            }
            return Variableauxiliar;

        }
        else 
        {
                return Variableauxiliar;
                }
    }

    //Generar número aleatorio dentro del rango. Incluye los bordes.
    public static int generarRandom(int min, int max) {
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);
        return random;
    }

    public static int[] randomArray(int tamano, int limite) {
        int[] arreglo = new int[tamano];
        int count = 0;
        int num;
        Random r = new Random();
        while (count < arreglo.length) {
            num = r.nextInt(limite + 2);
            boolean repeat = false;
            do {
                for (int i = 0; i < arreglo.length; i++) {
                    if (num == arreglo[i]) {
                        repeat = true;
                        break;
                    } else if (i == count) {
                        arreglo[count] = num;
                        count++;
                        repeat = true;
                        break;
                    }
                }
            } while (!repeat);
        }
        for (int j = 0; j < arreglo.length; j++) {
            arreglo[j] = arreglo[j] - 1;
            //System.out.print(arreglo[j]+" ");
        }
        //System.out.println("");
        return arreglo;
    }

    public static int obtenerIndex(int valor, int[] arreglo) {
        int index = 222;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                index = i;
            }
        }
        return index;
    }

    public static int[] extraerArray(int fila, int[][] matriz) {
        int largo = matriz[0].length;
        int alto = matriz.length;
        //System.out.println("largo: "+largo);
        int[] array = new int[largo];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < largo; j++) {
                if (i == fila) {
                    array[j] = matriz[fila][j];
                }
            }
        }
        return array;
    }

    public static void printmatriz(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
