import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import ru.gx.fin.gate.quik.provider.out.QuikSessionedSecurity;

@Testable
public class Generator {
    @Test
    public void generate() {
        final var cls = QuikSessionedSecurity.class;
        final var fields = cls.getDeclaredFields();
        for (final var field : fields) {
            System.out.println("@JsonProperty(\"" + field.getName() + "\") ");
        }
    }
}
