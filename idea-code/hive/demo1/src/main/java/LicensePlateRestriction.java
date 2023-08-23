import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class LicensePlateRestriction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入车牌号：");
        String plateNumber = scanner.nextLine().trim().toUpperCase();
        char lastChar = plateNumber.charAt(plateNumber.length() - 1);
        if (!Character.isLetterOrDigit(lastChar)) {
            System.out.println("车牌号最后一位不是字母或数字。");
            return;
        }
        while (Character.isLetter(lastChar)) {
            if (plateNumber.length() == 1) {
                System.out.println("前4位只能有1位是英文字母");
                return;
            }
            plateNumber = plateNumber.substring(0, plateNumber.length() - 1);
            lastChar = plateNumber.charAt(plateNumber.length() - 1);
        }
        int lastDigit = Character.getNumericValue(lastChar);
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                if (lastDigit == 1 || lastDigit == 6) {
                    System.out.println("今天限行！");
                } else {
                    System.out.println("今天不限行。");
                }
                break;
            case TUESDAY:
                if (lastDigit == 2 || lastDigit == 7) {
                    System.out.println("今天限行！");
                } else {
                    System.out.println("今天不限行。");
                }
                break;
            case WEDNESDAY:
                if (lastDigit == 3 || lastDigit == 8) {
                    System.out.println("今天限行！");
                } else {
                    System.out.println("今天不限行。");
                }
                break;
            case THURSDAY:
                if (lastDigit == 4 || lastDigit == 9) {
                    System.out.println("今天限行！");
                } else {
                    System.out.println("今天不限行。");
                }
                break;
            case FRIDAY:
                if (lastDigit == 5 || lastDigit == 0) {
                    System.out.println("今天限行！");
                } else {
                    System.out.println("今天不限行。");
                }
                break;
            default:
                System.out.println("今天不限行。");
                break;
        }
    }
}
