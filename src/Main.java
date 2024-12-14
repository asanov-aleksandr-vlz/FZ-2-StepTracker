
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker(scanner);

        label:
        while (true) {
            printMenu();

            int cmd = scanner.nextInt();
            switch (cmd) {
                case 1:
                    tracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    tracker.changeStepGoal();
                    break;
                case 3:
                    tracker.printStatistic();
                    break;
                case 4:
                    System.out.println("Программа завершена. Хорошего дня!");
                    break label;
                default:
                    System.out.println("Такой команды нет!");
                    break;
            }
            System.out.println();
            System.out.println("-".repeat(20));
            System.out.println();
        }
    }

    static void printMenu() {
        System.out.println("Введите код команды:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
    }
}