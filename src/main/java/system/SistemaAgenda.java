package system;

import entities.Contato;
import exception.ContatoInexistenteException;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SistemaAgenda implements InterfaceAgenda{
    private Map<String, Contato> contatos;


    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        return false;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        return List.of();
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        return false;
    }

    @Override
    public void salvarDados() throws IOException {

    }

    @Override
    public void recuperarDados() throws IOException {

    }
}
