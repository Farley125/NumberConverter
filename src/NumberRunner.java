import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        boolean isValid = false;
        String n = "";
        int base = 0;
        Scanner s = new Scanner(System.in);
        String choice = "";
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.print("What are you looking to do?\n1. Convert from decimal to an inputted base\n2. Convert from a base to other bases (2, 8, 10, 16)\nInput: ");
            choice = s.nextLine();
        }
        while (isValid != true) {
            if (choice.equals("1")) {
                System.out.print("Enter a number in base 10: ");
                String number = s.nextLine();
                System.out.print("Enter the base you wish to convert to: ");
                String convertTo = s.nextLine();
                isValid = NumberConverter.isValid(10, number);
                if (isValid) {
                    NumberConverter nc = new NumberConverter(number, 10);
                    String[] digits = nc.getDigits();
                    System.out.println("\n\nDigit array: " + Arrays.toString(digits));
                    System.out.println("Number: " + nc.displayOriginalNumber());
                    System.out.println("Number Universal: " + nc.convertUniversal(Integer.parseInt(convertTo)));
                } else System.out.println("Invalid Input.");
            } else {
                System.out.print("Enter the base of your number (2, 8, 10, 16): ");

                String based = s.nextLine();
                int baseTest = Integer.parseInt(based);

                System.out.print("Enter your number: ");
                String number = s.nextLine();
                String nTest = number;

                isValid = NumberConverter.isValid(baseTest, nTest);
                if (isValid) {
                    NumberConverter nc = new NumberConverter(nTest, baseTest);
                    String[] digits = nc.getDigits();
                    System.out.println("\n\nDigit array: " + Arrays.toString(digits));
                    System.out.println("Number: " + nc.displayOriginalNumber());
                    if (nc.getBase() == 2){
                        System.out.println("Number in Hexadecimal: " + nc.convertUniversal(16) + "\n");
                        System.out.println("Number in Decimal: " + nc.displayDecalNumber());
                        System.out.println("Number in Octal: " + nc.displayOctalNumber());
                    }
                    if (nc.getBase() == 8){
                        System.out.println("Number in Hexadecimal: " + nc.convertUniversal(16) + "\n");
                        System.out.println("Number in Decimal: " + nc.displayDecalNumber());
                        System.out.println("Number in Binary: " + nc.displayBinaryNumber());
                    }
                    if (nc.getBase() == 10){
                        System.out.println("Number in Hexadecimal: " + nc.convertUniversal(16) + "\n");
                        System.out.println("Number in Octal: " + nc.displayOctalNumber());
                        System.out.println("Number in Binary: " + nc.displayBinaryNumber());
                    }
                    if (nc.getBase() == 16){
                        System.out.println("Number in Decimal: " + nc.displayDecalNumber());
                        System.out.println("Number in Octal: " + nc.displayOctalNumber());
                        System.out.println("Number in Binary: " + nc.displayBinaryNumber());
                    }
                } else System.out.println("Invalid Input.");
            }

        }
        s.close();

    }
    //change in order to push
}

