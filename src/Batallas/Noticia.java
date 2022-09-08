package Batallas;

/**
 * Noticia
 * Interface para las notificaciones
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 */ 

public interface Noticia {

    /**
     * Notifica sobre el estado de los personajes
     * @param personaje Personaje que peleara en los enfrentamientos
     */
    public void avisa(Personaje personaje);
}
