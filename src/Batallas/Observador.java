package Batallas;

/**
 * Observador
 * Clase 
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Observador {
    private int id;
    private String nombre;
    private Personaje personaje_a_seguir;

    /**
     * COnstructor para los observadores del enfrentamiento
     * @param id Identificador del observador
     * @param nombre Nombre del observador
     * @param personaje_a_seguir Personaje que elige el observador para apoyarlo
     */
    
    public Observador(int id, String nombre, Personaje personaje_a_seguir){
        this.id = id;
        this.nombre = nombre;
        this.personaje_a_seguir = personaje_a_seguir;

        crear("Bitacora para " + this.nombre + ". Que sigue a: " + personaje_a_seguir.getNombre());
    }

    /** 
     * Imprime la salud del personaje que apoya el observador
    */

    public void salud(){
        String texto = "La salud de "+ personaje_a_seguir.getNombre() + " es " + personaje_a_seguir.getPuntos_salud();
        escribir(texto);
    }

    /**
     * Metodo que escribe en el archivo creado para el observador, asi como manejar excepciones
     * @param texto Cuerpo del archivo .txt
     */

    public void escribir(String texto){
        try {
            String ruta = "observador" + id+ ".txt";
            FileWriter fw = new FileWriter(ruta, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(texto);
            out.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al escribir");
        }
    }

    /**
     * Metodo que crea el archivo .txt para el observador correspondiente, así como soluciona excepciones
     * @param texto Cuerpo del archivo .txt
     */

    public void crear(String texto){
        try {
            File archivo = new File("observador_" + nombre + ".txt");
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(texto);
            escribir.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al escribir");
        }
    }

    /**
     * Metodo que devuelve el personaje al que apoya el observador
     * @return
     */

    public Personaje getPersonaje_a_seguir() {
        return personaje_a_seguir;
    }

    /**
     * Actualiza el personaje que sigue el observador
     * @param personaje_a_seguir Es el personaje al que el observador quiere apoyar
     */

    public void setPersonaje_a_seguir(Personaje personaje_a_seguir) {
        this.personaje_a_seguir = personaje_a_seguir;
    }


    

}
