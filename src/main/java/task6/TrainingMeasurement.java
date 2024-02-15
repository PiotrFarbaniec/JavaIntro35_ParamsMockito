package task6;

public class TrainingMeasurement {
    private  int trainingTime;
    private  double calories;
    private int bitsPerMin;


    public TrainingMeasurement(int trainingTime, double calories, int bitsPerMin) {
        this.trainingTime = trainingTime;
        this.calories = calories;
        this.bitsPerMin = bitsPerMin;
    }

    public int getTrainingTimeEvaluation() {
        int rating = 0;
        if (trainingTime < 0) {
            throw new IllegalArgumentException("Invalid parameter entered");
        }
        if (trainingTime >= 0 && trainingTime < 30) {
            rating = 1;
        }
        else if (trainingTime >= 30 && trainingTime <= 60) {
            rating = 2;
        }
        else if (trainingTime > 60) {
            rating = 3;
        }
        return rating;
    }

    public int getCalorieBurnEvaluation () {
        int rating = 0;

        if (calories < 0) {
            throw new IllegalArgumentException("Invalid parameter entered");
        }
        if (calories >= 0 && calories <= 300) {
            rating = 1;
        }
        else if (calories > 300 && calories < 400) {
            rating = 2;
        }
        else if (calories >= 400) {
            rating = 3;
        }
        return rating;
    }

    public int getHeartRateEvaluation () {
        int rating = 0;

        if (bitsPerMin <= 0){
            throw new IllegalArgumentException("Invalid parameter entered");
        }
        if (bitsPerMin > 0 && bitsPerMin < 160) {
            rating = 3;
        }
        else if (bitsPerMin >= 160 && bitsPerMin <= 175) {
            rating = 2;
        }
        else if ( bitsPerMin > 175) {
            rating = 1;
        }
        return rating;
    }

    public Ratings getAverageTrainingRating() {
        Ratings rating = null;
        double average = (double) (getTrainingTimeEvaluation()
                + getCalorieBurnEvaluation()
                + getHeartRateEvaluation())/3;
        if (average >= 1 && average < 1.2) {
            rating = Ratings.LOW;
        }
        else if (average >= 1.2 && average < 2) {
            rating = Ratings.GOOD;
        }
        else if (average >= 2 && average < 3 ) {
            rating = Ratings.VERY_GOOD;
        }
        else if (average >= 3) {
            rating = Ratings.EXCELLENT;
        }
        return rating;
    }
}