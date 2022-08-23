package converter.impl;

import com.sadovnick.kata.converter.impl.ConverterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConverterImplTest {

    ConverterImpl converter = new ConverterImpl();

    @Test
    void convertToArabic() {
        Assertions.assertEquals(11, converter.convertToArabic("XI"));
    }

    @Test
    void convertToRomanian() {
        Assertions.assertEquals("III", converter.convertToRomanian(3));
    }
}

