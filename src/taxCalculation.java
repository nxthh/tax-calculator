import java.text.DecimalFormat;
import java.util.Scanner;

public class taxCalculation {
    public static String Red = "\u001B[31m" ;
    public static String Yellow = "\u001B[33m";
    public static String Green = "\u001B[32m";
    public static String Reset = "\u001B[0m";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double income, incomeToPay, taxPercentage, taxAmount;

        System.out.println(Green+"=============================");
        System.out.println("Monthly Income Tax Rate (USD)");
        System.out.println("=============================");

        while (true){
            System.out.print(Yellow+"Enter your monthly income here ==> $: ");
            try{
                income=Double.parseDouble(scanner.nextLine());

                if(income == 0){
                    System.out.println("Exited the progam. Good Bye!");
                    break;
                }

                if(income<0){
                    System.out.println(Yellow+"Income can not be less than 0!"+Reset);
                    continue;
                }else {
                    if(income<=11601){
                        taxPercentage = 10;
                    } else if (income<=47000) {
                        taxPercentage = 12;
                    } else if (income<=100000) {
                        taxPercentage = 22;
                    } else if (income<=192000) {
                        taxPercentage = 24;
                    } else if (income<=240000) {
                        taxPercentage = 32;
                    } else if (income<=627000) {
                        taxPercentage = 35;

                }else {
                        taxPercentage = 37;
                    }

                    taxAmount = income*taxPercentage/100;
                    incomeToPay = income - taxAmount;

                    DecimalFormat decimalFormat = new DecimalFormat("USD #,##0.00");

                    System.out.println("============================================");
                    System.out.println(Red+"Tax on your income is : " + decimalFormat.format(taxAmount));
                    System.out.println(Green+"Your end income is    : " + decimalFormat.format(incomeToPay));
                    System.out.println(Yellow+"============================================");

                }

            }catch (NumberFormatException e){
                System.err.println("Invalid input! Try Again!");
            }
        }
    }

}