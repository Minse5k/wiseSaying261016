import java.util.Scanner;

public class Main1 {
    private static int idNum = 1;

    static class WiseSaying {
        int id;
        String content;
        String name;

        public WiseSaying(int id, String content, String name) {
            this.id = id;
            this.content = content;
            this.name = name;
        }
    }

    private static String inputContent(Scanner sc) {
        System.out.print("명언 : ");
        return sc.nextLine();
    }

    private static String inputName(Scanner sc) {
        System.out.print("작가 : ");
        return sc.nextLine();
    }

    private static void addWise(String content, String name, WiseSaying[] wisArr) {
        System.out.println(idNum + "번 명언이 등록되었습니다.");

        wisArr[idNum -1] = new WiseSaying(idNum, content, name);

        idNum += 1;
    }

    private static void printWise(WiseSaying[] wisArr) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = idNum-2; i >= 0; i--) {
            System.out.println(wisArr[i].id + " / " + wisArr[i].name + " / " + wisArr[i].content);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        boolean isFinish = true;
        WiseSaying[] wisArr = new WiseSaying[100];

        while (isFinish) {
            System.out.print("명령) ");

            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록":
                    addWise(inputContent(sc), inputName(sc), wisArr);
                    break;
                case "종료":
                    System.out.println("종료");
                    isFinish = false;
                    break;
                case "목록":
                    printWise(wisArr);
                    break;
            }
        }
    }
}
