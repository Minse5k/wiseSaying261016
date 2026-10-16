import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");

        String cmd = sc.nextLine();

        if(cmd.equals("종료")) {
            System.out.println("종료");
        }
    }
}
