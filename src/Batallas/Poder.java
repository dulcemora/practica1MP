package Batallas;

/**
 * Poder
 * Clase para el manejo de los poderes, asi como los getters y setters de los poderes
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 */ 

public class Poder {
    private String nombre;
    private int personaje;
    private int id;
    private int aumento;

    /**
     * Constructor de los poderes de los personajes
     * @param nombre Nombre del poder
     * @param personaje Personaje al que corresponde el poder
     * @param id Identificador del poder
     * @param aumento Cantidad de daño que puede aumentar el poder
     */
    
    public Poder(String nombre, int personaje, int id, int aumento){
        this.nombre = nombre;
        this.personaje = personaje;
        this.id = id;
        this.aumento = aumento;
    }

    /**
     * Metodo que regresa el nombre del poder
     * @return Nombre del poder
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para asignar un nombre a un poder
     * @param nombre Nombre del poder
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que regresa el personaje al que corresponde el poder
     * @return Personaje al que corrsponde el poder
     */

    public int getPersonaje() {
        return personaje;
    }

    /**
     * Metodo para asignar un poder a un personaje
     * @param personaje Numero con el que se identifica al personaje
     */

    public void setPersonaje(int personaje) {
        this.personaje = personaje;
    }

    /**
     * Metodo para regresar el identificador del poder
     * @return Identificador del poder
     */

    public int getId() {
        return id;
    }

    /**
     * Metodo para asignar un identificador a un poder
     * @param id identificador del poder
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que regresa el daño que aumenta el poder
     * @return Cantidad de daño que aumenta el poder
     */

    public int getAumento() {
        return aumento;
    }

    /**
     * Metodo para asignar cuanto aumenta el daño de un poder
     * @param aumento Cantidad de daño que aumenta el poder
     */

    public void setAumento(int aumento) {
        this.aumento = aumento;
    }

     
    
    

}
