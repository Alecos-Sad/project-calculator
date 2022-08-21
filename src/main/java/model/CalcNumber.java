package model;

import enumic.CalcNumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Number object class
 *
 * @author SdovNick
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalcNumber {
    private int value;
    private CalcNumType type;
}
