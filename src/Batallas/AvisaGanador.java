package Batallas;

public class AvisaGanador implements Noticia {
    @Override
    public void avisa(Personaje personaje) {
        // TODO Auto-generated method stub
        String text = "!!!!!EL GANADOR HA SIDO " + personaje.getNombre().toUpperCase() + "!!!!!";
        for (Observador observador : personaje.seguidores) {
            observador.escribir("");
            observador.escribir(text);
        }
    }
}
