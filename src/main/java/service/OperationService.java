package service;

import model.CalcNumber;

import java.util.Optional;

/**
 * The interface provides methods for successful computation.
 *
 * @author SaadovNick
 * @version 1.0
 */
public interface OperationService {

    String calculation(CalcNumber first, CalcNumber second, String operation);

    String catchOperation(Optional<String> inputLine);
}
