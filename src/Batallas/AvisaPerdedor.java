package Batallas;

/**
 * AvisaPerdedor
 * Clase para imprimir en pantalla el nombre del perdedor y enviarlo al observador
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 * @see Noticia
 */ 

public class AvisaPerdedor implements Noticia{

    @Override
    /**
     * Metodo que notifica si hay perdedor y quien ha sido
     * @param personaje Personaje que peleara en los enfrentamientos
     */
    public void avisa(Personaje personaje) {
        // TODO Auto-generated method stub
        String text = "Que lastima " + personaje.getNombre() + " ha perdido";
        for (Observador observador : personaje.seguidores) {
            observador.escribir("");
            observador.escribir(text);
        }
    }
}
