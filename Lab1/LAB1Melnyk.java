import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Клас реалізує програму для лабораторної роботи №1.
 * Програма генерує повну квадратну матрицю, заповнюючи її двома
 * символами згідно з варіантом №13 (вертикальні смуги), та виводить
 * результат в консоль і у файл.
 *
 * @author Melnyk
 * @version 1.0
 * @since 2025-09-20
 */
public class LAB1Melnyk { 

    /**
     * Головний метод програми (точка входу).
     *
     * @param args аргументи командного рядка (не використовуються).
     * @throws FileNotFoundException виняток, що може виникнути при роботі з файлами.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // --- Блок ініціалізації ---
        int matrixSize;
        char[][] arr;
        String fillerShaded; // Символ для заштрихованих областей
        String fillerEmpty;  // Символ для порожніх областей
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // --- Блок отримання даних від користувача ---
        System.out.print("Введіть розмір квадратної матриці: ");
        matrixSize = in.nextInt();
        in.nextLine(); // Очищення буфера після nextInt()

        // --- Створення повної квадратної матриці ---
        arr = new char[matrixSize][matrixSize];

        System.out.print("\nВведіть символ для заштрихованих смуг: ");
        fillerShaded = in.nextLine();

        System.out.print("Введіть символ для порожніх смуг: ");
        fillerEmpty = in.nextLine();

        // --- Перевірка символів-заповнювачів ---
        if (fillerShaded.length() != 1 || fillerEmpty.length() != 1) {
            System.out.println("\nПомилка: для кожного типу смуг має бути введено рівно один символ.");
            in.close();
            fout.close();
            return; // Завершуємо програму
        }

        char charShaded = fillerShaded.charAt(0);
        char charEmpty = fillerEmpty.charAt(0);

        // --- Заповнення та виведення масиву ---
        System.out.println("\nРезультат:");
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                // Головна логіка: перевіряємо індекс стовпця (j)
                // Якщо індекс парний (0, 2, 4...), це заштрихована смуга
                if (j % 2 == 0) {
                    arr[i][j] = charShaded;
                } else { // Інакше це порожня смуга
                    arr[i][j] = charEmpty;
                }
                
                // Виводимо поточний символ у консоль та у файл
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }
            System.out.println(); // Перехід на новий рядок в консолі
            fout.println();   // Перехід на новий рядок у файлі
        }

        // --- Завершення роботи ---
        System.out.println("\nМасив успішно записано у файл MyFile.txt");
        fout.close();
        in.close();
    }
}