package AtmSimulator;

import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        AtmOpInterface op=new AtmOperation();
        int atmpin=5272;
        Scanner in=new Scanner(System.in);
        System.out.println("Welcome to your bank account !!!");
        
            while(true){
                System.out.println("\n1.Withdraw Amount\n2.Deposit Amount\n3.View Available Balance\n4.Exit\n");
                System.out.print("Enter Choice : ");
                int ch=in.nextInt();
                
               
                
                 if(ch == 1){
                	System.out.print("Enter ATM Pin: ");
                    int pin=in.nextInt();
                	if(atmpin == pin){
                	    System.out.println("Account Authorized!\n");
                		System.out.println("Enter amount to withdraw ");
                		 	double withdrawAmount=in.nextDouble();
                		 	op.withdrawAmount(withdrawAmount);
                	 }
                	else{
                        System.out.println("Incorrect Atm Number or pin");
                        System.exit(0);
                    }
                }
                
                else if(ch == 2){
                	System.out.print("Enter ATM Pin: ");
                    int pin=in.nextInt();
                	if(atmpin==pin){
                		System.out.println("Account Authorized! \n");
                        System.out.println("Enter Amount to Deposit :");
                        double depositAmount=in.nextDouble();
                        op.depositAmount(depositAmount);
                	}
                	else{
                         System.out.println("Incorrect Atm Number or pin");
                         System.exit(0);
                    }
                }
                 
                if(ch==3){
                	System.out.print("Enter ATM Pin: ");
                    int pin=in.nextInt();
                	if(atmpin == pin){
                		 System.out.println("Account Authorized!\n");
                		 op.viewBalance();
                	    }
                	else{
                        System.out.println("Incorrect ATM pin");
                        System.exit(0);
                    }
                }
                
               
                
                else if(ch == 4){
                    System.out.println("Collect your ATM Card\n Thank you ");
                    System.exit(0);
                }
                
                else
                {
                    System.out.println("Please enter valid choice");
                }
            }
        }
    }
