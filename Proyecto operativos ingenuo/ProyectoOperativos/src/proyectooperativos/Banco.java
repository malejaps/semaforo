/* PROYECTO PRACTICO SISTEMAS OPERATIVOS.
 * CLASE		        Banco.java
 * FECHA DE CREACION		Septiembre 5 de 2011
 * AUTORES                      Victor Camilo Jimenez 0955739
 *                              Maria Alejandra Pabón 0955876
 * DESCRIPCION			Clase la cual es un recurso compartido que contiene las operaciones correspondientes
 *                              para guardar el dinero en cuentas del Editor y Autor. Tambien informa cuanto dinero
 *                              tiene el Autor y el Editor en sus respectivas cuentas.
 *
 *
 */
package proyectooperativos;

public class Banco {

    private int dineroAutor = 0;
    private int dineroEditor = 0;

    int cuantoDineroAutor() {
        return dineroAutor;
    }

    int cuantoDineroEditor() {
        return dineroEditor;
    }

    void guardarDineroAutor(int p) {
        dineroAutor += p;
    }

    void guardarDineroEditor(int p) {
        dineroEditor += p;
    }
}
