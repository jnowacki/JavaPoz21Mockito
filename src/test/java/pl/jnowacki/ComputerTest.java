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
    public void shouldDisplay() {
        when(keyboard.readValue()).thenReturn("valueFromKeyboard");

        computer.readValueFromKeyboardAndDisplayInput();

        verify(screen, times(1)).showMessage("valueFromKeyboard");
    }

    @Test
    public void shouldPrintWithAllCaps() {
        when(keyboard.readValue()).thenReturn("valueFromKeyboard");

        computer.readValueFromKeyboardAndPrintToPrinterWithAllCaps();

        verify(printer, times(1)).print("VALUEFROMKEYBOARD");
    }

    @Test
    public void shouldDisplayAndPrint() {
        when(keyboard.readValue()).thenReturn("valueFromKeyboard");

        computer.readValueFromKeyboardAndDisplayInputToBothPrinterAndScreen();

        verify(screen, times(1)).showMessage("valueFromKeyboard");
        verify(printer, times(1)).print("valueFromKeyboard");
    }
}
