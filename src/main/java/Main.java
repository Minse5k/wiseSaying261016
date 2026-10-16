import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);

        int cnt = 1;

        while (true) {
            System.out.print("명령) ");

            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                sc.nextLine();

                System.out.print("작가 : ");
                sc.nextLine();

                System.out.printf("%d번 명언이 등록되었습니다.\n", cnt++);
            }
        }
    }
}
