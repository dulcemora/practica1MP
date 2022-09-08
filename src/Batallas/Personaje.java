package Batallas;

/**
 * Personaje
 * Clase para el manejo de los personajes, asi como los metodos setters y getters de los atributos de los personajes
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 */ 

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personaje {
    private String nombre;
    private int id;
    private int poder_inicial = 100;
    private int poder = poder_inicial;
    private ArrayList<Poder> habilidades = new ArrayList<Poder>();
    private int puntos_salud = 1000;
    public ArrayList<Observador> seguidores = new ArrayList<>();;
    //private int ataque;
    //private int defensa;

    /**
     * Constructor del personaje
     * @param name Nombre del personaje
     * @param id Identificador del personaje
     */

    public Personaje(String name, int id){
        this.nombre = name;
        this.id = id;
    }

    /**
     * Metodo que resta la salud de un personaje al recibir daño de un ataque
     * @param poder Daño que causo el ataque
     */

    public void salud_disminuye(int poder){
        puntos_salud = puntos_salud - poder;
    }

    /**
     * Agrega las habilidades correspondientes a cada personaje
     * @param p1 Poder numero 1 del personaje
     * @param p2 Poder numero 2 del personaje
     * @param p3 Poder numero 3 del personaje
     */

    public void aceptar_habilidades(Poder p1, Poder p2, Poder p3){
        habilidades.add(p1);
        habilidades.add(p2);
        habilidades.add(p3);
    }

    /**
     * Agrega un nuevo personaje para que el observador pueda seguir
     * @param observador Observador que ve el combate y sigue un personaje
     */

    public void agregarSeguidor(Observador observador){
        seguidores.add(observador);
    }

    /**
     * Metodo que regresa el nombre del personaje
     * @return Nombre del personaje
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para asignar un nombre a un personaje de los combates
     * @param nombre Nombre del personaje
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa una lista con las habilidades del personaje
     * @return Lista con las habilidades del personaje
     */

    public ArrayList<Poder> getHabilidades() {
        return habilidades;
    }

    /**
     * Metodo que asigna las habilidades de un personaje en una lista de poderes
     * @param habilidades Habilidades de un personaje
     */

    public void setHabilidades(ArrayList<Poder> habilidades) {
        this.habilidades = habilidades;
    }

    /**
     * Regresa el identificador del personaje
     * @return El identificador del personaje
     */

    public int getId() {
        return id;
    }

    /**
     * Asigna un identificador al personaje
     * @param id Identificador del personaje de los enfrentamientos
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Regresa el poder con el que comienza el personaje 
     * @return Poder con el que comienza el personaje
     */

    public int getPoder_inicial() {
        return poder_inicial;
    }

    /**
     * Cambia el poder al iniciar un combate del personaje
     * @param poder_inicial Poder con el que comienza el personaje
     */

    public void setPoder_inicial(int poder_inicial) {
        this.poder_inicial = poder_inicial;
    }

    /**
     * Regresa el nombre del poder del personaje
     * @return Poder del personaje
     */

    public int getPoder() {
        return poder;
    }

    /**
     * Actualizar el poder en cuestion
     * @param poder Poder del personaje para atacar a otros
     */

    public void setPoder(int poder) {
        this.poder = poder;
    }

    /**
     * Obtener los puntos de salud del personaje
     * @return Puntos de salud del personaje
     */

    public int getPuntos_salud() {
        return puntos_salud;
    }

    /**
     * Asignar nuevos puntos de salud
     * @param puntos_salud Vida del personaje en cuestion
     */

    public void setPuntos_salud(int puntos_salud) {
        this.puntos_salud = puntos_salud;
    }
     
}
