/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;


import java.io.*;

/**
 *
 * @author TheKiller
 */
public class Tarea1 {

    private static int nMin = 1;
    private static int nMax = 5;
    private static String[] a1 = {"1", "0", "a", "b", "c"};
    private static String[] a2 = new String[0];//alfabeto vacio
    private static String[] l = {"11", "00", "ab", "aabbcc"};
    private static String[] lAux = new String[0];

    public static void main(String[] args) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("e:/prueba.txt");
            pw = new PrintWriter(fichero);
            for (int i = nMin; i <= nMax; i++) {
                //System.out.println("Pasada -> " + i);
                //tamaño de arreglo si L^2 = lenguaje*alfabeto si L^n donde n >2 entonces auxuliar * alfabeto
                int size = i == 1 ? l.length : i == 2 ? (a1.length * l.length) : (lAux.length * a1.length);
                String[] arr = lAux;
                lAux = new String[size];
                String[] arreglo2 = i == 1 ? l : arr;
                int contador = 0;
                for (int a = 0; a < arreglo2.length; a++) {
                    if (i == 1) {
                        lAux[a] = l[a];
                        //System.out.println("valor: " + lAux[a]);
                        pw.println(lAux[a]);
                    } else {
                        for (int L = 0; L < a1.length; L++) {
                            lAux[contador] = arreglo2[a].concat(a1[L]);//i<=1?l[a].concat(a1[L]): arr[contador].concat(a1[L]);
                            //System.out.println("valor: " + lAux[contador]);
                            pw.println(lAux[contador]);
                            contador++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
           // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
