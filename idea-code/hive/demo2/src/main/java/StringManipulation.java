import java.util.Scanner;

public class StringManipulation {
    public static String reverseString(String input) {
        char[] charArray = input.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要反转的字符串: ");
        String inputString = scanner.nextLine();
        String reversed = reverseString(inputString);
        System.out.println("输入的字符串: " + inputString);
        System.out.println("反转字符串为: " + reversed);
        scanner.close();
    }
}
