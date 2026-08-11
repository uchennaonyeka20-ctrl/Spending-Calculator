//importing java scanner for input
import java.util.Scanner;

public class Main{
    //instance variable declaration
    double income;
    double expense;
    String spending = "";
    String Advice = "";


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main main = new Main();

            //Conditional to handle reprompt
        do{
            //User input
            System.out.print("Enter monthly income($): ");
            main.income = sc.nextDouble();

            System.out.print("Enter one expense($): ");
            main.expense = sc.nextDouble();

            //Validating positive inputs
            if(main.income <= 0 || main.expense <= 0){
                System.out.println("Income/Expense cannot be negative! Try again");
            }else {

                //process
                main.spending = main.categorizeSpending(main.income, main.expense);

                //Displaying Output
                System.out.println("Your Spending Category is " + main.spending);
                System.out.print("Advice: ");
                main.giveAdvice(main.spending);
            }
        }while(main.income <= 0 || main.expense <= 0);



        sc.close();
    }

    //Method categorizing spending
    String categorizeSpending(double income, double expense){

        if(expense < (0.3 * income)){
            spending = "Safe";
        }else if(expense >= (0.3 * income) && expense <= (0.6 * income)){
            spending = "Moderate";
        }else if(expense > (0.6 * income)){
            spending = "Risky";
        }

        return spending;
    }

    //Method to give Advice
    void giveAdvice(String Spending){

        if(spending.equals("Safe")){
            Advice = "Well Done! Your spending habits are good, You should continue like this";
        }else if(spending.equals("Moderate")){
            Advice = "Although your spending isn't bad, you should be careful to remain within your limits";
        } else if(spending.equals("Risky")){
            Advice = "Please restrict your spending immediately, you are living very recklessly";
        }
        System.out.println(Advice);
    }

}