import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@ExtendWith(MockitoExtension.class)
public class MainTest {
    @Disabled
    @Test
    public void mainDuringTime() {
        try {
            assertTimeout(ofSeconds(22), ()->Main.main(null));
        } catch(Exception e)
        {throw new RuntimeException ("Main-test не пройден", e);}
    }
}
