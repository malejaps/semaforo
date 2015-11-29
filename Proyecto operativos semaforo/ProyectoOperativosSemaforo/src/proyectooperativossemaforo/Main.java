/* PROYECTO PRACTICO SISTEMAS OPERATIVOS.
 * NOMBRE DEL PROGRAMA		Main.java
 * FECHA DE CREACION		Septiembre 5 de 2011
 * AUTORES                      Victor Camilo Jimenez 0955739
 *                              Maria Alejandra Pabón 0955876
 * DESCRIPCION			Clase principal que permite visualizar la aplicación que muestra
 *                              un problema entre la ejecucion de los hilos tipo Tienda y Auditor,
 *                              y la solucion utilizando un semaforo.
 *
 */
package proyectooperativossemaforo;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaforo = new Semaphore(1);
        Banco banco = new Banco();
        Auditor auditor = new Auditor(banco, semaforo);
        Tienda tienda1 = new Tienda(banco, auditor, semaforo);
        Tienda tienda2 = new Tienda(banco, auditor, semaforo);
        Tienda tienda3 = new Tienda(banco, auditor, semaforo);
        Tienda tienda4 = new Tienda(banco, auditor, semaforo);
        Tienda tienda5 = new Tienda(banco, auditor, semaforo);
        Tienda tienda6 = new Tienda(banco, auditor, semaforo);
        Tienda tienda7 = new Tienda(banco, auditor, semaforo);
        Tienda tienda8 = new Tienda(banco, auditor, semaforo);
        Tienda tienda9 = new Tienda(banco, auditor, semaforo);
        Tienda tienda10 = new Tienda(banco, auditor, semaforo);

        // Ejecucion de hilos concurrentemente:

        auditor.start();
        tienda1.start();
        tienda2.start();
        tienda3.start();
        tienda4.start();
        tienda5.start();
        tienda6.start();
        tienda7.start();
        tienda8.start();
        tienda9.start();
        tienda10.start();


        // Esperar que los hilos terminen:
        tienda1.join();
        tienda2.join();
        tienda3.join();
        tienda4.join();
        tienda5.join();
        tienda6.join();
        tienda7.join();
        tienda8.join();
        tienda9.join();
        tienda10.join();
        auditor.informeFinal();

    }
}
