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
        List<Integer> liczbyList = new ArrayList<Integer>();
        List<Integer> dzielnikiList2 = new ArrayList<Integer>();
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
            liczbyList.add(currentNumber);
            int dzielniki = 0;
            int dzielnikiDistinct=0;
            for(int i = 2; i < Math.sqrt(Integer.parseInt(line)); i++) {
                if(currentNumber % i == 0) {
                    dzielnikiDistinct++;
                }
                while(currentNumber % i == 0) {
                    dzielniki++;
                    currentNumber /= i;
                }
            }
            dzielnikiList.add(dzielniki);
            dzielnikiList2.add(dzielnikiDistinct);



        }
        int maxIndex = 0;
        for(int i = 1; i < dzielnikiList.size(); i++) {
            if(dzielnikiList.get(i) > dzielnikiList.get(maxIndex)) {
                maxIndex = i;

            }
        }
        int maxIndex2 = 0;
        for(int i = 1; i < dzielnikiList2.size(); i++) {
            if(dzielnikiList2.get(i) > dzielnikiList2.get(maxIndex2)) {
                maxIndex2 = i;

            }
        }

        int trojkiLicznik = 0;
        System.out.println("Dobre trojki: ");

        for(int i = 0; i < liczbyList.size(); i++) {
            for(int j = 0; j < liczbyList.size(); j++) {
                for(int k = 0 ; k < liczbyList.size(); k++) {
                    int s = liczbyList.get(i);
                    int y = liczbyList.get(j);
                    int z = liczbyList.get(k);
                    if (s != y && y != z && s != z &&
                            y % s == 0 && z % y == 0) {
                        System.out.println(s + " " + y + " " + z);
                        trojkiLicznik++;
                    }
                }
            }
        }

        System.out.println("Dobre piątki: ");
        int piatkiLicznik = 0;

        for(int i =0; i < liczbyList.size(); i++) {
            int firstNumber = liczbyList.get(i);
            for(int j = 0; j < liczbyList.size(); j++) {
                int secondNumber = liczbyList.get(j);
                if(firstNumber ==secondNumber || secondNumber % firstNumber != 0)continue;
                for(int k = 0; k < liczbyList.size(); k++) {
                    int thirdNumber  = liczbyList.get(k);
                    if(firstNumber == thirdNumber || secondNumber == thirdNumber || thirdNumber % secondNumber != 0)continue;
                    for(int l = 0; l < liczbyList.size(); l++) {
                        int fourthNumber =  liczbyList.get(l);
                        if(firstNumber == fourthNumber || secondNumber == fourthNumber || thirdNumber == fourthNumber || fourthNumber % thirdNumber != 0)continue;
                        for(int m = 0; m < liczbyList.size(); m++) {
                            int fifthNumber =  liczbyList.get(m);
                            if(firstNumber == fifthNumber || secondNumber == fifthNumber || thirdNumber == fifthNumber || fourthNumber == fifthNumber || fifthNumber % fourthNumber != 0)continue;
                            System.out.println(firstNumber + " " + secondNumber + " " + thirdNumber + " " + fourthNumber + " " + fifthNumber);
                            piatkiLicznik++;
                        }
                    }
                }
            }
        }



        //zad 4.1 odp:
        System.out.println("zad4.1");
        System.out.println(answersList.get(0));
        System.out.println(x);

        //zad 4.2 odp:
        System.out.println("zad4.2");
        System.out.print("Liczba: ");
        System.out.println(liczbyList.get(maxIndex));
        System.out.print("liczba dzielnikow: ");
        System.out.println(dzielnikiList.get(maxIndex));

        System.out.print("Liczba: ");
        System.out.println(liczbyList.get(maxIndex2));
        System.out.print("liczba dzielnikow: ");
        System.out.println(dzielnikiList2.get(maxIndex2));

        //zad 4.3 odp:
        System.out.print("Liczba dobrych trojek: " + trojkiLicznik);
        System.out.println("Liczba dobrych piatek: " + piatkiLicznik);



    }
}