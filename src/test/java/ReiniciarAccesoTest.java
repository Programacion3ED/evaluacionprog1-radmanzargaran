import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReiniciarAccesoTest {

    @Test
    void testReinicioAcceso() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 2);

        u.autenticar("x");
        u.autenticar("x");

        assertTrue(u.isBloqueado());

        u.reiniciarAcceso();

        assertFalse(u.isBloqueado());
        assertEquals(0, u.getIntentosFallidos());
    }
}
