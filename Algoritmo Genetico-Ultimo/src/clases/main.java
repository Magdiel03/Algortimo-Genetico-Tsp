package clases;

import static clases.Permutacion.generar_vecino;
import static clases.archivos.Opt2;
import static clases.archivos.extraerArray;
import static clases.archivos.generarRandom;
import static clases.archivos.imprimirArreglo;
import static clases.archivos.obtenerIndex;
import static clases.archivos.pmx;
import static clases.archivos.randomArray;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import static clases.archivos.printmatriz;

public class main {

    public static void main(String[] args) {
        //leer un TXT
        TSP tsp;
        tsp = new TSP();
        //LLama a la funcion creada en otra clase para poder leer archivos 
        archivos a = new archivos();
        // se copia la ruta del archivo donde esta guerdado en este caso el tsp fue modificado y llamado prueba y se encuentra en el escritorio 
        String s1 = a.leerTxt("C:\\Users\\Magdiel\\Desktop\\prueba.txt");

        StringTokenizer string = new StringTokenizer(s1, "#");
        int totalDatos = string.countTokens();
        String[] datos = new String[totalDatos];
        //int i=0;
        while (string.hasMoreTokens()) {
            String str = string.nextToken();
            // encuentra el nombre y lo agrega a una nueva variable    
            if (str.equals("NAME: ")) {
                String str2 = string.nextToken();
                System.out.println("Nombre de archivo: " + str2);
                tsp.setName(str2);
            }
            // guardamos el tipo  
            if (str.equals("TYPE: ")) {
                String str3 = string.nextToken();
                System.out.println("Tipo del archivo: " + str3);
                tsp.setType(str3);
            }

            if (str.equals("COMMENT: ")) {
                String str4 = string.nextToken();
                System.out.println("Comentario: " + str4);
                tsp.setComment(str4);
            }

            if (str.equals("DIMENSION: ")) {
                String str5 = string.nextToken();
                System.out.println("Dimension: " + str5);
                tsp.setDimension(str5);
            }

            if (str.equals("EDGE_WEIGHT_TYPE: ")) {
                String str6 = string.nextToken();
                System.out.println("EDGE_WEIGHT_TYPE: " + str6);
                tsp.setEdgeWeightType(str6);
            }

            if (str.equals("EDGE_WEIGHT_FORMAT: ")) {
                String str7 = string.nextToken();
                System.out.println("EDGE_WEIGHT_FORMAT:" + str7);
                tsp.setEdgeWeightFormat(str7);
            }

            if (str.equals("DISPLAY_DATA_TYPE: ")) {
                String str8 = string.nextToken();
                System.out.println("DISPLAY_DATA_TYPE : " + str8);
                tsp.setDisplayDataType(str8);
            }
            //Para la Matriz
            if (str.equals("EDGE_WEIGHT_SECTION")) {
                String str9 = string.nextToken();
                int[][] distancia = new int[29][29];
                StringTokenizer nuevo = new StringTokenizer(str9);
                for (int x = 0; x < distancia.length; x++) {
                    for (int y = 0; y < distancia[x].length; y++) {
                        //System.out.print(nuevo.nextToken()+ " ");
                        distancia[x][y] = (int) Double.parseDouble(nuevo.nextToken());
                    }
                    //System.out.println(); 
                }

                tsp.setDistancia(distancia);

                int m[][] = tsp.getDistancia();
                //System.out.println(m[0][1]); esta fue una prueba
                // Generar caminos aleatorios 
                int valor = 0;
                int[] ciudadesoriginal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
                // MUESTRA LA MATRIZ CON LAS REINAS ORIGINALES PARA LAS CUALES SE BUSCARAN EL VECINO     
                int[] nuevaruta = ciudadesoriginal;
                System.out.println("ruta original: " + Arrays.toString(nuevaruta));
                //SE PIDE POR PANTALLAS LOS VECINOS QUE QUIERE GENERAR 
                int n;
                System.out.println("Por favor introduzca la cantidad de permutaciones a generar");
                Scanner lector = new Scanner(System.in);
                n = lector.nextInt();
                int[][] matrizpoblacional = new int[n][29];
                
                int[] costosmio = new int[n];
                //Crear matriz con cantidad de permutaciones pedidas y respectivo arreglo con sus costos.
                for (int i = 0; i < n; i++) {
                    //permutación 
                    generar_vecino(nuevaruta);
                    //Pasar secuencia a matriz
                    for (int j = 0; j < 29; j++) {
                        matrizpoblacional[i][j] = nuevaruta[j];
                    }
                    int suma = 0;
                    int cont = 0;
                    while (cont < nuevaruta.length - 1) {
                        int calculo1 = nuevaruta[cont + 1] - 1;
                        int calculo2 = nuevaruta[cont] - 1;
                        int calculocosto = m[calculo1][calculo2];
                        suma = suma + calculocosto;
                        cont++;
                    }
                    costosmio[i] = suma;
                }
                System.out.println("Matriz Poblacion Inicial : ");
                printmatriz(matrizpoblacional);
                System.out.println("Costos de la matriz: ");
                imprimirArreglo(costosmio);

// Pedir el Tamaño del Torneo
                int TamañoTorneo;
                System.out.println("Por favor introduzca el tamaño del torneo");
                Scanner torneo = new Scanner(System.in);
                TamañoTorneo = torneo.nextInt();
                int[][] MatrizTorneo = new int[TamañoTorneo][matrizpoblacional[0].length];
                int[] CostosTorneo = new int[TamañoTorneo];
                int[] VariableAuxiliar = new int[matrizpoblacional[0].length];
//Obtener orden con el resultado de la lotería
                int[][] matrizganadores = new int[n][29];
                int[] costosmatrizganadores = new int[n];
                
                int Probaexito;
                System.out.println("Porfavor Ingrese la Probabilidad de Exito en Mutacion ( de 1 a 100) ");
                Scanner proba = new Scanner(System.in);
                Probaexito = proba.nextInt();

                int[] costos = new int[100000];
                costos[0]=6000;
    

for (int magdiel = 1; magdiel < 100000; magdiel++) {
    
              //  System.out.println("nueva Matriz Poblacional luego de aplicar cruzamiento y crozover a esta matriz se le aplica el nuevo torneo: ");
                //printmatriz(matrizpoblacional);
    
                for (int indice = 0; indice < n; indice++) {
                    int[] Sacar = randomArray(TamañoTorneo, matrizpoblacional.length - 1);
                    for (int i = 0; i < TamañoTorneo; i++) {
                        int fila = Sacar[i];
                        //Extraer la fila que ordene el array aleatorio desde la matriz
                        VariableAuxiliar = extraerArray(fila, matrizpoblacional);
                        //Pasar la fila extraida a la matriz auxiliar 1
                        for (int j = 0; j < matrizpoblacional[0].length; j++) {
                            MatrizTorneo[i][j] = VariableAuxiliar[j];
                            int suma = 0;
                            int cont = 0;
                            while (cont < VariableAuxiliar.length - 1) {
                                int calculo1 = VariableAuxiliar[cont + 1] - 1;
                                int calculo2 = VariableAuxiliar[cont] - 1;
                                int calculocosto = m[calculo1][calculo2];
                                suma = suma + calculocosto;
                                cont++;
                            }
                            //Aprovechar de pasar el costo de cada fila a un array
                            CostosTorneo[i] = suma;
                        }
                    }
                    //System.out.println("Matriz de Torneo: ");
                    //imprimirMatriz(MatrizTorneo);
                    //System.out.println("Costos del Torneo: ");
                    //imprimirArreglo(CostosTorneo);
// Matriz Ganadores 
// Ahora vemos a los ganadores 
                    int Costominimo = Arrays.stream(CostosTorneo).min().getAsInt();
                    int index = obtenerIndex(Costominimo, CostosTorneo);
                    int[] ganador = MatrizTorneo[index];
                    // System.out.println("Ganador del Torneo: ");
                    //imprimirArreglo(ganador);
                    for (int indice2 = 0; indice2 < 29; indice2++) {
                        matrizganadores[indice][indice2] = ganador[indice2];
                    }
                    int suma = 0;
                    int cont = 0;
                    while (cont < ganador.length - 1) {
                        int calculo1 = ganador[cont + 1] - 1;
                        int calculo2 = ganador[cont] - 1;
                        int calculocosto = m[calculo1][calculo2];
                        suma = suma + calculocosto;
                        cont++;
                    }
                    costosmatrizganadores[indice] = suma;
                }

//Imprimir Matriz Ganadores 
                //System.out.println("Ganadores Torneo ");
               // printmatriz(matrizganadores);
                //System.out.println("Costos Ganadores Torneo ");
                //imprimirArreglo(costosmatrizganadores);
                

                int Costominimoganador = Arrays.stream(costosmatrizganadores).min().getAsInt();
                int indexX = obtenerIndex(Costominimoganador, costosmatrizganadores);
                int[] Winer = matrizganadores[indexX];

               // int Costosarreglo= Arrays.stream(costos).min().getAsInt();
                //costos[magdiel-1]
                if (Costominimoganador < costos[magdiel-1]) {
                System.out.println("Permutacion Ganadora ");
                 imprimirArreglo(Winer);   
                    System.out.println("Costo Ganador");
                    System.out.println(Costominimoganador);    
                }
                
                 costos[magdiel]=Costominimoganador;
// Matriz Hijos Generadas con PMX
                int primerindice = generarRandom(0, 26);
                int segundoindice = generarRandom(primerindice, 28);
                int[] Hijo = new int[matrizganadores[0].length];
                int[][] matrizhijo = new int[n][29];
                int h = 0;
                for (int i = 0; i < n / 2; i++) {

                    Hijo = pmx(matrizganadores[h], matrizganadores[h + 1],primerindice,segundoindice);
                    for (int j = 0; j < 29; j++) {
                        matrizhijo[i][j] = Hijo[j];
                    }
                    h = h + 2;
                }
                h = 0;
                for (int i = n / 2; i < n; i++) {
                    Hijo = pmx(matrizganadores[h + 1], matrizganadores[h],0,3);
                    for (int j = 0; j < 29; j++) {
                        matrizhijo[i][j] = Hijo[j];
                    }
                    h = h + 2;
                }
// MATRIZ CON EL CROSSOVER                
              //  System.out.println("Matriz hijos generados con Crossover ");
                //printmatriz(matrizhijo);
// Luego comenzamos el ultimo paso que es la Mutacion por medio del algoritmo 2-Opt

                int inicio = generarRandom(0, 27);
                int fin = generarRandom(inicio, 28);
                
                int[] Optaux = new int[matrizhijo[0].length];
                int[][] matrizopt2 = new int[n][29];
                for (int i = 0; i < n; i++) {
                    Optaux = Opt2(matrizhijo[i],inicio, fin, Probaexito);
                    for (int j = 0; j < 29; j++) {
                        matrizopt2[i][j] = Optaux[j];
                    }
                }

               // System.out.println("Matriz con mutacion ");
                //printmatriz(matrizopt2);

                //  int[] opt = new int[matrizhijo[0].length];
                //opt=Opt2(matrizhijo[0],2,10,99);             
                //System.out.println("2opt hijos ");
                //imprimirArreglo(opt);
// Hacer un nuevo torneo con la matriz de OPT
                matrizpoblacional = matrizopt2;
                

                
}
                System.out.println("Matriz de Costos ");
imprimirArreglo(costos);  
int Costosarreglo= Arrays.stream(costos).min().getAsInt();
System.out.println("Costo Minimo es ----->> "+ Costosarreglo);

 

            }

        }
    }
}
