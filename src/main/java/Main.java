import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class WiseSaying {
        int id;
        String name;
        String content;

        WiseSaying(int id, String name, String content) {
            this.id = id;
            this.name = name;
            this.content = content;
        }


    }

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);

        int cnt = 1;
        ArrayList<WiseSaying> wiseList = new ArrayList<WiseSaying>();

        label:
        while (true) {
            System.out.print("명령) ");

            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "종료":
                    break label;
                case "등록":
                    int id = cnt;
                    String name;
                    String content;

                    System.out.print("명언 : ");
                    content = sc.nextLine();

                    System.out.print("작가 : ");
                    name = sc.nextLine();

                    wiseList.add(new WiseSaying(id, name, content));

                    System.out.printf("%d번 명언이 등록되었습니다.\n", cnt++);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    for (int i = wiseList.size() - 1; i >= 0; i--) {
                        System.out.printf("%d / %s / %s\n", wiseList.get(i).id, wiseList.get(i).name, wiseList.get(i).content);
                    }
                    break;
                case "삭제":
                    System.out.print("?id=");
                    int removeId = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < wiseList.size(); i++) {
                        if (removeId == wiseList.get(i).id) {
                            wiseList.remove(i);
                            System.out.printf("%d번 명언이 삭제되었습니다.\n", removeId);
                        }
                    }
                    break;
            }
        }
    }
}
