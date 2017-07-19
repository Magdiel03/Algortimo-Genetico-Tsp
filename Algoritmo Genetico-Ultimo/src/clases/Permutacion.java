/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Magdiel
 */
//codigo para generar permutacion
public class Permutacion {
    
        public static void generar_vecino(int[] arreglo) {
        Random r = new Random();
        for (int i = arreglo.length - 1; i > 0; i--) {
            // Un entero, elegido por una función Random en el rango 0-k (nótese que k se va reduciendo).    
            int entero_random = r.nextInt(i);
            // Un entero, que ha de contener un valor para intercambiar valores entre 2 posiciones.   
            int intercambio = arreglo[entero_random];
            arreglo[entero_random] = arreglo[i];
            arreglo[i] = intercambio;
        }
    }

} 

