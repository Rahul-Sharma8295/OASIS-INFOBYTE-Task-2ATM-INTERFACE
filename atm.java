import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String args[]) {
        ATMop obj = new ATMop();
    }
}

class Data {
    Float Balance;

    // Add a constructor to initialize Balance
    public Data() {
        this.Balance = 0.0f; // You can set it to any initial value you prefer
    }
}

class ATMop {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Data> map = new HashMap<>();

    ATMop() {
        System.out.println("*******************************************************");
        System.out.println("Welcome to our ATM ");
        op();
    }


    // Function
    public void op() {
    System.out.println("*******************************************************");
    System.out.println("Enter PIN Number");
    int pincode = sc.nextInt();
    
    if (map.containsKey(pincode)) {
        System.out.println("*******************************************************");
        System.out.println("Welcome back!");
        Data obj = map.get(pincode);
        menu(obj);
    } else {
        System.out.println("*******************************************************");
        System.out.println("Please create an account first ");
        System.out.println("set your pincode ");
        int pin = sc.nextInt();
        
        if (map.containsKey(pin)) 
        {
            System.out.println("Pin number already exists. Please create another one.");
        }
         else 
         {
            Data obj = new Data();
            map.put(pin, obj);
            System.out.println("Account created successfully!");
            menu(obj);
        }
    }
}

    // Function
    public void menu(Data obj) {
        System.out.println("*******************************************************");
        System.out.println("1. Check Balance ");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check another Account ");
        System.out.println("5. EXIT");

        int x = sc.nextInt();

        if (x == 1) {
            Check_balance(obj);
        } else if (x == 2) {
            Deposite(obj);
        } else if (x == 3) {
            withdraw(obj);
        } else if (x == 4) {
            op();
        } else if (x == 5) {
            System.out.println("Thanks !");
        } else {
            System.out.println("Please Enter the valid Number ");
            menu(obj);
        }
    }

    // Function
    public void Check_balance(Data obj) {
        System.out.println("Your balance " + obj.Balance);
        System.out.println("*******************************************************");
        menu(obj);
    }

    // Function
    public void Deposite(Data obj) {
        System.out.println("Enter Your amount ");
        float a = sc.nextFloat();
        obj.Balance = obj.Balance + a;
        System.out.println("Amount Deposited Successfully ");
        System.out.println("*******************************************************");
        menu(obj);
    }

    // Function
    public void withdraw(Data obj) {
        System.out.println("Enter Your amount ");
        float a = sc.nextFloat();
        if (obj.Balance >= a) {
            obj.Balance = obj.Balance - a;
            System.out.println("Amount withdraw Successfully ");
        } else {
            System.out.println("Insufficient Balance ");
        }
        System.out.println("*******************************************************");
        menu(obj);
    }
}
