package FinancialForecasting;

/**
 * ForecastCalculator uses recursion to calculate future value
 * based on past data and a constant growth rate.
 */
public class ForecastCalculator {

    /**
     * Recursive method to calculate future value.
     * @param currentValue Current year's value
     * @param growthRate Annual growth rate (e.g., 0.10 for 10%)
     * @param years Number of years into the future
     * @return Forecasted value after given years
     */
    public static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return forecast(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    /**
     * Optimized version using memoization to avoid recomputation.
     */
    public static double forecastMemo(double currentValue, double growthRate, int years, double[] dp) {
        if (years == 0) {
            return currentValue;
        }
        if (dp[years] != 0) return dp[years];

        dp[years] = forecastMemo(currentValue, growthRate, years - 1, dp) * (1 + growthRate);
        return dp[years];
    }
}
