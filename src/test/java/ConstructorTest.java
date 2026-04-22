import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConstructorTest {

    @Test
    void testInicializacionCorrecta() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 4);

        assertEquals("admin", u.getUsername());
        assertEquals(0, u.getIntentosFallidos());
        assertFalse(u.isBloqueado());
        assertEquals(4, u.getMaxIntentos());
        assertFalse(u.isAccesoExitoso());
    }

    @Test
    void testMaxIntentosPorDefecto() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 0);
        assertEquals(3, u.getMaxIntentos());
    }
}
