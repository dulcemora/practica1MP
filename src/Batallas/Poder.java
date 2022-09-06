package Batallas;

public class Poder {
    private String nombre;
    private int personaje;
    private int id;
    private int aumento;

    
    public Poder(String nombre, int personaje, int id, int aumento){
        this.nombre = nombre;
        this.personaje = personaje;
        this.id = id;
        this.aumento = aumento;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getPersonaje() {
        return personaje;
    }


    public void setPersonaje(int personaje) {
        this.personaje = personaje;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getAumento() {
        return aumento;
    }


    public void setAumento(int aumento) {
        this.aumento = aumento;
    }

     
    
    

}
