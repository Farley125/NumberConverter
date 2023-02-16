import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        boolean isValid = false;
        String n = "";
        int base = 0;
        Scanner s = new Scanner(System.in);
        while (isValid != true) {
            System.out.println("Welcome to the Number Converter!");
            System.out.println("--------------------------------");
            System.out.print("Enter the base of your number (2, 8 or 10): ");

            String choice = s.nextLine();
            int baseTest = Integer.parseInt(choice);

            System.out.print("Enter your number: ");
            String number = s.nextLine();
            String nTest = number;

            isValid = NumberConverter.isValid(baseTest, nTest);
            if (isValid) {
                n = nTest;
                base = baseTest;
            } else System.out.println("Invalid Input.");
        }
        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        String[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        if (nc.getBase() == 2){
            System.out.println("Number in Decimal: " + nc.displayDecalNumber());
            System.out.println("Number in Octal: " + nc.displayOctalNumber());
        }
        if (nc.getBase() == 8){
            System.out.println("Number in Decimal: " + nc.displayDecalNumber());
            System.out.println("Number in Binary: " + nc.displayBinaryNumber());
        }
        if (nc.getBase() == 10){
            System.out.println("Number in Octal: " + nc.displayOctalNumber());
            System.out.println("Number in Binary: " + nc.displayBinaryNumber());
        }


    }
}

