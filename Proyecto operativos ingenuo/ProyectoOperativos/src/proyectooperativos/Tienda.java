/* PROYECTO PRACTICO SISTEMAS OPERATIVOS.
 * CLASE		        Tienda.java
 * FECHA DE CREACION		Septiembre 5 de 2011
 * AUTORES                      Victor Camilo Jimenez 0955739
 *                              Maria Alejandra Pabón 0955876
 * DESCRIPCION			Clase la cual es un hilo que guarda el correspondiente
 *                              dinero de las ventas de libros en el Banco en las cuentas del Editor y Autor.
 *                              Tambien le informa a la clase Auditor que se vendió un libro.
 *
 */
package proyectooperativos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tienda extends Thread {

    private int precio = 10000;
    private Banco banco;
    private Auditor auditor;

    Tienda(Banco banco, Auditor auditor) {
        this.banco = banco;
        this.auditor = auditor;
    }

    void libroVendidoTienda() throws InterruptedException {

        int librosTotalVendidosPorEstaTienda = 100;
        int librosVendidosPorEstaTiendaHastaAhora = 0;

        for (librosVendidosPorEstaTiendaHastaAhora = 0; librosVendidosPorEstaTiendaHastaAhora < librosTotalVendidosPorEstaTienda; librosVendidosPorEstaTiendaHastaAhora++) {
            auditor.libroVendido();
            banco.guardarDineroAutor(precio * 10 / 100);
            banco.guardarDineroEditor(precio * 90 / 100);
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
