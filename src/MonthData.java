public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth(int ignoredMonth) {

        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + "-й день: " + days[i]);
        }
    }

    int sumStepsFromMonth(int ignoredMonth) {
        int sumSteps = 0;

        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    int maxSteps(int ignoredMonth) {
        int maxSteps = 0;

        for (int day : days) {
            if (maxSteps < day) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;

        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
