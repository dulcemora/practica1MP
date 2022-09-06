package Enfrentamientos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Observador {
    private int id;
    private String nombre;
    private Personaje personaje_a_seguir;

    

    public Observador(int id, String nombre, Personaje personaje_a_seguir){
        this.id = id;
        this.nombre = nombre;
        this.personaje_a_seguir = personaje_a_seguir;

        crear("Bitacora para " + this.nombre + ". Que sigue a: " + personaje_a_seguir.getNombre());
    }

    public void update_ataque(Personaje atacado){
        String texto = personaje_a_seguir.getNombre() + " ataca a " + atacado.getNombre();
        escribir(texto);
    }

    public void salud(){
        String texto = "La salud de "+ personaje_a_seguir.getNombre() + " es " + personaje_a_seguir.getPuntos_salud();
        escribir(texto);
    }

    public void update_amenaza(Personaje atacante){
        String texto = atacante.getNombre() + " ataca a " + personaje_a_seguir.getNombre() + "\n";
        escribir(texto);
    }


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


    public void crear(String texto){
        try {
            File archivo = new File("observador" + id+ ".txt");
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(texto);
            escribir.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al escribir");
        }
    }

    public Personaje getPersonaje_a_seguir() {
        return personaje_a_seguir;
    }

    public void setPersonaje_a_seguir(Personaje personaje_a_seguir) {
        this.personaje_a_seguir = personaje_a_seguir;
    }


    

}
