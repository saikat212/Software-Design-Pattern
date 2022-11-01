

public class SumCalculatorAdapter implements BasicSumCalculator {
    AdvancedSumCalculator advancedSumCalculator;
   public SumCalculatorAdapter(String fileType)
    {
        if(fileType.equalsIgnoreCase("ascii"))
        {
            advancedSumCalculator=new AsciiSumCalculator();
        }
    }

    @Override
    public int CalculateSum(String fileType, String fileName) {

       if(fileType.equalsIgnoreCase("ascii"))
       {
           return advancedSumCalculator.calculateAsciiSum(fileName);
       }
        return 0;
    }
}
