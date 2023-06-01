package Challenges;

import java.util.Scanner;

public class Challenge1 {

   /*
    Caso 1

    Ingresar un número.

    Si el número ingresado es par, multiplicarlo por 10.
    Si el número ingresado es impar, multiplicarlo por 3.

    Luego dividir el valor de SGR, por el producto resultante del paso anterior.
    Nota: SGR es una variable de tipo Double con valor = 1590d

   */
   static final String NEW_LINE = "\n";

  public static void main(String[] args) {

    System.out.println(NEW_LINE + NEW_LINE +
        "To use this program you need to insert a valid numeric double value. (But just one)" +
        NEW_LINE + "Use a colon [,] as a decimal separator" + NEW_LINE +
        "Examples of valid numbers without decimal values: [2] - [10] - [5] - [18] - [17]" + NEW_LINE+
        "Examples of valid numbers with decimal values: [2,5] - [10,9]" + NEW_LINE);


    System.out.println(
        "Insert a valid numeric value below. And remember, just one ^_^ (Click on the console)");

    Scanner sc = new Scanner(System.in);
    Double userNumber = sc.nextDouble();
    Double userNumberReference = userNumber;

    final Double SGR = 1590d;

    System.out.println(NEW_LINE + "======Beginning Calculations======" + NEW_LINE);

    System.out.println("Number entered by the user: " + userNumberReference + NEW_LINE);

    if (isEven(userNumber)) {
      userNumber = userNumber * 10;
      System.out.println(
          "Multiplication -> " + userNumberReference + " * 10 => " + userNumber + NEW_LINE);
    } else {
      userNumber = userNumber * 3;
      System.out.println(
          "Multiplication -> " + userNumberReference + " * 3 => " + userNumber + NEW_LINE);
    }

    Double result = SGR / userNumber;
    System.out.println("Division -> " + SGR + " / " + userNumber + " => " + result + NEW_LINE);
    System.out.println("Result: " + result);

  }


  static Boolean isEven(Double userNumber) {
    Double remainder = userNumber % 2;

    // Display remainder if odd
    if (!(remainder == 0)) {
      System.out.println("The number is odd ");
      System.out.println("Remainder: " + remainder + NEW_LINE);
    } else {
      System.out.println("The number is even " + NEW_LINE);
    }

    return (remainder == 0);
  }


}
