import dao.GravadorDeDados;
import entities.Contato;
import exception.ContatoInexistenteException;
import org.junit.jupiter.api.Test;
import system.SistemaAgenda;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class ContatoTest {

    @Test
    public void testaConstrutor(){
        Contato c1 = new Contato("ze", 26, 07);
        assertEquals("ze", c1.getNome());
        assertEquals(26, c1.getDiaAniversario());
        assertEquals(07, c1.getMesAniversario());
    }

    @Test
    public void testaCadastroERemocao(){
        HashMap<String, Contato> contatos = new HashMap<String, Contato>();
        SistemaAgenda sistema = new SistemaAgenda(contatos);
        sistema.cadastraContato("ze", 26, 07);
        assertTrue(sistema.pesquisaAniversariantes(26,07).size()==1);
        try{
            assertTrue(sistema.removeContato("ze"));
        }
        catch(ContatoInexistenteException e) {
            fail("Não é para lançar");
        }
        assertTrue(sistema.pesquisaAniversariantes(26,07).size()==0);
    }
}
