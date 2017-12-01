import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Problem1 {
    public static void main(String[] args) {
        //grab the file
        File f = new File(System.getProperty("user.dir") + "/src/input/D1P1.txt");
        Scanner sc = new Scanner(System.in);
        //sanity check the file;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //get the file data
        String input = sc.nextLine();
        int total = 0;
        int total2 = 0;
        char[] temp = input.toCharArray();
        int halfList = temp.length / 2;
        for (int i = 0; i < temp.length - 1; i++) {

            if (temp[i] == temp[i + 1]) {
                total += Character.getNumericValue(temp[i]);
            }
            //handle the looping behavior of the list
            if (i + 1 == temp.length - 1 && temp[i + 1] == temp[0]) {
                total += Character.getNumericValue(temp[i + 1]);
            }
            if (i + halfList < temp.length && temp[i] == temp[i + halfList]) {
                total2 += Character.getNumericValue(temp[i]) * 2;
            }
        }
        System.out.println("solution 1: " + total);
        System.out.println("solution 2: " + total2);
    }
}
