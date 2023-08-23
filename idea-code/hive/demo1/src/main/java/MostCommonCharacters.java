import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostCommonCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String input = scanner.nextLine().trim();
        scanner.close();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        int maxCount = 0;
        for (int count : charCount.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        StringBuilder mostCommonChars = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostCommonChars.append("'").append(entry.getKey()).append("' ");
            }
        }
        if (mostCommonChars.length() == 1) {
            System.out.printf("出现次数最多的字符是 %s，出现了%d次。\n", mostCommonChars.toString(), maxCount);
        } else {
            System.out.printf("出现次数最多的字符是 %s，出现了%d次。\n", mostCommonChars.toString(), maxCount);
        }
    }
}
