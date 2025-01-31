import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

@SuppressWarnings("CodeBlock2Expr")
@ExtendWith(MockitoExtension.class)
public class HorseTest {


    @Test
    public void createHorseWithNullNameThenException(){
        assertThrows(IllegalArgumentException.class,
                ()->{new Horse(null, 50.5, 100.255);}
        );
    }


    @Test
    public void createHorseWithNullNameThenExceptionTwoArguments(){
        assertThrows(IllegalArgumentException.class,
                ()->{new Horse(null, 50.5);}
        );
    }


    @Test
    public void createHorseWithNullNameThenMassage(){
        Throwable exception =assertThrows(IllegalArgumentException.class,
                ()->{new Horse(null, 50.5, 100.255);}
        );
        assertEquals("Name cannot be null.",exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            ", 50.5, 100.255",
            "   , 65.0, 100.255",
            "       \n\n\n,50.5, 100.255"
    })
    public void createHorseWithEmptyNameThenException(String name, double speed, double distance){

        assertThrows(IllegalArgumentException.class,
                ()->{new Horse(name, speed, distance);}
        );
    }
    @Test
    public void createHorseWithEmptyNameThenMassageNoParametrized(){

        Throwable exception =assertThrows(IllegalArgumentException.class,
                ()->{new Horse("   ",50.5, 100.255);}
        );
        assertEquals("Name cannot be blank.",exception.getMessage());
    }

    @Test
    public void createHorseWithEmptyNameThenMassage(){

        Throwable exception =assertThrows(IllegalArgumentException.class,
                ()->{new Horse("", 50.5, 100.255);}
        );
        assertEquals("Name cannot be blank.",exception.getMessage());
    }
    @ParameterizedTest
    @CsvSource({
            "Aport, -50.5, 100.255",
            "Aport, -20.5, 100.255"
    })
    public void createHorseWithNegativeSpeedThenException(String name, double speed, double distance){

        assertThrows(IllegalArgumentException.class,
                ()->{new Horse(name, speed, distance);}
        );
    }
    @Test
    public void createHorseWithNegativeSpeedThenMassage(){

        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()->{new Horse("Zvezdochka", -50.5, 100.255);}
        );
        assertEquals("Speed cannot be negative.",exception.getMessage());
    }
    @Test
    public void createHorseWithNegativeDistanceThenException(){

        assertThrows(IllegalArgumentException.class,
                ()->{new Horse("Zvezdochka", 50.5, -100.255);}
        );
    }
    @Test
    public void createHorseNegativeDistanceThenMassage(){

        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()->{new Horse("Zvezdochka", 50.5, -100.255);}
        );
        assertEquals("Distance cannot be negative.",exception.getMessage());
    }

    @Test
    public void returnName(){
        Horse horse=new Horse("Zvezdochka", 50.5, 100.255);
        assertEquals("Zvezdochka",horse.getName());
    }

    @Test
    public void returnSpeed(){
        Horse horse=new Horse("Zvezdochka", 50.5, 100.255);
        assertEquals(50.5,horse.getSpeed());
    }

    @Test
    public void returnDistance(){
        Horse horse=new Horse("Zvezdochka", 50.5, 100.255);
        assertEquals(100.255,horse.getDistance());
    }

    @Test
    public void returnDistanceEqualsNull(){
        Horse horse=new Horse("Zvezdochka", 50.5);
        assertEquals(0,horse.getDistance());
    }


    @Test
public void whenMoveThenGetRandomDouble() {
        try (MockedStatic<Horse> staticGetRandom = Mockito.mockStatic(Horse.class)) {
            staticGetRandom.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.7);
            Horse horse=new Horse("Zvezdochka", 50.5);
            horse.move();
            staticGetRandom.verify(() -> Horse.getRandomDouble(0.2, 0.9), times(1));
        }
    }
    @ParameterizedTest
    @CsvSource({
            "Aport, 50.5, 20.5"
    })
    public void whenMoveThenEqualsFormula(String name, double speed, double distance) {
        try (MockedStatic<Horse> staticGetRandom = Mockito.mockStatic(Horse.class)) {
            staticGetRandom.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.7);
            Horse horse = new Horse(name, speed, distance);
            horse.move();
            assertEquals(distance + speed * Horse.getRandomDouble(0.2, 0.9),horse.getDistance());
        }
    }
}
