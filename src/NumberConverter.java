import java.util.Arrays;
public class NumberConverter {
    String[] digits;
    int base;
    final static String charData = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

    public NumberConverter(String number, int base) {
        String numberAsString = number;
        digits = new String[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            digits[i] = numberAsString.substring(i,i+1);
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int value = 0;
        int[] output;
        for (int i = 0; i < digits.length; i++) {
                value += charData.indexOf(digits[i]) * Math.pow(base, digits.length-(i+1));
        }
        output = new int[Integer.toString(value).length()];
        for (int i = 0; i < output.length; i++) {
            output[i] = Integer.parseInt(Integer.toString(value).substring(i, i+1));
        }
        return output;
    }


    public static boolean isValid(int base, String input) {
        String key = charData.substring(0, base);
        for (int i = 0; i < input.length(); i++) {
            if (!key.contains(input.substring(i, i+1))) {
                return false;
            }
        }
        return true;

    }

    public int getBase() {
        return base;
    }


    public String convertUniversal(int base) {
        String result = "";
        int temp = Integer.parseInt(stupidArrayToString(convertToDecimal()));
        int e = 1;
        while (Math.pow(base, e) <= temp) {
            e++;
        }
        for (int t = 0; t < e; t++) {
            if (Math.pow(base,e-t-1) <= temp) {
                result +=  charData.substring(((int) (temp / Math.pow(base,e-t-1))), ((int) (temp / Math.pow(base,e-t-1)))+1);
                temp = (int) (temp % Math.pow(base,e-t-1));
            } else {
                result += "0";
            }
        }
        return result;
    }
    public String stupidArrayToString(int[] array) {
        String output = "";
        for (int i = 0; i < array.length; i++) {
            output += array[i];
        }
        return output;
    }
    //change in order to push
}

