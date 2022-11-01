public class TestClass {

    public static void main(String[] args) {
        SumCalculator sumCalculator=new SumCalculator();
        int sum=sumCalculator.CalculateSum("decimal","src/decimal.txt");
        System.out.println("Sum for Integer Data = "+sum);
        sum=sumCalculator.CalculateSum("ascii","src/ascii.txt");
        System.out.println("Sum for Character Data = "+sum);
    }
}
