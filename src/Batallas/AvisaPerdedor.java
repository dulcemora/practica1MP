package Batallas;

public class AvisaPerdedor implements Noticia{
    @Override
    public void avisa(Personaje personaje) {
        // TODO Auto-generated method stub
        String text = "Que lastima " + personaje.getNombre() + " ha perdido";
        for (Observador observador : personaje.seguidores) {
            observador.escribir("");
            observador.escribir(text);
        }
    }
}
