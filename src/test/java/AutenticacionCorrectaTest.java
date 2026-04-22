import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutenticacionCorrectaTest {

    @Test
    void testAutenticacionExitosa() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);

        boolean resultado = u.autenticar("Clave123");

        assertTrue(resultado);
        assertEquals(0, u.getIntentosFallidos());
        assertTrue(u.isAccesoExitoso());
    }
}
