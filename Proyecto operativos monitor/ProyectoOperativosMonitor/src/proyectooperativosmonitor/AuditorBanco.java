/* PROYECTO PRACTICO SISTEMAS OPERATIVOS.
 * NOMBRE DEL PROGRAMA		AuditorBanco.java
 * FECHA DE CREACION		Septiembre 5 de 2011
 * AUTORES                      Victor Camilo Jimenez 0955739
 *                              Maria Alejandra Pabón 0955876
 * DESCRIPCION			Clase que une las operaciones de Banco y Auditor. 
 *                              Contiene el monitor funcionParaTodos para solucionar
 *                              el problema de las secciones criticas y el recurso compartido.
 *
 */
package proyectooperativosmonitor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AuditorBanco extends Thread {

    private int precio = 10000;
    private int dineroAutor = 0;
    private int dineroEditor = 0;
    private int numeroDeLibrosVendidos = 0;
    private int inconsistencias = 0;
    private boolean continuar = true;

    void auditar() throws InterruptedException {

        while (continuar) {

            int variables[] = funcionParaTodo(0, 0, 1);

            if ((variables[0] != (precio * variables[2] * 10) / 100) || (variables[1] != (precio * variables[2] * 90) / 100)) {

                inconsistencias++;
                System.out.println("Error en dinero de editor/autor");
            }
        }
    }

    void guardarDineroAutorEditorYLibros(int dineroA, int dineroE) {

        dineroAutor += dineroA;
        dineroEditor += dineroE;
        numeroDeLibrosVendidos++;

    }

    int[] cuantoDineroAutorEditorNumeroLibros() {

        int tresEnteros[] = {dineroAutor, dineroEditor, numeroDeLibrosVendidos};
        return tresEnteros;

    }

    void informeFinal() {

        System.out.println("Se han vendido " + numeroDeLibrosVendidos + " libros en total" + "\nHubo " + inconsistencias + " inconsistencias en total");
        continuar = false;
    }

    synchronized int[] funcionParaTodo(int dineroAutor, int dineroEditor, int cualFuncion) {

        int auxiliar[] = new int[0];

        switch (cualFuncion) {

            case 0:
                guardarDineroAutorEditorYLibros(dineroAutor, dineroEditor);
                return auxiliar;

            case 1:
                return cuantoDineroAutorEditorNumeroLibros();
        }
        return auxiliar;
    }

    @Override
    public void run() {
        try {
            auditar();
        } catch (InterruptedException ex) {
            Logger.getLogger(AuditorBanco.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
}
