/* PROYECTO PRACTICO SISTEMAS OPERATIVOS.
 * CLASE		        Tienda.java
 * FECHA DE CREACION		Septiembre 5 de 2011
 * AUTORES                      Victor Camilo Jimenez 0955739
 *                              Maria Alejandra Pabón 0955876
 * DESCRIPCION			Clase la cual es un hilo que guarda el correspondiente
 *                              dinero de las ventas de libros en el Banco en las cuentas del Editor y Autor.
 *                              Tambien le informa a la clase Auditor que se vendió un libro.
 *                              Trabaja con un semaforo que soluciona el problema del recurso compartido entre los hilos.
 *
 */
package proyectooperativossemaforo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tienda extends Thread {

    private int precio = 10000;
    private Banco banco;
    private Auditor auditor;
    private Semaphore semaforo;

    Tienda(Banco b, Auditor a, Semaphore s) {
        banco = b;
        auditor = a;
        semaforo = s;
    }

    void libroVendidoTienda() throws InterruptedException {
        try {
            int librosTotalVendidosPoEstaTienda = 100;
            int librosVendidosHastaAhora = 0;

            for (librosVendidosHastaAhora = 0; librosVendidosHastaAhora < librosTotalVendidosPoEstaTienda; librosVendidosHastaAhora++) {
                semaforo.acquire();
                auditor.libroVendido();
                banco.guardarDineroAutor(precio * 10 / 100);
                banco.guardarDineroEditor(precio * 90 / 100);
                semaforo.release();
            }
        } catch (Exception e) {

            System.out.println("Ocurrio una excepcion");
        }

    }

    @Override
    public void run() {
        try {
            libroVendidoTienda();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
