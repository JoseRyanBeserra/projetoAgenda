package system;

import dao.GravadorDeDados;
import entities.Contato;
import exception.ContatoInexistenteException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class SistemaAgenda implements InterfaceAgenda{
    private Map<String, Contato> contatos;
    private GravadorDeDados gravador;

    public SistemaAgenda(HashMap<String, Contato> contatos){
        this.contatos = contatos;
        this.gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if(contatos.containsKey(nome)){
            return false;
        }else {
            Contato contato = new Contato(nome, dia, mes);
            contatos.put(nome, contato);
            return true;
        }
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        Collection<Contato> listaAniversariantes = new ArrayList<>();
        for(Contato contato:contatos.values()){
            if((contato.getDiaAniversario()==dia)&(contato.getMesAniversario()==mes)){
                listaAniversariantes.add(contato);
            }
        }
        return listaAniversariantes;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if(contatos.containsKey(nome)){
            contatos.remove(nome);
            return !(contatos.containsKey(nome));
        }else{
            throw new ContatoInexistenteException("Contato não cadastrado no sistema");
        }
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.salvarContatos(this.contatos);
    }

    @Override
    public void recuperarDados() throws IOException {
        Map<String, Contato> contatosRecuperados = gravador.recuperarContatos();
        if (contatosRecuperados != null) {
            this.contatos = contatosRecuperados;
        } else {
            this.contatos = new HashMap<>();
        }
    }
}
