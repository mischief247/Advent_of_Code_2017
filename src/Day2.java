import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        File inputText = new File(System.getProperty("user.dir") + "/src/input/D2P1.txt");
        int output = 0;
        try {
            sc = new Scanner(inputText);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        int checkSum =0;
        while(sc.hasNextLine()){
            String row = sc.nextLine();
            int[] values = Arrays.stream(row.split(" ")).mapToInt(Integer::parseInt).toArray();//i don't like it but its faster than the alternative
            Arrays.sort(values);
            output += getCalculation(values);
            checkSum+= (values[values.length-1]- values[0]);
        }
        System.out.println(checkSum);
        System.out.println(output);
    }
    private static int getCalculation(int[] input){
        int output =0;
        //for loops to iterate and check everything for even division
        for(int i = input.length-1;i>-1;i--){
            for(int k = i-1; k>-1; k--){
                if(input[i]%input[k]==0) {

                    output = input[i] / input[k];
                }
            }

        }
        System.out.println(output);
        return output;
    }
}
