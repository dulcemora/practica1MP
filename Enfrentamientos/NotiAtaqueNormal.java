package Enfrentamientos;

public class NotiAtaqueNormal implements NotiAtaque {

    public NotiAtaqueNormal(Personaje atacante, Personaje atacado){
        noti_ataque(atacante, atacado);
    }

    @Override
    public void noti_ataque(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        String texto = atacante.getNombre() +"ataca a " + atacado.getNombre();  
        for (Observador observador : atacante.seguidores) {
            observador.escribir("");
            observador.escribir(texto);
        }
        texto = "!!OH NO!! " + atacante.getNombre() + " ha atacado a tu heróe" ; 
        for (Observador observador : atacado.seguidores) {
            observador.escribir("");
            observador.escribir(texto);
            observador.salud();
        }
        
    }
}
