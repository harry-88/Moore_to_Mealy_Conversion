import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static Scanner input;
    static int numberOfStates;
    static String[] latter;
    static String startingState;
    static ArrayList<Moore> mooreArrayList;
    static ArrayList<Mealy> mealyArrayList;

    public static void displayMooreData()
    {
        System.out.print("Present State\t\t\tNew State\t\t\tOutput\n\t\t\t\t\t\t");
        for (int i = 0;i< latter.length;i++)
            System.out.print(latter[i]+"\t");
        System.out.println();
        for (int i = 0;i<mooreArrayList.size();i++)
        {
            System.out.print(mooreArrayList.get(i).getStartingState()+"\t\t\t\t\t\t");
            for (int j = 0;j < latter.length;j++)
                System.out.print(mooreArrayList.get(i).getEndingState()[j]+"\t");
            System.out.println("\t\t\t"+mooreArrayList.get(i).output);

        }
    }

    public static void displayMealyData()
    {
        System.out.print("Present State\t\t\tNew State\n\t\t\t\t\t\t");
        for (int i = 0;i< latter.length;i++)
            System.out.print(latter[i]+"\tOP\t");
        System.out.println();
        for (int i = 0;i<mealyArrayList.size();i++)
        {
            System.out.print(mealyArrayList.get(i).getStartingState()+"\t\t\t\t\t\t");
            for (int j = 0;j < latter.length;j++)
                System.out.print(mealyArrayList.get(i).getEndingState()[j]+"\t"+mealyArrayList.get(i).output[j]+"\t");
            System.out.println();

        }
    }
    public static boolean checkValidState(String state)//check the user entered a valid state
    {

        String line1 = "";
        for (int i = 0;i<numberOfStates;i++) {
            line1 = "q" + i;
            if (state.equals(line1)) {
                return true;
            }
        }
            return false;
    }
    public static void getMooreData()
    {

        System.out.println("the states are : ");
        for (int i = 0;i<numberOfStates;i++)
            System.out.print("q"+i+"\t");
        System.out.println();
        boolean checkValidity = false;
        String line;
        String end;
        for (int i = 0;i<numberOfStates;i++)
        {

                line = "q"+i;
                startingState = line;


            String[] endingState = new String[latter.length];
                    for (int j = 0;j< latter.length;j++)
                    {
                        System.out.println("enter ending state of "+ line+ " after reading "+ latter[j]);
                        end = input.next();
                        if (checkValidState(end))
                            endingState[j] = end;
                        else   System.out.println("you entered invalid state");
                    }
                    System.out.println("enter the output of the state "+line);
                    String output = input.next();
                    mooreArrayList.add(new Moore(startingState,endingState,output));


        }
    }

    public static void getMealyData()
    {

        System.out.println("the states are : ");
        for (int i = 0;i<numberOfStates;i++)
            System.out.print("q"+i+"\t");
        System.out.println();
        boolean checkValidity = false;
        String line;
        String end;
        for (int i = 0;i<numberOfStates;i++)
        {

            line = "q"+i;
            startingState = line;
            String[] output = new String[latter.length];


            String[] endingState = new String[latter.length];
            for (int j = 0;j< latter.length;j++)
            {
                System.out.println("enter ending state of "+ line+ " after reading "+ latter[j]);
                end = input.next();
                if (checkValidState(end)) {
                    endingState[j] = end;
                    System.out.println("enter the output of the state "+line);
                    output[j] = input.next();
                }
                else   System.out.println("you entered invalid state");
            }
            mealyArrayList.add(new Mealy(startingState,endingState,output));


        }
    }

    public static void convertToMealy()
    {

        for (int i = 0;i<numberOfStates;i++)
        {
            String[] endingState ;
            endingState = mooreArrayList.get(i).getEndingState();
            String[] output = new String[numberOfStates];

            for (int j = 0;j< latter.length;j++)
            {
                for (int k = 0;k<numberOfStates;k++)
                    if (endingState[j].equals(mooreArrayList.get(k).startingState))
                        output[j] = mooreArrayList.get(k).output;

            }
                mealyArrayList.add(new Mealy(mooreArrayList.get(i).startingState,endingState,output));

        }
        System.out.println("\n----------------------------------\n");
    }
    public static void main(String[] args) {
        mooreArrayList = new ArrayList<>();
        mealyArrayList = new ArrayList<>();
        input = new Scanner(System.in);
        System.out.println("Enter number of states you want to enter ");
        int i = input.nextInt();
        if (i<=0) {
            System.out.println("you have entered invalid number of states");
            return;
        }
        else {
            numberOfStates = i;
            System.out.println("enter latters seperate by comma like a,b ");
            String line = input.next();
            latter = line.split(",");


            System.out.println("Enter \n1-convert Moore  to Mealy ");
            i = input.nextInt();
            switch (i)
            {
                case 1:
                    getMooreData();

                    displayMooreData();
                    convertToMealy();
                    displayMealyData();

                    break;
                default:
                    break;
            }
        }
    }
}
