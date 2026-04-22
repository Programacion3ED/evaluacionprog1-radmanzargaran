import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BloqueoTest {

    @Test
    void testIntentosFallidosYBloqueo() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);

        assertFalse(u.autenticar("abc"));
        assertFalse(u.autenticar("abc"));
        assertEquals(2, u.getIntentosFallidos());
        assertFalse(u.isBloqueado());

        assertFalse(u.autenticar("abc"));
        assertTrue(u.isBloqueado());
        assertEquals(3, u.getIntentosFallidos());
    }

    @Test
    void testUsuarioBloqueadoNoAutentica() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 2);

        u.autenticar("x");
        u.autenticar("x");

        assertTrue(u.isBloqueado());
        assertFalse(u.autenticar("Clave123"));
    }
}
