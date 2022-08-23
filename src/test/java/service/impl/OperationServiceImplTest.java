package service.impl;

import com.sadovnick.kata.type.CalcNumType;
import com.sadovnick.kata.model.CalcNumber;
import com.sadovnick.kata.service.impl.OperationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationServiceImplTest {

    OperationServiceImpl operationService = new OperationServiceImpl();

    @Test
    void calculation() {
        CalcNumber calcNumber1 = getCalcNumber(12, CalcNumType.ROMAN);
        CalcNumber calcNumber2 = getCalcNumber(52, CalcNumType.ROMAN);
        Assertions.assertEquals("LXIV", operationService.calculation(calcNumber1, calcNumber2, "+"));

        CalcNumber calcNumber3 = getCalcNumber(12, CalcNumType.ARABIC);
        CalcNumber calcNumber4 = getCalcNumber(52, CalcNumType.ARABIC);
        Assertions.assertEquals("64", operationService.calculation(calcNumber3, calcNumber4, "+"));
    }

    CalcNumber getCalcNumber(int value, CalcNumType type) {
        CalcNumber calcNumber = new CalcNumber();
        calcNumber.setValue(value);
        calcNumber.setType(type);
        return calcNumber;
    }

    @Test
    void catchOperation() {
    }
}