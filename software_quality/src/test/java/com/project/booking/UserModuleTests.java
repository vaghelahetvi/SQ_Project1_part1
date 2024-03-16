import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserModuleTests {

    @Test
    void testRegisterSuccess() {
        // Assuming a method register in UserModule returns true on success
        assertTrue(UserModule.register("validemail@example.com", "StrongPassword123", new UserDetails("John Doe")));
    }

    @Test
    void testRegisterInvalidEmail() {
        // Assuming register method throws IllegalArgumentException on invalid email
        assertThrows(IllegalArgumentException.class, () -> {
            UserModule.register("invalidemail", "StrongPassword123", new UserDetails("John Doe"));
        });
    }

    @Test
    void testRegisterWeakPassword() {
        // Assuming register method throws IllegalArgumentException on weak password
        assertThrows(IllegalArgumentException.class, () -> {
            UserModule.register("validemail@example.com", "123", new UserDetails("John Doe"));
        });
    }

    @Test
    void testRegisterExistingEmail() {
        // Assuming register method throws IllegalArgumentException for an existing email
        assertThrows(IllegalArgumentException.class, () -> {
            UserModule.register("existingemail@example.com", "StrongPassword123", new UserDetails("John Doe"));
        });
    }

    @Test
    void testLoginSuccess() {
        // Assuming a login method that returns true on successful login
        assertTrue(UserModule.login("validemail@example.com", "StrongPassword123"));
    }

    @Test
    void testLoginIncorrectPassword() {
        // Assuming login method throws IllegalArgumentException on incorrect password
        assertThrows(IllegalArgumentException.class, () -> {
            UserModule.login("validemail@example.com", "WrongPassword");
        });
    }

    @Test
    void testLoginUnregisteredEmail() {
        // Assuming login method throws IllegalArgumentException for unregistered email
        assertThrows(IllegalArgumentException.class, () -> {
            UserModule.login("unregistered@example.com", "AnyPassword");
        });
    }
}