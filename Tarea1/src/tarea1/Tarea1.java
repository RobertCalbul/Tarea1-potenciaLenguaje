/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author TheKiller
 */
public class Tarea1 {

    private byte nMin = 0;
    private byte nMax = 3;

    public Tarea1(byte nMax) {
        this.nMax = nMax;
    }

    public void GeneraString2() {
        // Declaración el ArrayList

        ArrayList<String> LENGUAJE = new ArrayList<String>();
        ArrayList<String> Secundario = new ArrayList<String>();
        ArrayList<String> Auxiliar = new ArrayList<String>();
        LENGUAJE.add("11");
        LENGUAJE.add("00");
        LENGUAJE.add("ab");
        LENGUAJE.add("aabbccc");
        Auxiliar = LENGUAJE;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("prueba.txt");
            pw = new PrintWriter(fichero);
            for (byte i = nMin; i <= nMax; i++) {
                StringBuilder salida = new StringBuilder();
                if (i < 1) {
                    pw.print("L" + i + "={VACIO}\n");
                } else {
                    for (String aux : Auxiliar) {
                        salida.append(aux + ",");
                        for (String len : LENGUAJE) {
                            Secundario.add(aux + len);
                        }
                    }
                    pw.print("L" + i + "={"+salida.substring(0, salida.length()-1)+"}\n");
                    Auxiliar = Copy(Secundario);
                    Secundario.clear();
                }
                System.out.print("\n >>> " + i + "\n");
            }
        } catch (Exception e) {
            System.err.println("ERROR Tarea1.escribir() " + e.getMessage());
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.err.println("ERROR Tarea1.escribir() finaly " + e2.getMessage());
            }
        }
    }

    public ArrayList<String> Copy(ArrayList<String> entrada) {
        ArrayList<String> salida = new ArrayList<String>();
        for (String in : entrada) {
            salida.add(in);
        }
        entrada.clear();
        return salida;
    }

    public String leerArchivo() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String salida = "";
        try {
            archivo = new File("prueba.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                salida += linea;
            }
            return salida;
        } catch (IOException e) {
            System.err.println("ERROR escribir " + e.getMessage());
            return salida;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.err.println("ERROR escribir.fr.close() " + e2.getMessage());
            }
        }
    }
}
