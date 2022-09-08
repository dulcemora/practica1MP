package Batallas;

/**
 * NotiAtaque
 * Interface para el manejo de notificaciones cuando un personaje usa distintos tipos de ataque
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 */
 
public interface NotiAtaque {

    /**
     *Metodo que indica que personaje esta atacando a cual
     **/
    public void noti_ataque(Personaje atacante, Personaje atacado);
    //public void noti_amenaza(Personaje atacante, Personaje atacado);
}
