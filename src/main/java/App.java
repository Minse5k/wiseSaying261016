import java.util.Scanner;

public class App {
    int idNum = 1;
    Scanner sc = new Scanner(System.in);


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

    String inputContent() {
        System.out.print("명언 : ");
        return sc.nextLine();
    }

    String inputName() {
        System.out.print("작가 : ");
        return sc.nextLine();
    }

    void addWise(String content, String name, WiseSaying[] wisArr) {
        System.out.println(idNum + "번 명언이 등록되었습니다.");

        wisArr[idNum -1] = new WiseSaying(idNum, content, name);

        idNum += 1;
    }

    void printWise(WiseSaying[] wisArr) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = idNum-2; i >= 0; i--) {
            if(wisArr[i] == null) continue;
            System.out.println(wisArr[i].id + " / " + wisArr[i].name + " / " + wisArr[i].content);
        }
    }

    void deleteWise(WiseSaying[] wiseArr) {
        System.out.print("?id=");
        int idx = Integer.parseInt(sc.nextLine());

        if(wiseArr[idx - 1] != null) {
            wiseArr[idx - 1] = null;
            System.out.println(idx + "번 명언이 삭제되었습니다.");
        }
    }

    void run() {

        System.out.println("== 명언 앱 ==");

        boolean isFinish = true;
        WiseSaying[] wisArr = new WiseSaying[100];

        while (isFinish) {
            System.out.print("명령) ");

            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록":
                    addWise(inputContent(), inputName(), wisArr);
                    break;
                case "종료":
                    System.out.println("종료");
                    isFinish = false;
                    break;
                case "목록":
                    printWise(wisArr);
                    break;
                case "삭제":
                    deleteWise(wisArr);
                    break;
            }
        }
        sc.close();
    }
}


