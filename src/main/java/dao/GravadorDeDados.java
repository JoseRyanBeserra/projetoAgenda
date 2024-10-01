package dao;

import entities.Contato;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVO_CONTATOS = "dados.dat";

    public Map<String, Contato> recuperarContatos() throws IOException {
        File arquivo = new File(ARQUIVO_CONTATOS);
        if (!arquivo.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS))) {
            return (Map<String, Contato>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro ao ler o objeto do arquivo", e);
        } catch (ClassCastException e) {
            throw new IOException("Erro de cast ao ler o objeto do arquivo", e);
        }
    }

    public void salvarContatos(Map<String, Contato> contatos) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS))) {
            out.writeObject(contatos);
        }
    }
}
