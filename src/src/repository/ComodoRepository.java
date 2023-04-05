package repository;

import model.comodos.Comodo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComodoRepository {
    private static final String ARQUIVO_BD = "src/src/db/comodos.ser";

    public static void salvarComodo(Comodo comodo) throws IOException, ClassNotFoundException {
        File arquivo = new File(ARQUIVO_BD);

        List<Comodo> comodos;
        if (arquivo.exists()) {
            comodos = listarTodosComodos();
            validarComodo(comodos, comodo);
        } else {
            comodos = new ArrayList<>();
        }

        comodos.add(comodo);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BD))) {
            out.writeObject(comodos);
        }
    }

    public static List<Comodo> listarTodosComodos() throws IOException, ClassNotFoundException {
        File arquivo = new File(ARQUIVO_BD);

        if (arquivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_BD))) {
                List<Comodo> comodos = (List<Comodo>) in.readObject();
                return comodos;
            }
        } else {
            return new ArrayList<>();
        }
    }

    public static Comodo buscarComodoPorNome(String nome) throws IOException, ClassNotFoundException {
        List<Comodo> comodos = listarTodosComodos();
        for (Comodo comodo : comodos) {
            if (comodo.getNome().equalsIgnoreCase(nome)) {
                return comodo;
            }
        }
        return null;
    }

    private static void validarComodo(List<Comodo> comodos, Comodo comodo) {
        for (Comodo c : comodos) {
            if (c.getNome().equalsIgnoreCase(comodo.getNome()) && c.getTipoComodo().equals(comodo.getTipoComodo())) {
                throw new RuntimeException("Já existe um comodo com esse nome e tipo");
            }
        }
    }
}
