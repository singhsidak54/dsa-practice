package ps1;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int total = 0, minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE;

        for(int sal : salary) {
            total += sal;
            minimum = Math.min(minimum, sal);
            maximum = Math.max(maximum, sal);
        }

        return (double) (total - maximum - minimum)/(salary.length - 2);
    }
}
