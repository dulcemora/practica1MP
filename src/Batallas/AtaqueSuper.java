package Batallas;

public class AtaqueSuper implements Ataque{
    @Override
    public void atacando(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        atacado.salud_disminuye(atacante.getPoder()*3);
        System.out.println(atacante.getNombre()+ " golpeo a "+ atacado.getNombre() + " con un poder Super" );
        System.out.println();
        NotiAtaqueSuper noticias = new NotiAtaqueSuper();
        noticias.noti_ataque(atacante, atacado);
    }
}

