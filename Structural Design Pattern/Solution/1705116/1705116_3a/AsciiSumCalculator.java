import java.io.*;

public class AsciiSumCalculator implements  AdvancedSumCalculator{
    @Override
    public int calculateAsciiSum(String fileName) {

        int sum=0;
        try {
            File f=new File(fileName);
            BufferedReader br  = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            int value;
            while ((value = br.read()) != -1)
            {
                if(value != 32)
                {
                    sum=sum+value;
                }
            }
            br.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return sum;
    }
}
