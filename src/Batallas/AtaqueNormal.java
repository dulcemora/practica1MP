package Batallas;

public class AtaqueNormal implements Ataque {
    @Override
    public void atacando(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        atacado.salud_disminuye(atacante.getPoder());
        System.out.println(atacante.getNombre()+ " golpeo a "+ atacado.getNombre() );
        System.out.println();
        NotiAtaqueNormal noticias = new NotiAtaqueNormal();
        noticias.noti_ataque(atacante, atacado);
    }
}
