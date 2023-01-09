public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
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

    public String displayDecalNumber() {
        String o = "";
        for (int i = 0; i < convertToDecimal().length; i++) {
            o = o + convertToDecimal()[i];
        }
        o = o + "\n";
        return o;
    }

    public String displayBinaryNumber() {
        String o = "";
        for (int i = 0; i < convertToBinary().length; i++) {
            o = o + convertToBinary()[i];
        }
        o = o + "\n";
        return o;
    }

    public String displayOctalNumber() {
        String o = "";
        for (int i = 0; i < convertToOctal().length; i++) {
            o = o + convertToOctal()[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int value = 0;
        int[] output;
        for (int i = 0; i < digits.length; i++) {
                value += digits[i] * Math.pow(base, digits.length-(i+1));
        }
        output = new int[Integer.toString(value).length()];
        for (int i = 0; i < output.length; i++) {
            output[i] = Integer.parseInt(Integer.toString(value).substring(i, i+1));
        }
        return output;
    }

    public int[] convertToBinary() {
        int[] output;
        String result = "";
        int temp = Integer.parseInt(stupidArrayToString(convertToDecimal()));
            int e = 0;
            while (Math.pow(2, e)*2-1 < temp) {
                e++;
            }
            e++;
            for (int t = 0; t < e; t++) {
                if (Math.pow(2,e-t-1) <= temp) {
                    result += "1";
                    temp -= Math.pow(2,e-t-1);
                } else result += "0";
            }
        output = new int[result.length()];
        for (int i = 0; i < result.length(); i++) {
            output[i] = Integer.parseInt(result.substring(i , i+1));
        }
        return output;
    }

    public int[] convertToOctal() {
        int[] output;
        String result = "";
        boolean checker = false;
        int temp = Integer.parseInt(stupidArrayToString(convertToDecimal()));
            int e = 1;
            while (Math.pow(8, e)*8-1 < temp) {
                e++;
            }
            e++;
            for (int t = 0; t < e; t++) {
                for (int g = 7; g > 0; g--) {
                    if (Math.pow(8,e-t-1) * g <= temp) {
                        result += "" + g;
                        temp -= Math.pow(8,e-t-1) * g;
                        checker = true;
                    }
                    if (checker == false) {
                        result += "0";
                    }
                    checker = true;
                }
            }
            if (result.substring(0, 1).equals("0")) {
                result = result.substring(1);
            }
        output = new int[result.length()];
        for (int i = 0; i < result.length(); i++) {
            output[i] = Integer.parseInt(result.substring(i , i+1));
        }
        return output;
    }

    public String stupidArrayToString(int[] array) {
        String output = "";
        for (int i = 0; i < array.length; i++) {
            output += array[i];
        }
        return output;
    }
}

