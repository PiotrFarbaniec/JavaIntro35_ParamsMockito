package task7;


public class SalaryCalculator implements SalaryPayable, BonusPayable {
    private final double bonus;
    private double saturdaysBonus;
    private double basicSalary;
    public SalaryCalculator(double oneTimeBonus) {
        this.bonus = oneTimeBonus;
    }

    public double getTotalSalary() {
        basicSalary = getBasicSalaryAmount();
        saturdaysBonus = getBonusForSaturdays();
        return basicSalary + saturdaysBonus + bonus;
    }


    @Override
    public double getBasicSalaryAmount() {
        return 0;
    }

    @Override
    public double getBonusForSaturdays() {
        return 0;
    }
}