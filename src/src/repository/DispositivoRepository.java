package repository;

import model.eletronicos.Dispositivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DispositivoRepository {
    private static final String ARQUIVO_BD = "src/src/db/dispositivos.ser";

    public static void salvarDispositivo(Dispositivo dispositivo) throws IOException, ClassNotFoundException {
        File arquivo = new File(ARQUIVO_BD);

        List<Dispositivo> dispositivos;
        if (arquivo.exists()) {
            dispositivos = listarTodosDispositivos();
        } else {
            dispositivos = new ArrayList<>();
        }

        if (buscarDispositivoPorNomeETipo(dispositivo.getNome(), dispositivo.getTipo()) == null) {
            dispositivos.add(dispositivo);

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BD))) {
                out.writeObject(dispositivos);
            }
        } else {
            throw new RuntimeException("Já existe um dispositivo com esse nome e tipo");
        }
    }

    public static List<Dispositivo> listarTodosDispositivos() throws IOException, ClassNotFoundException {
        File arquivo = new File(ARQUIVO_BD);

        if (arquivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_BD))) {
                List<Dispositivo> dispositivos = (List<Dispositivo>) in.readObject();
                return dispositivos;
            }
        } else {
            return new ArrayList<>();
        }
    }

    public static Dispositivo buscarDispositivoPorNome(String nome) throws IOException, ClassNotFoundException {
        List<Dispositivo> dispositivos = listarTodosDispositivos();

        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getNome().equals(nome)) {
                return dispositivo;
            }
        }

        throw new RuntimeException("Dispositivo não encontrado");
    }

    public static Dispositivo buscarDispositivoPorNomeETipo(String nome, String tipo) throws IOException, ClassNotFoundException {
        List<Dispositivo> dispositivos = listarTodosDispositivos();

        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getNome().equals(nome) && dispositivo.getTipo().equals(tipo)) {
                return dispositivo;
            }
        }

        return null;
    }

    public static void atualizarDispositivo(Dispositivo dispositivoAtualizado) throws IOException, ClassNotFoundException {
        String nomeDispositivo = dispositivoAtualizado.getNome();
        List<Dispositivo> dispositivos = listarTodosDispositivos();
        boolean dispositivoEncontrado = false;

        for (int i = 0; i < dispositivos.size(); i++) {
            if (dispositivos.get(i).getNome().equals(nomeDispositivo)) {
                dispositivos.set(i, dispositivoAtualizado);
                dispositivoEncontrado = true;
                break;
            }
        }

        if (!dispositivoEncontrado) {
            throw new RuntimeException("Dispositivo não encontrado");
        }

        salvarTodosDispositivos(dispositivos);
    }

    private static void salvarTodosDispositivos(List<Dispositivo> dispositivos){
        File arquivo = new File(ARQUIVO_BD);

        arquivo.delete();

        arquivo = new File(ARQUIVO_BD);

        dispositivos.forEach(dispositivo -> {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BD))) {
                out.writeObject(dispositivos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}