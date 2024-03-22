import java.util.*;
import java.util.function.*;

public class Calc {
    private static final List<String> romans = List.of(
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    );

    private static final Map<String, IntBinaryOperator> operations = Map.of(
            "+", Integer::sum,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    public static void main(String[] args) {
        System.out.println("Введите выражение чисел от 1 - 10 (например, V * V или 5 + 5):");
        System.out.println(calc(new Scanner(System.in).nextLine()));
    }

    public static String calc(String input) {
        String[] parts = input.split("\\s", 3);

        if (parts[0].matches("[1-9]|10") && parts[2].matches("[1-9]|10")) {
            int result = operations.get(parts[1]).applyAsInt(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]));
            return "Ответ: " + result;
        } else if (romans.contains(parts[0]) && romans.contains(parts[2]) && romans.indexOf(parts[0]) <= 10 && romans.indexOf(parts[2]) <= 10) {
            int index1 = romans.indexOf(parts[0]) + 1;
            int index2 = romans.indexOf(parts[2]) + 1;
            int result = operations.get(parts[1]).applyAsInt(index1, index2) - 1;
            return "Ответ: " + romans.get(result);
        } else {
            return "Ответ: " + romans.get(romans.indexOf("."));
        }
    }
}