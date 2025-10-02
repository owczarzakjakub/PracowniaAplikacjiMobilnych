import javax.print.attribute.standard.NumberOfDocuments;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        boolean isValid = true;

        while (isValid) {
            Scanner readNumberOfThrows = new Scanner(System.in);
            int NumberOfThrows;
            do {
                System.out.print("Ile kostek chcesz rzucic?(3-10): ");
                NumberOfThrows = readNumberOfThrows.nextInt();

            }while(NumberOfThrows < 3 || NumberOfThrows > 10);

            int throwsCounter = 1;
            ArrayList<Integer> stitches = new ArrayList<>();

            while(NumberOfThrows > 0){
                Random rand = new Random();
                int max = 6, min = 1;
                int stitchesNumber = rand.nextInt(max - min + 1) + min;
                System.out.println("Kostka " + throwsCounter + ": " + stitchesNumber );
                stitches.add(stitchesNumber);
                throwsCounter++;
                NumberOfThrows--;
            }
            int score = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < stitches.size(); i++){
                for(int j = 0; j < stitches.size(); j++){
                    if(i == j){
                        continue;
                    }
                    if(stitches.get(i) == stitches.get(j)) {
                        arr.add(stitches.get(i));
                    }
                }
                if(arr.size() > 1){
                    for(int k = 0; k < arr.size(); k++){
                        score = score + arr.get(k);
                    }
                }
                arr.clear();
            }

            System.out.println("wynik: " + score);
            System.out.print("Czy chcesz zagrac jeszcze raz? (t/n): ");
            Scanner playAgain =  new Scanner(System.in);
            String userChoice =  playAgain.nextLine();
            if(userChoice.equals("n")){
                isValid = false;
            }
            else if(userChoice.equals("t")){
                isValid = true;
            }
            else{
                isValid = false;
            }
        }



    }
}