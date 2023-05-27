
//** Classes: BankTester(main class), Bank, Account and Customer */

import java.util.Scanner;

	public class BankTester {
		
		public static void main(String[] args) {
			
	       
	        Scanner in= new Scanner(System.in);
	        int numOfCustomers =0;
			Bank bank= new Bank(null, null);
	        Customer[] c= bank.getCustomer();
	        
	        
			System.out.println("WELCOME TO BISO BANKING SERVICES"+"\n"+"BANK NUMBER: Stu201905362");
			System.out.println("\n");

			while(true)
			{ // this loop runs until the customer select the option 5 which then exits the program.
			System.out.println("Please Enter Your Choice:");
	        System.out.println("1. Create an Account");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdraw Money");
	        System.out.println("4. Check Balance");
	        System.out.println("5. Exit");
	        int option= Integer.parseInt(in.next());

	        switch(option){

				case 1:
						//Creating a new customer account
						System.out.println("___________________________________________________");
						System.out.println("Creating a new Customer Bank Account");
						System.out.println("___________________________________________________");

						System.out.println("Please Enter Your Name: ");
	                    String firstName=in.next();
						System.out.println("Please Enter Your Surname:");
						String surname=in.next();
						System.out.println("Please Enter Your ID:");
						String id=in.next();
						System.out.println("Please Enter Your Prefered Account Number (eg FN5362):");
	                    String acc=in.next();
	                    System.out.println("Please Enter Your First Ammount To Be Deposited in Your Account (eg 200 0r 900):");
						double bal=Double.parseDouble(in.next());
						System.out.println("Enter Your 4 Digit Pin (Dont Forget It (eg 3785)):");
						int pin=in.nextInt();
						Account account = new Account(bal, acc, pin);
	                   
	                    Customer customer= new Customer(firstName, surname, id, account);
						c[numOfCustomers]= customer;
						System.out.println("**********************************");
						System.out.println("C-Names:"+firstName+" "+surname+ "\n"+"ID:"+id+ "\n"+
						"Balance:P"+bal+"\n"+"Account Number:"+acc);
						numOfCustomers++;
						if(numOfCustomers <=5)
						{ //if number of customers exceed 5, the program stops. 
							System.out.println("=================================================");
							System.out.println(" Account Successfully Added To The Bank Database");
							System.out.println("=================================================");
							System.out.println("\n");
						}
						else{
							System.out.println("*************************************************");
							System.out.println("Accounts Limits exceeded");
							System.out.println("*************************************************");
							System.out.println("\n");
						}
	                break;
				case 2:
							//  If there is no account in the database no money can be deposited
	                        System.err.println("Please Enter Your Account Number:");
	                        acc=in.next();
	                    if (numOfCustomers==0){
							System.out.println("**************************************************************");
							System.err.println("Account Number not found! Consider creating an account first.");
							System.out.println("**************************************************************");
							System.out.println("\n");

	                    }
	                    else{
	                        boolean found= false; // a boolean is used to find if the account exist or not
	                        for (int i = 0; i< numOfCustomers; i++){
	                           Account temp= c[i].getAccount();
	                           String accTemp = temp.getAccountNumber();
	                           if(accTemp.equals(acc)){
	                               System.out.println("Enter Amount To Deposit:");
	                               double money= Double.parseDouble(in.next());
	                               temp.deposit(money);
	                            found = true;// if the account exist then the above operations will commence
	                           }
	                        }
							if (found == false)
							{ // if the account entered is wrong then the program stops and bring back the options again.
								System.out.println("**************************************************************");
								System.err.println("Account Number Not Found. Consider creating an account first.");
								System.out.println("**************************************************************");
								System.out.println("\n");
	                        }
	                    }


	                break;
				case 3:	
						// If there is no account in the bank DB the program ends and brings back the options.
	                        System.err.println("Please Enter Your Account Number:");
							acc=in.next();
							System.out.println("Enter Pin (eg 4356)");
							pin=in.nextInt();
	                    if (numOfCustomers==0){
							System.out.println("**************************************************************");
							System.err.println("Account Number not found! Consider creating an account first.");
							System.out.println("**************************************************************");
							System.out.println("\n");
						}
	                    else{
	                        boolean found= false; // with accounts available in the DB, the boolean checks if the account entered exist.
	                        for (int i = 0; i< numOfCustomers; i++){
	                        Account temp= c[i].getAccount();
							String accTemp = temp.getAccountNumber();
							int piTemp=temp.getPinNumber();
	                        if(accTemp.equals(acc)){
	                            System.err.println("Enter Amount To Withdraw:");
	                            double money= Double.parseDouble(in.next());
	                            temp.withdraw(money);
	                            found = true; // if the account exist then the above operation will commence
	                        }
	                        }
							if (found == false)
							{ // if the account has been entered wrong from how it was registered then the program stops.
								System.out.println("**************************************************************");
	                            System.err.println("Account Number Not Found. Consider creating an account first.");
	                    		System.out.println("**************************************************************");
	                    		System.out.println("\n");
							}
	                    }


	                break;
				case 4:			
								// simply checks the available account balance
	                            System.err.println("Please Enter Your Account Number:");
								acc=in.next();
								System.out.println("Enter Pin");
								pin=in.nextInt();
	                        if (numOfCustomers==0){
								System.out.println("**************************************************************");
								System.err.println("Account Number not found! Consider creating an account first.");
								System.out.println("**************************************************************");
								System.out.println("\n");
							}
	                        else{
	                            boolean found= false;
	                            for (int i = 0; i< numOfCustomers; i++){
	                            Account temp= c[i].getAccount();
								String accTemp = temp.getAccountNumber();
								int piTemp=temp.getPinNumber();
	                            if(accTemp.equals(acc)){
								   System.out.println("---------------------------------------");
								   System.err.println("Balance is:P"+temp.getBalance());
								   System.out.println("---------------------------------------");
								   System.out.println("\n");
	                                found = true;
	                            }
	                            }
	                            if (found == false){
									System.out.println("**************************************************************");
									System.err.println("Account Number Not Found. Consider creating an account first.");
									System.out.println("**************************************************************");
									System.out.println("\n");
	                            }
	                        }
	           

	                break;
	           
				case 5:
						// Exit the program
	            		System.out.println("*****************************************");
	            		System.out.println("Thank you for using our banking services. Goodbye!!");
	                    System.exit(0);
	                break;
				default:
							// shows when a customer select an option out of bounds.
	            			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	            			System.err.println("You entered an invalid option. Please Enter Again");
	            			System.out.println("\n");
	                break;
	        }
	        }
	    
	    }
	}


	// Beggining of classes
	class Bank{
		private String bankName;	//Bank Name*
	    private String bankNumber;	//Bank Number*
	    private Customer[] customers = new Customer[5]; // customers limited to 5, using any array.
	    
		Bank(String bankName, String bankNumber) 
		{
	    	this.bankName = bankName;
	    	this.bankNumber= bankNumber;
	    }

		public String toString() 
		{
	    	return bankName+ "" +bankNumber;
	    }
	    

		public Customer[] getCustomer() 
		{
	        return customers;
	    }  

	  

	}//**End of Bank class */




	//Beginning of Account class
	class Account{
	   private double balance=0;	// balance initialized to P0.0
	   private String accountNumber;
	   private int pinNumber;
	    
	    public  Account(double bal, String acc, int pin){
	        
	        if(bal >=0){
	            balance=bal;
	        }
	        else{
	            balance=0;
			}
			pinNumber=pin;
	        accountNumber=acc;
	    }
	    
		public void deposit(double amount) // Every customer has to deposit an amount above 0
		{									//** amount deposited is added @ balance=balance+ amount deposited */
			if( amount > 0)
			{
				balance= balance + amount;
				System.out.println("**************************************************************");
	            System.out.println("P"+amount+" has been successfully deposited in your account.\n");
					System.out.println("This is your new balance: P" +balance);
               System.out.println("\n");
	        }
			else
			{
				System.out.println("**********************************");
	            System.err.println("Please avoid depositing negative amounts");
	            System.out.println("\n");
	        }
	        
	    }
		public void withdraw(double amount) // withdraw method allows a customer to take money from the account. 
											// and subtract the amount withdrawn from the original balance.@ balance=balance - amount withdrawn.
		{
	    	
	        if( amount > 0)
	        {
	        	double withdrawAmount= balance;
	        	withdrawAmount=withdrawAmount-amount;
				
				if(withdrawAmount > 0) {
					balance = balance - amount;
					System.out.println("***********************************************************");
		            System.out.println("P"+amount+" was successfully withdrawn from your account.\n"); 
	               System.out.println("This is your new balance: P" +balance);
		            System.out.println("\n");
				}  
	        else{
	            System.err.println("Insufficient funds to remove: P"+amount); // If a customer withdraws more money than in the account
	            System.out.println("\n");									//** the program sends a message that there is not enough funds to withdraw that amount */
	        }
	       }
	    }
	    public double getBalance(){
	        return balance;
	    }
	    public String getAccountNumber(){
	        return accountNumber;
		}
		public int getPinNumber(){
			return pinNumber;
		}

	}//*End of Account Class */
	 




	//Beginning of Customer class* 
	class Customer
	{	// this class holds the customer's personal details and gets the account number from the account class.
	   private String firstName;
	   private String surname;
	   private String id;
	    Account account;

	    Customer( String n, String s, String i, Account a){
	        this.firstName=n;
	        this.surname=s;
	        this.id=i;
	        this.account=a;
		}
		public String toString(){
	        return("Name:"+firstName+" "+surname+"\n"+"ID:"+id+"\n"+
                    "Account Number:"+account.getAccountNumber()+"\n"+"Balance:"+account.getBalance());                  

	    }

	  
	   public String getfirstName(){
	        return firstName;
	    }
	    public String getsurname(){
	        return surname;
	    }
	    public String getid(){
	        return id;
	    }
	    
	    public Account getAccount() {
	        return account;
	    }
	}