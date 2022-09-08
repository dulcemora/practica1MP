package Batallas;

/**
 * AtaqueEspecial
 * Clase para el manejo del daño e impresion en pantalla de los ataques especiales
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 * @see Ataque
 */ 

public class AtaqueEspecial implements Ataque{

    @Override
    /** 
     * Metodo que maneja qué personaje ataca a qué personaje utilizando el ataque especial
     * @param atacante Personaje que lanza el ataque a atacado
     * @param atacado Personaje que recibe el ataque del atacante
     */    
    public void atacando(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        atacado.salud_disminuye(atacante.getPoder()*2);
        System.out.println(atacante.getNombre()+ " golpeo a "+ atacado.getNombre() + " con un ataque Especial" );
        System.out.println();
        NotiAtaqueEspecial noticias = new NotiAtaqueEspecial();
        noticias.noti_ataque(atacante, atacado);
    }
}
