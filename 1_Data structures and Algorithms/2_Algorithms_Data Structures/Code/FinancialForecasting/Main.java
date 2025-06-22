package FinancialForecasting;

public class Main {
    public static void main(String[] args) {
        double currentValue = 1000.0;    // Initial amount
        double growthRate = 0.10;        // 10% annual growth
        int years = 5;                   // Forecast for 5 years

        // Basic Recursive Forecast
        double forecastedValue = ForecastCalculator.forecast(currentValue, growthRate, years);
        System.out.println("Recursive Forecasted Value after " + years + " years: " + forecastedValue);

        // Optimized Recursive Forecast (Memoized)
        double[] dp = new double[years + 1];
        double memoForecast = ForecastCalculator.forecastMemo(currentValue, growthRate, years, dp);
        System.out.println("Memoized Forecasted Value after " + years + " years: " + memoForecast);
    }
}
