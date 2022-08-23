package service.impl;

import com.sadovnick.kata.type.CalcNumType;
import com.sadovnick.kata.model.CalcNumber;
import com.sadovnick.kata.service.impl.NumberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberServiceImplTest {

    NumberServiceImpl numberService = new NumberServiceImpl();

    @Test
    void parseNumber() {
        CalcNumber calcNumber1 = numberService.parseNumber("6");
        Assertions.assertEquals(6, calcNumber1.getValue());
        Assertions.assertEquals(CalcNumType.ARABIC, calcNumber1.getType());

        CalcNumber calcNumber2 = numberService.parseNumber("XXX");
        Assertions.assertEquals(30, calcNumber2.getValue());
        Assertions.assertEquals(CalcNumType.ROMAN, calcNumber2.getType());
    }

    private CalcNumber getCalcNumber(int value, CalcNumType calcNumType) {
        CalcNumber calcNumber = new CalcNumber();
        calcNumber.setValue(value);
        calcNumber.setType(calcNumType);
        return calcNumber;
    }
}