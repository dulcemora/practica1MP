package Enfrentamientos;

public class AtaqueMagnifico implements Ataque {
    @Override
    public void atacando(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        atacado.salud_disminuye(atacante.getPoder()*4);
        System.out.println(atacante.getNombre()+ " golpeo a "+ atacado.getNombre() + " con un poder Magnifico" );
        System.out.println();
        NotiAtaqueMagnifico noticias = new NotiAtaqueMagnifico(atacante, atacado);

    }
}
