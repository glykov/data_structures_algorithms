import java.util.Scanner;

public class PowerApp {
    // обычное рекурсивное возведение в степень
    public static int simplePower(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * simplePower(base, exponent - 1);
    }

    // быстрое рекурсивное возведение в степень
    public static int quickPower(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent % 2 == 0) {
            return quickPower(base * base, exponent / 2);
        } else {
            return base * quickPower(base, exponent - 1);
        }
    }

    public static void main(String[] args) {
        int base;
        int exponent;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter base: ");
        base = in.nextInt();
        System.out.print("Enter exponent: ");
        exponent = in.nextInt();

        System.out.println("Power is: " + quickPower(base, exponent));
    }
}
