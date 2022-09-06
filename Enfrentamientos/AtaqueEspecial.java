package Enfrentamientos;

public class AtaqueEspecial implements Ataque{
    @Override
    public void atacando(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        atacado.salud_disminuye(atacante.getPoder()*2);
        System.out.println(atacante.getNombre()+ " golpeo a "+ atacado.getNombre() + " con un ataque Especial" );
        System.out.println();
    }
}