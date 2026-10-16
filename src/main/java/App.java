import java.util.Scanner;

public class App {
    int idNum = 1;
    Scanner sc = new Scanner(System.in);
    WiseSaying[] wiseArr = new WiseSaying[100];


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

    void addWise(String content, String name) {
        System.out.println(idNum + "번 명언이 등록되었습니다.");

        wiseArr[idNum -1] = new WiseSaying(idNum, content, name);

        idNum += 1;
    }

    void printWise() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = idNum-2; i >= 0; i--) {
            if(wiseArr[i] == null) continue;
            System.out.println(wiseArr[i].id + " / " + wiseArr[i].name + " / " + wiseArr[i].content);
        }
    }

    void deleteWise() {
        System.out.print("?id=");
        int idx = Integer.parseInt(sc.nextLine());

        if(wiseArr[idx - 1] != null) {
            wiseArr[idx - 1] = null;
            System.out.println(idx + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(idx + "번 명언은 존재하지 않습니다.");
        }
    }

    void editWise() {
        System.out.print("?id=");
        int idx = Integer.parseInt(sc.nextLine());

        if(wiseArr[idx-1] == null) {
            System.out.println(idx + "번 명언은 존재하지 않습니다.");
            return;
        } else {
            System.out.println("명언(기존) : " + wiseArr[idx-1].content);
            System.out.print("명언 : ");
            wiseArr[idx-1].content = sc.nextLine();

            System.out.println("작가(기존) : " + wiseArr[idx-1].name);
            System.out.print("작가 : ");
            wiseArr[idx-1].name = sc.nextLine();
        }
    }

    void run() {

        System.out.println("== 명언 앱 ==");

        boolean isFinish = true;

        while (isFinish) {
            System.out.print("명령) ");

            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록":
                    addWise(inputContent(), inputName());
                    break;
                case "종료":
                    System.out.println("종료");
                    isFinish = false;
                    break;
                case "목록":
                    printWise();
                    break;
                case "삭제":
                    deleteWise();
                    break;
                case "수정":
                    editWise();
                    break;
            }
        }
        sc.close();
    }
}


