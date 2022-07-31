import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HipodromeTest {
    @Test
    public void whenConstructorWithNullReturnException(){
        assertThrows(IllegalArgumentException.class, ()->new Hippodrome(null));
    }
    @Test
    public void whenConstructorWithNullReturnMessage() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));

        assertEquals("Horses cannot be null.", exception.getMessage());
    }
    @Test
    public void whenConstructorWithNullListReturnException(){
        List<Horse> horses= new ArrayList<>();
        assertThrows(IllegalArgumentException.class, ()->new Hippodrome(horses));
    }
    @Test
    public void whenConstructorWithNullListReturnMessage() {
        List<Horse> horses= new ArrayList<>();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));

        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    public void getHorsesThenSameOrder(){
        Horse[]horses=new Horse[20];
        horses[0]=new Horse("Antalia", 20.0, 20.255);
        horses[1]=new Horse("Alania", 20.0, 20.255);
        horses[2]=new Horse("Adelina", 20.0, 20.255);
        horses[3]=new Horse("Adel", 20.0, 20.5);
        horses[4]=new Horse("Arina", 20.0, 20.255);
        horses[5]=new Horse("Alina", 20.0, 20.255);
        horses[6]=new Horse("Aziza", 20.0, 20.255);
        horses[7]=new Horse("Ann", 20.0, 17.255);
        horses[8]=new Horse("Alia", 20.0, 20.255);
        horses[9]=new Horse("Antanina", 20.0, 20.255);
        horses[10]=new Horse("Aleftina", 20.0, 20.255);
        horses[11]=new Horse("Adelina", 20.0, 20.255);
        horses[12]=new Horse("Ariadna", 20.0, 20.255);
        horses[13]=new Horse("Alloiza", 20.0, 20.255);
        horses[14]=new Horse("Azizadel", 20.0, 20.255);
        horses[15]=new Horse("Anny", 20.0, 50.255);
        horses[16]=new Horse("Berta", 20.0, 20.255);
        horses[17]=new Horse("Bonna", 20.0, 20.255);
        horses[18]=new Horse("Beatrice", 20.0, 20.255);
        horses[19]=new Horse("Bonny", 20.0, 80.255);

        List<Horse>horsesList=Arrays.asList(horses);
        Hippodrome hippodrome = new Hippodrome(horsesList);
        for (int i = 0; i < 20; i++) {
            assertEquals(horses[i],hippodrome.getHorses().get(i));
        }

    }

}
