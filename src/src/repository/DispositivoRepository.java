package repository;

import model.eletronicos.Dispositivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class DispositivoRepository {
    public static void salvarDispositivo(Dispositivo dispositivo) throws IOException {
        File arquivo = new File("src/src/db/dispositivos.ser");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileOutputStream fileOut = new FileOutputStream("src/src/db/dispositivos.ser",true);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(dispositivo);
        out.close();
        fileOut.close();
        System.out.println("Objeto serializado e salvo em db/dispositivos.ser");
    }
}