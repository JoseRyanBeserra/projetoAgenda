import entities.Contato;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ContatoTest {

    @Test
    public void testaConstrutor(){
        Contato c1 = new Contato("ze", 26, 07);
        assertEquals("ze", c1.getNome());
        assertEquals(26, c1.getDiaAniversario());
        assertEquals(07, c1.getMesAniversario());

    }
}
