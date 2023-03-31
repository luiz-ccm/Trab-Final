import gui.Screen;
import model.Comodo;
import model.eletronicos.Lampada;
import model.eletronicos.TV;

public class Main {
    public static void main(String[] args) {
        Lampada lampada1 = new Lampada("Lampada da Sala");
        TV tv1 = new TV("TV da Sala");

        Comodo sala = new Comodo("sala");

        sala.adicionarDispositivo(tv1);
        sala.adicionarDispositivo(lampada1);

//         Cria e exibe a janela principal

        sala.getDispositivos().forEach(d -> {
            System.out.println(d.toString());
        });

        Screen screen = new Screen();
    }
}