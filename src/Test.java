import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[] test = { "5", "10", "15" };
        int i = Arrays.asList(test).indexOf("15");
        System.out.println(i);
    }
}
