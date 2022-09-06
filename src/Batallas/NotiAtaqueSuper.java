package Batallas;

public class NotiAtaqueSuper implements NotiAtaque{

    

    @Override
    public void noti_ataque(Personaje atacante, Personaje atacado) {
        // TODO Auto-generated method stub
        String texto = atacante.getNombre() +" ataca a " + atacado.getNombre() + " con un poder SUPER";  
        for (Observador observador : atacante.seguidores) {
            observador.escribir("");
            observador.escribir(texto);
        }
        texto = "!!OH NO!! " + atacante.getNombre() + " ha atacado a tu heróe con un poder SUPER" ; 
        for (Observador observador : atacado.seguidores) {
            observador.escribir("");
            observador.escribir(texto);
            observador.salud();
        }
    }
}
