import java.util.Scanner;

public class Main1 {
    private static int idNum = 1;

    private static String inputContent(Scanner sc) {
        System.out.print("명언 : ");
        return sc.nextLine();
    }

    private static String inputName(Scanner sc) {
        System.out.print("작가 : ");
        return sc.nextLine();
    }

    private static void addWise(String content, String Name) {
        System.out.println(idNum + "번 명언이 등록되었습니다.");
        idNum += 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");


        boolean isFinish = true;

        while (isFinish) {
            System.out.print("명령) ");

            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록":
                    addWise(inputContent(sc), inputName(sc));
                    break;
                case "종료":
                    System.out.println("종료");
                    isFinish = false;
                    break;
            }
        }
    }
}
