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

    public String displayOctalNumber() {
        String o = "";
        for (int i = 0; i < convertToDecimal().length; i++) {
            o = o + convertToDecimal()[i];
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
        if (base == 8) {
            for (int i = 0; i < convertToDecimal().length; i++) {
                int temp;
                String convert = "";
                convert += convertToDecimal()[i];
                temp = Integer.parseInt(convert);
                int e = 0;
                while (Math.pow(2, e) < temp) {
                    e++;
                }
            }
        }
        else if (base == 10) {

        } else if (base == 2) return digits;
    }

    public int[] convertToOctal() {
        return null;
    }
}

