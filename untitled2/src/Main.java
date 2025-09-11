import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws java.io.IOException {

        LineNumberReader lnr = new LineNumberReader(new FileReader("przyklad.txt"));
        List<String> answersList = new ArrayList<String>();
        List<Integer> dzielnikiList = new ArrayList<Integer>();
        String line;
        int x = 0;
        while ((line = lnr.readLine()) != null) {
            int firstNumber = Integer.parseInt(line.split("")[0]);
            int secondNumber = Integer.parseInt(line.split("")[line.length() - 1]);
            if (firstNumber == secondNumber) {
                answersList.add(line);
                x++;
            }
            int currentNumber = Integer.parseInt(line);
            int dzielniki = 0;
            for(int i = 2; i < Math.sqrt(Integer.parseInt(line)); i++) {
                while(currentNumber % i == 0) {
                    dzielniki++;
                    currentNumber /= i;
                }
            }
            dzielnikiList.add(dzielniki);
        }


        //zad 4 odp:
        System.out.println(answersList.get(0));

        //zad 4.1 odp:
        System.out.println(x);

        //zad 4.2 odp:
        Collections.sort(dzielnikiList);
        System.out.println(dzielnikiList.get(dzielnikiList.size()-1));

    }
}