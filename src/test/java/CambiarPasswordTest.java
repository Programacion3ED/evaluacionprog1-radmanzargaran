import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CambiarPasswordTest {

    @Test
    void testCambioPasswordExitoso() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);

        boolean cambio = u.cambiarPassword("Clave123", "Segura999");

        assertTrue(cambio);
        assertTrue(u.autenticar("Segura999"));
    }

    @Test
    void testCambioPasswordFallaPorActualIncorrecta() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);

        boolean cambio = u.cambiarPassword("MalClave", "Segura999");

        assertFalse(cambio);
    }

    @Test
    void testCambioPasswordFallaPorNuevaInsegura() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);

        boolean cambio = u.cambiarPassword("Clave123", "abc");

        assertFalse(cambio);
    }

    @Test
    void testCambioPasswordFallaSiEstaBloqueado() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 2);

        u.autenticar("x");
        u.autenticar("x");

        assertTrue(u.isBloqueado());
        assertFalse(u.cambiarPassword("Clave123", "Segura999"));
    }
}
