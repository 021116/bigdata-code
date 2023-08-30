import java.util.Random;
import java.util.Scanner;

public class RandomStringGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    public static String generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入随机字符串的长度: ");
        int desiredLength = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String randomString = generateRandomString(desiredLength);
        System.out.println("随机字符串(长度 " + desiredLength + "): " + randomString);

        scanner.close();
    }
}
