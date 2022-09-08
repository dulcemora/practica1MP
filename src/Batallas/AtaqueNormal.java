package Batallas;

/**
 * AtaqueNormal
 * Clase para el manejo del daño e impresion en pantalla de los ataques normales
 * @author Giovanny Cruz
 * @author Dulce Mora
 * @author Marcos Noriega
 * @version 1.0
 * @see Ataque
 */ 

public class AtaqueNormal implements Ataque {

    @Override
    /** 
     * Metodo que maneja qué personaje ataca a qué personaje utilizando el ataque normal
     * @param atacante Personaje que lanza el ataque a atacado
     * @param atacado Personaje que recibe el ataque del atacante
     */
    public void atacando(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        atacado.salud_disminuye(atacante.getPoder());
        System.out.println(atacante.getNombre()+ " golpeo a "+ atacado.getNombre() );
        System.out.println();
        NotiAtaqueNormal noticias = new NotiAtaqueNormal();
        noticias.noti_ataque(atacante, atacado);
    }
}
