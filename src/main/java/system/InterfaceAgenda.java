package system;

import entities.Contato;
import exception.ContatoInexistenteException;

import java.io.IOException;
import java.util.Collection;

public interface InterfaceAgenda {
    public boolean cadastraContato(String nome, int dia, int mes);
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes);
    public boolean removeContato(String nome) throws ContatoInexistenteException;
    public void salvarDados() throws IOException;
    public void recuperarDados() throws IOException;
}