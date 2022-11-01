import java.io.*;

import java.util.Scanner;

public class SumCalculator implements BasicSumCalculator {
    SumCalculatorAdapter adapter;
    @Override
    public int CalculateSum(String fileType, String fileName) {

        if(fileType.equalsIgnoreCase("decimal"))
        {
            int sum=0;
            try {
                File f=new File(fileName);
                Scanner scr=new Scanner(f);
                while (scr.hasNextInt())
                {
                    int value=scr.nextInt();
                    sum = sum +value;
                }

            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return sum;
        }
        else if(fileType.equalsIgnoreCase("ascii"))
        {
            adapter=new SumCalculatorAdapter(fileType);
            return adapter.CalculateSum(fileType,fileName);
        }
        else
        {
            System.out.println("Invalid File: "+fileType +"format not supported");
            return  0;
        }

    }
}
