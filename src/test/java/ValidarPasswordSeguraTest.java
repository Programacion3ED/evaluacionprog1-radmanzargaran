import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidarPasswordSeguraTest {

    @Test
    void testPasswordValida() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);
        assertTrue(u.validarPasswordSegura("NuevaClave1"));
    }

    @Test
    void testPasswordInvalidaPorLongitud() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);
        assertFalse(u.validarPasswordSegura("Abc12"));
    }

    @Test
    void testPasswordInvalidaSinMayuscula() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);
        assertFalse(u.validarPasswordSegura("nuevaclave1"));
    }

    @Test
    void testPasswordInvalidaSinNumero() {
        UsuarioSeguroAvanzado u = new UsuarioSeguroAvanzado("admin", "Clave123", 3);
        assertFalse(u.validarPasswordSegura("NuevaClave"));
    }
}
