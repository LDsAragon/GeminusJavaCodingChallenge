package Challenges;

import java.util.HashMap;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Challenge4 {

  /*
    Caso 4

    Utilizando la librería exp4j resolver el valor de SGR:
    SGR = (0,17573-0,000191625*PESO + 0,000000137475*PESO^2-0,0000000000538613*PESO^3 + 0,0000000000000120375*PESO^4-1,58066E-18*PESO^5 + 1,20045E-22*PESO^6-4,83673E-27*PESO^7 + 7,8811E-32*PESO^8)*TEMP

    Para una temperatura (TEMP) de 11,5 grados y un peso (PESO) de 3200 gramos

    Mostrar el resultado simplemente por consola.
    Nota: Descargar la librería exp4j de la web.

   */

  public static void main(String[] args) {

    //Value for Temperature (TEMP) in degrees
    Double temperature = 11.5d;

    //Value for weight (PESO) in grams. Example 3200g
    Double weight = 3200d;

    final String WEIGHT_NAME = "PESO";
    final String TEMPERATURE_NAME = "TEMP";

    /* Variables to replace in expression */
    String[] variablesToReplace = {WEIGHT_NAME, TEMPERATURE_NAME};

    HashMap<String, Double> mapToReplace = new HashMap<>();
    mapToReplace.put(WEIGHT_NAME, weight);
    mapToReplace.put(TEMPERATURE_NAME, temperature);

    // Expression to evaluate
    final String SGR =
        "(0,17573-0,000191625*PESO + 0,000000137475*PESO^2-0,0000000000538613*PESO^3 + 0,0000000000000120375*PESO^4-1,58066E-18*PESO^5 + 1,20045E-22*PESO^6-4,83673E-27*PESO^7 + 7,8811E-32*PESO^8)*TEMP";

    final String NEW_SGR = "("
        + "0,17573 "
        + "-0,000191625*PESO "
        + "+0,000000137475*PESO^2 "
        + "-0,0000000000538613*PESO^3 "
        + "+0,0000000000000120375*PESO^4 "
        + "-1,58066e-18*PESO^5 "
        + "+1,20045e-22*PESO^6 "
        + "-4,83673e-27*PESO^7 "
        + "+7,8811e-32*PESO^8 " +
        ") "
        + "*TEMP ";

    // Replace colons by dots to standardize to american decimal separator. I got the hint from here https://www.objecthunter.net/exp4j/#Examples
    String replacedColons = SGR.replaceAll(",",".") ;

    Expression expression = new ExpressionBuilder(replacedColons).variables(variablesToReplace).build()
        .setVariables(mapToReplace);

    if (expression.validate().isValid()) {
      double result = expression.evaluate();
      System.out.println("\n \n Result of evaluating expression with given values: " + result);
    } else {
      System.out.println("There was an error and the expression is invalid :( ");
      System.out.println(expression.validate().getErrors().toString());

    }
    //0.5788386124180797 SGR
    //0.5788386124180797 NEW_SGR

    /* New_SGR exists because I was getting a: "to many operands" error,
    And needed to check if that was really the case
    , in the end it was because of the decimal separator

    I keep it in the code just for the sake of establishing the approach I took to find a solution
    */

  }

}
