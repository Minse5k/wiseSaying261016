import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

        public WiseSaying() {
            this.id = 0;
            this.content = "";
            this.name = "";
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

    void addWise(String content, String name) throws IOException{
        System.out.println(idNum + "번 명언이 등록되었습니다.");

        wiseArr[idNum - 1] = new WiseSaying(idNum, content, name);

        saveWiseSaying(wiseArr[idNum-1]);

        idNum += 1;
    }

    void printWise() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = 99; i >= 0; i--) {
            if (wiseArr[i] == null) continue;
            System.out.println(wiseArr[i].id + " / " + wiseArr[i].name + " / " + wiseArr[i].content);
        }
    }

    void deleteWise() {
        System.out.print("?id=");
        int idx = Integer.parseInt(sc.nextLine());

        if (wiseArr[idx - 1] != null) {
            wiseArr[idx - 1] = null;
            System.out.println(idx + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(idx + "번 명언은 존재하지 않습니다.");
        }
    }

    void editWise() throws IOException{
        System.out.print("?id=");
        int idx = Integer.parseInt(sc.nextLine());
        WiseSaying wise = wiseArr[idx-1];

        if (wise == null) {
            System.out.println(idx + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println("명언(기존) : " + wise.content);
        wise.content = inputContent();

        System.out.println("작가(기존) : " + wise.name);
        wise.name = inputName();

        saveWiseSaying(wise);

    }

    void saveWiseSaying(WiseSaying wise) throws IOException {
        Path path = Path.of("db/wiseSaying/" + wise.id +  ".json");

        String json = """
                {
                "id": %d,
                "content": "%s",
                "name": "%s"
                }
                """.formatted(wise.id, wise.content, wise.name);

        Files.writeString(path, json);
    }

    void setWiseArr() throws IOException{
        for(int i=1; i<=100; i++) {
            Path path = Path.of("db/wiseSaying/" + i + ".json");

            if(!Files.exists(path)) continue;

            String[] json = Files.readString(path).split(",");


            wiseArr[i-1] = new WiseSaying(parseJsonId(json[0]), parseJsonContent(json[1]), parseJsonText(json[2]));
        }
    }

    int parseJsonId(String jsonLine) {
        String[] parts = jsonLine.split(":");
        return Integer.parseInt(parts[1].trim());
    }

    String parseJsonContent(String jsonLine) {
        String[] parts = jsonLine.split(":");
        return parts[1].trim().substring(1, parts[1].length()-2);
    }

    String parseJsonText(String jsonLine) {
        String[] parts = jsonLine.split(":");
        return parts[1].trim().substring(1, parts[1].length()-5);
    }

    void run() throws IOException{

        System.out.println("== 명언 앱 ==");

        boolean isFinish = false;

        setWiseArr();

        while (!isFinish) {
            System.out.print("명령) ");

            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록":
                    addWise(inputContent(), inputName());
                    break;
                case "종료":
                    System.out.println("종료");
                    isFinish = true;
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


