import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        System.out.println("1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь,\n" +
                "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Месяц должен быть от 1 до 12, а у вас: " + month);
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("День должен быть от 1 до 30 включительно, а у вас: " + day);
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Количество шагов не может быть отрицательным, а у вас: " + steps);
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
        System.out.println("Данные сохранены.");
    }

    void changeStepGoal() {
        System.out.print("Введите новую цель по шагам на день: ");
        int newGoal = scanner.nextInt();
        if (newGoal <= 0) {
            System.out.println("Цель должна быть больше нуля, а у вас: " + newGoal);
        } else {
            goalByStepsPerDay = newGoal;
            System.out.println("Цель по шагам на день изменена на: " + goalByStepsPerDay);
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        System.out.println("1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь,\n" +
                "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Месяц должен быть от 1 до 12, а у вас: " + month);
            return;
        }
        MonthData monthData = monthToData[month - 1];
        int maxSteps = monthData.maxSteps(month);
        int sumSteps = monthData.sumStepsFromMonth(month);
        int averageSteps = sumSteps / 30;
        int distance = converter.convertToKm(sumSteps);
        int caloriesBurned = converter.convertStepsToKilocalories(sumSteps);
        System.out.println("Статистика за " + month + "-й месяц:");
        monthData.printDaysAndStepsFromMonth(month);
        System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth(month));
        System.out.println("Максимальное пройденное количество шагов за месяц: " + maxSteps);
        System.out.println("Среднее количество шагов: " + averageSteps);
        System.out.println("Пройденная дистанция (в км): " + distance);
        System.out.println("Количество сожженных килокалорий: " + caloriesBurned);
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }

}
