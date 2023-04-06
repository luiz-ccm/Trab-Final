/**
 * Classe para organizar comodos
 * 
 */


package repository;

import model.comodos.Comodo;
import model.eletronicos.Dispositivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static repository.DispositivoRepository.atualizarDispositivo;
import static repository.DispositivoRepository.buscarDispositivoPorNome;

public class ComodoRepository {
    private static final String ARQUIVO_BD = "src/src/db/comodos.ser";

    /**
     * Método para salvar comodo em arquivo
     * @param comodo comodo que será salvo
     */
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

    /**
     * Método para listar os comodos
     * @return lista de comodos
     */
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

    /**
     * Método para buscar comodo pelo nome
     * @param nome nome do comodo procurado
     * @return comodo correpondente na lista de todos os comodos
     */
    public static Comodo buscarComodoPorNome(String nome) throws IOException, ClassNotFoundException {
        List<Comodo> comodos = listarTodosComodos();
        for (Comodo comodo : comodos) {
            if (comodo.getNome().equalsIgnoreCase(nome)) {
                return comodo;
            }
        }
        return null;
    }

    /**
     * Método para verificar se já existe um comodo com o mesmo nome na lista de comodos
     * @param comodo novo comodo
     * @param comodos lista de todos os comodos
     */
    private static void validarComodo(List<Comodo> comodos, Comodo comodo) {
        for (Comodo c : comodos) {
            if (c.getNome().equalsIgnoreCase(comodo.getNome()) && c.getTipoComodo().equals(comodo.getTipoComodo())) {
                throw new RuntimeException("Já existe um comodo com esse nome e tipo");
            }
        }
    }

    public static void desvincularDoComodo(Dispositivo dispositivo,Comodo comodo) throws IOException, ClassNotFoundException {
        Comodo com = buscarComodoPorNome(comodo.getNome());
        System.out.println(com.getDispositivos());
        com.desvincular(dispositivo);
        atualizarComodo(com);
        System.out.println(com.getDispositivos());


    }

    public static void atualizarComodo(Comodo comodoAtualizado) throws IOException, ClassNotFoundException {
        String nomeComodo = comodoAtualizado.getNome();
        List<Comodo> comodos = listarTodosComodos();
        boolean comodoEncontrado = false;

        for (int i = 0; i < comodos.size(); i++) {
            if (comodos.get(i).getNome().equals(nomeComodo)) {
                comodos.set(i, comodoAtualizado);
                comodoEncontrado = true;
                break;
            }
        }

        if (!comodoEncontrado) {
            throw new RuntimeException("Dispositivo não encontrado");
        }

        salvaTodosComodos(comodos);
    }

    private static void salvaTodosComodos(List<Comodo> comodos) {
        File arquivo = new File(ARQUIVO_BD);

        arquivo.delete();

        arquivo = new File(ARQUIVO_BD);

        comodos.forEach(dispositivo -> {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_BD))) {
                out.writeObject(comodos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void excluirComodoDoBanco(Comodo comodo) throws IOException, ClassNotFoundException {
        comodo.getDispositivos().forEach(dispositivo ->{
            Dispositivo disp = null;
            try {
                disp = buscarDispositivoPorNome(dispositivo.getNome());
                disp.desvincularComodo();
                atualizarDispositivo(disp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });

        Comodo com = buscarComodoPorNome(comodo.getNome());
        excluir(com);

    }

    private static void excluir(Comodo com) throws IOException, ClassNotFoundException {
        List<Comodo> comodos = listarTodosComodos();
        comodos.removeIf(c -> c.getNome().equals(com.getNome()));

        salvaTodosComodos(comodos);
    }

}
