import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final String FILE_PATH = "IN.txt";
        final int DISTANCE = 10;

        int answer = 0;

        ArrayList<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        for (int i = 1; i < DISTANCE; i++) {
            numbers.set(i, Math.max(numbers.get(i), numbers.get(i - 1)));
        }
        for (int i = DISTANCE; i < numbers.size(); i++) {
            int n1 = numbers.get(i);
            int n2 = numbers.get(i - DISTANCE);
            if (n1 * n1 + n2 * n2 > answer) answer = n1 * n1 + n2 * n2;
            numbers.set(i, Math.max(numbers.get(i), numbers.get(i - 1)));
        }
        System.out.println("Максимальная сумма квадратов чисел: " + answer);
    }
}