
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Arrays;

public class dz2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Выбор задания (1 2): ");
    int input_w = sc.nextInt();
    switch (input_w) {
      case (1):
        int[] mas = { 11, 3, 14, 16, 7 };

        boolean isSorted = false;
        int buf;
        try {
          FileWriter writer = new FileWriter("file.txt");
          while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < mas.length - 1; i++) {
              if (mas[i] > mas[i + 1]) {
                isSorted = false;

                buf = mas[i];
                mas[i] = mas[i + 1];
                mas[i + 1] = buf;
                String str = Arrays.toString(mas);
                writer.write(str);
                writer.write("\n");
              }
            }
          }
          System.out.println(Arrays.toString(mas));
          System.out.println("Получилось!");
          writer.close();
        } catch (Exception e) {
          System.out.println("Что-то пошло не так");
        }

        break;
      case (2):
        String text = "{\"name\":\"Ivanov\", \"country\":\"null\", \"city\":\"Moscow\", \"age\":\"20\"}";
        // String text = "{\"name\":\"Ivanov\", \"country\":\"Russia\",
        // \"city\":\"Moscow\", \"age\":\"null\"}";
        // String text = "{\"name\":\"null\", \"country\":\"Russia\",
        // \"city\":\"Moscow\", \"age\":\"20\"}";

        String text1 = text.substring(1, text.length() - 1);

        String[] keyWithVal = text1.split(", ");

        StringBuilder res = new StringBuilder();
        boolean flag = true;

        for (String item : keyWithVal) {
          String[] keyValue = item.split(":");
          String key = keyValue[0].replace("\"", "");
          String value = keyValue[1].replace("\"", "");

          if (!value.equalsIgnoreCase("null")) {
            if (flag == false)
              res.append(" AND ");
            res.append(key).append("=").append(value);
            flag = false;
          }
        }

        String sql = "SELECT * FROM students WHERE " + res.toString();
        System.out.println(sql);
        break;
      default:
        break;
    }
  }
}
