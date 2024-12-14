public class Converter {
    double stepLength = 0.75;
    int caloriesByStep = 50;

    int convertToKm(int steps) {
        return (int) (steps * stepLength / 1000);
    }

    int convertStepsToKilocalories(int steps) {
        return steps * caloriesByStep/1000;
    }
}

