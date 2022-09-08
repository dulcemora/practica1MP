package Batallas;

/**
 * AtaqueSuper
 * Clase para el manejo del daño e impresion en pantalla de los super ataques
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 * @see Ataque
 */ 

public class AtaqueSuper implements Ataque{
    
    @Override
    /** 
     * Metodo que maneja qué personaje ataca a qué personaje utilizando el ataque super
     * @param atacante Personaje que lanza el ataque a atacado
     * @param atacado Personaje que recibe el ataque del atacante
     */
    public void atacando(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        atacado.salud_disminuye(atacante.getPoder()*3);
        System.out.println(atacante.getNombre()+ " golpeo a "+ atacado.getNombre() + " con un poder Super" );
        System.out.println();
        NotiAtaqueSuper noticias = new NotiAtaqueSuper();
        noticias.noti_ataque(atacante, atacado);
    }
}

