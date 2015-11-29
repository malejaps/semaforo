/* PROYECTO PRACTICO SISTEMAS OPERATIVOS.
 * CLASE		        Auditor.java
 * FECHA DE CREACION		Septiembre 5 de 2011
 * AUTORES                      Victor Camilo Jimenez 0955739
 *                              Maria Alejandra Pabón 0955876
 * DESCRIPCION			Clase la cual es un hilo y verifica las inconsistencias financieras
 *                              en las cuentas bancarias tanto de Editor como de Autor.
 *                              También contiene la operacion que suma el número de libros vendidos.
 *                              Además indica cuantos libros se vendieron y el número de inconsistencias
 *                              existentes.
 */
package proyectooperativos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Auditor extends Thread {

    private int numeroDeLibrosVendidos = 0;
    private int precio = 10000;
    private int inconsistencias = 0;
    private boolean continuar = true;
    private Banco banco;

    Auditor(Banco banco) {
        this.banco = banco;
    }

    void auditar() throws InterruptedException {

        while (continuar) {
            int dineroAutor = banco.cuantoDineroAutor();
            int dineroEditor = banco.cuantoDineroEditor();

            if (((dineroAutor != (precio * numeroDeLibrosVendidos * 10) / 100)) || (dineroEditor != (precio * numeroDeLibrosVendidos * 90) / 100)) {
                inconsistencias++;
                System.out.println("Error en dinero de editor/autor");
            }
        }

    }

    void libroVendido() {
        numeroDeLibrosVendidos++;
    }

    void informeFinal() {
        System.out.print("Se han vendido " + numeroDeLibrosVendidos + " libros en total" + "\nHubo " + inconsistencias + " inconsistencias en total");
        continuar = false;
    }

    @Override
    public void run() {
        try {
            auditar();

        } catch (InterruptedException ex) {
            Logger.getLogger(Auditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
