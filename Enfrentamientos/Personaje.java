package Enfrentamientos;

import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private int id;
    private int poder_inicial = 100;
    private int poder = poder_inicial;
    private ArrayList<Poder> habilidades = new ArrayList<Poder>();
    private int puntos_salud = 1000;
    //private int ataque;
    //private int defensa;

    public Personaje(String name, int id){
        this.nombre = name;
        this.id = id;
    }

    public void salud_disminuye(int poder){
        puntos_salud = puntos_salud - poder;
    }

    public void cambio_fuerza(int fuerza){
        poder = poder + fuerza;
    }

    public void aceptar_habilidades(Poder p1, Poder p2, Poder p3){
        habilidades.add(p1);
        habilidades.add(p2);
        habilidades.add(p3);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Poder> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Poder> habilidades) {
        this.habilidades = habilidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoder_inicial() {
        return poder_inicial;
    }

    public void setPoder_inicial(int poder_inicial) {
        this.poder_inicial = poder_inicial;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getPuntos_salud() {
        return puntos_salud;
    }

    public void setPuntos_salud(int puntos_salud) {
        this.puntos_salud = puntos_salud;
    }

    
    /**public void cambio_defensa(int defensa){

    } */
    
      
}
