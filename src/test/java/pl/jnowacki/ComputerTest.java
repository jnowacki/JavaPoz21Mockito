package pl.jnowacki;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.jnowacki.model.Computer;
import pl.jnowacki.model.Keyboard;
import pl.jnowacki.model.Printer;
import pl.jnowacki.model.Screen;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ComputerTest {

    @Mock
    private Printer printer;

    @Mock
    private Screen screen;

    @Mock
    private Keyboard keyboard;

    @InjectMocks
    private Computer computer;

    @Test
    public void testMock() {
        when(keyboard.readValue()).thenReturn("valuFromKeyboard");

        computer.readValueFromKeyboardAndDisplayInput();

        verify(screen, times(1)).showMessage("valuFromKeyboard");
    }
}
