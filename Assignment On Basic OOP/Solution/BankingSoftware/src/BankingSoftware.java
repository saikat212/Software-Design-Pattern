import jdk.dynalink.linker.support.Lookup;

import java.util.ArrayList;
import java.util.Scanner;

class User
{
    private  String name;
    private  String AccountType;
    private long CurrentBalance;
    private long approved_loan_amount;

    void SetName(String N)
    {
        name=N;
    }

    void SetAccountType(String N)
    {
        AccountType=N;
    }
    void SetCurrentBalance(long b)
    {
        CurrentBalance=b;
    }

    void setApproved_loan_amount(long amnt)
    {
        approved_loan_amount=amnt;

    }

    String GetName()
    {

        return name;
    }

    String GetAccountType()
    {
        return AccountType;
    }

    long GetCurrentBalance()
    {
        return CurrentBalance;
    }
    long getApproved_loan_amount()
    {
        return approved_loan_amount;
    }


}
class Loan_info
{
    private String loaner_name;
    private long requested_loan_amount;
    public void setLoaner_name(String LNM)
    {
        loaner_name=LNM;
    }
    public void setRequested_loan_amount(long amnt)
    {
        requested_loan_amount=amnt;
    }
    String getLoaner_name()
    {
        return loaner_name;
    }
    long getRequested_loan_amount()
    {
        return requested_loan_amount;
    }
}
interface Account
{
    public User CreateAccount (String NM,long IniDeposite);
    public long Deposit(long current_balance,long depo_amount);
    public long Withdraw(long current_balance,long withdraw_amount);
}





class SavingAccount implements Account
{
    @Override
    public User CreateAccount(String NM,long IniDeposite)
    {

            User user=new User();
            user.SetName(NM);
            user.SetAccountType("Saving");
            user.SetCurrentBalance(IniDeposite);


            String bl=IniDeposite+"";
            System.out.println("Saving Account for "+NM+" Created; initial balance "+bl);
            return user;


    }


    @Override
    public long Deposit(long current_balance,long depo_amount)
    {
        long total_balance;
        total_balance=current_balance+depo_amount;

        String str=depo_amount+"";
        String str1=total_balance+"";
        System.out.println(str+"$ deposited; current balance "+str1);
        return total_balance;

    }
    @Override
    public long Withdraw(long current_balance,long withdraw_amount)
    {
        long curr_bl;
        curr_bl=current_balance-withdraw_amount;

        String s1=withdraw_amount+"";
        String s2=curr_bl+"";
        String s3=current_balance+"";
        if(curr_bl>=1000)
        {

            System.out.println(s1+"$ Withdraw ; current balance "+s2+"$ ");
            return curr_bl;
        }
        else
        {
            System.out.println(s1+"$ Withdraw Failed ; current balance "+s3+"$ ");
            return current_balance;

        }
    }


}

class StudentAccount implements Account
{

    @Override


    public User CreateAccount(String NM,long IniDeposite)
    {
            User user=new User();
            user.SetName(NM);
            user.SetAccountType("Student");
            user.SetCurrentBalance(IniDeposite);



            String bl=IniDeposite+"";
            System.out.println("Student Account for "+NM+" Created; initial balance "+bl);
            return user;

    }
    @Override
    public long Deposit(long current_balance,long depo_amount)
    {
        long total_balance;
        total_balance=current_balance+depo_amount;

        String str=depo_amount+"";
        String str1=total_balance+"";
        System.out.println(str+"$ deposited; current balance "+str1);
        return total_balance;

    }

    @Override
    public long Withdraw(long current_balance,long withdraw_amount)
    {
        long curr_bl;


        String s1=withdraw_amount+"";

        String s3=current_balance+"";
        curr_bl=current_balance-withdraw_amount;

        if(withdraw_amount<=10000 && curr_bl>0)
        {

            String s2=curr_bl+"";

            System.out.println(s1+"$ Withdraw ; current balance "+s2+"$ ");
            return curr_bl;
        }
        else
        {
            System.out.println(s1+"$ Withdraw Failed ; current balance "+s3+"$ ");
            return current_balance;

        }
    }





}
class FixedDeposit implements  Account
{
    @Override
    public User CreateAccount(String NM,long IniDeposite)
    {

            if(IniDeposite >= 100000)
            {
                User user=new User();
                user.SetName(NM);
                user.SetAccountType("Fixed");
                user.SetCurrentBalance(IniDeposite);


                String bl=IniDeposite+"";
                System.out.println("Fixed Deposite Account for "+NM+" Created; initial balance "+bl);

                return  user;
            }
            else
            {

                System.out.println("Failed to create account : must ensure the first deposit is at least 100,000$ for fixed deposit");
                return null;
            }

    }

    @Override
    public long Deposit(long current_balance,long depo_amount)
    {
        if(depo_amount>=50000)
        {
            long total_balance;
            total_balance=current_balance+depo_amount;
            String str=depo_amount+"";
            String str1=total_balance+"";
            System.out.println(str+"$ deposited; current balance "+str1);
            return total_balance;

        }
        else
        {
            long total_balance;
            total_balance=current_balance;
            String str=depo_amount+"";
            String str1=total_balance+"";
            System.out.println("Failed deposited; current balance "+str1);
            return total_balance;


        }

    }


    @Override
    public long Withdraw(long current_balance,long withdraw_amount)
    {
        long curr_bl;


        String s1=withdraw_amount+"";

        String s3=current_balance+"";
        curr_bl=current_balance-withdraw_amount;

        if(curr_bl>0) ///codition maturity one year
        {

            String s2=curr_bl+"";

            System.out.println(s1+"$ Withdraw ; current balance "+s2+"$ ");
            return curr_bl;
        }
        else
        {
            System.out.println(s1+"$ Withdraw Failed ; current balance "+s3+"$ ");
            return current_balance;

        }
    }

}


class  Employee extends Bank
{
    Employee()
    {

    }
    public void LookUp(String nm)
    {

        for (int i = 0; i < userlist.size(); i++)
        {
            if (userlist.get(i).GetName().equals(nm))
            {

                long cur_bal=userlist.get(i).GetCurrentBalance();
                String s=cur_bal+"";
                System.out.println(nm +" 's current balance "+cur_bal);
                break;

            }

        }



    }
    public void ApproveLoan()
    {
        System.out.println("Loan for ");
        for(int i=0;i<loner_info_list.size();i++)
        {
            String lonername=loner_info_list.get(i).getLoaner_name();
            long loan_amount=loner_info_list.get(i).getRequested_loan_amount();
            long current_bal=SearchBalance(lonername);
            long updated_bal=current_bal+loan_amount;
            int index=SearchIndex(lonername);
            userlist.get(index).SetCurrentBalance(updated_bal);
            userlist.get(index).setApproved_loan_amount(loan_amount);
            System.out.print(loan_amount+",");

            loner_info_list.remove(i);


        }
        System.out.println("approved");

    }
    public void ChangedInterestRate(String Acc_Type,double rate)
    {
        if(Acc_Type.equals("Student"))
        {
            setInterest_rate_student(rate);
        }
        else if(Acc_Type.equals("Saving"))
        {
            setInterest_rate_saving(rate);
        }
        else
        {
            setInterest_rate_fixed(rate);
        }



    }
    public void InternalFund()
    {


    }

}

class ManagingDirector extends Employee
{


}

class Officer
{

}

class Cashier
{

}



class  Bank {
    ArrayList<User> userlist = new ArrayList<>();
    ArrayList<Loan_info> loner_info_list=new ArrayList<>();

    public long InitialFund = 1000000;

    String active_username;


    private double interest_rate_saving;
    private double interest_rate_student;
    private double interest_rate_fixed;

    void setInterest_rate_saving(double v)
    {
        interest_rate_saving=v;
    }
    void setInterest_rate_student(double v)
    {
        interest_rate_student=v;
    }
    void setInterest_rate_fixed(double v)
    {
        interest_rate_fixed=v;
    }
    double getInterest_rate_saving()
    {
        return interest_rate_saving;
    }
    double getInterest_rate_student()
    {
        return interest_rate_student;
    }
    double getInterest_rate_fixed()
    {
        return interest_rate_fixed;
    }





    SavingAccount sv = new SavingAccount();
    StudentAccount sa = new StudentAccount();
    FixedDeposit fd = new FixedDeposit();


    Bank() {
        ManagingDirector MD = new ManagingDirector();
        Officer O1 = new Officer();
        Officer O2 = new Officer();


        Cashier C1 = new Cashier();
        Cashier C2 = new Cashier();
        Cashier C3 = new Cashier();
        Cashier C4 = new Cashier();
        Cashier C5 = new Cashier();

        setInterest_rate_fixed(0.15);
        setInterest_rate_saving(0.1);
        setInterest_rate_student(0.05);



    }

    public void AddUser(User ur) {
        userlist.add(ur);

    }

    boolean IsUniqueName(String NM) {
        String str = NM;

        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).GetName().equals(str)) {
                return false;

            }

        }
        return true;

    }

    public long SearchBalance(String nm)
    {

        for (int i = 0; i < userlist.size(); i++)
        {
            if (userlist.get(i).GetName().equals(nm))
            {

                return userlist.get(i).GetCurrentBalance();

            }
            else
            {
                return 0;
            }


        }

    }

    public int SearchIndex(String nm)
    {

        for (int i = 0; i < userlist.size(); i++)
        {
            if (userlist.get(i).GetName().equals(nm))
            {

                return i;

            }
            else
            {
                return 0;
            }


        }

    }

        public void AccountCreationProcedure (String usr_name, String Acc_type,long initial_depo){
            if (Acc_type.equals("Student")) {
                StudentAccount sa = new StudentAccount();
                if (IsUniqueName(usr_name)) {
                    User new_user = sa.CreateAccount(usr_name, initial_depo);
                    userlist.add(new_user);

                } else {
                    System.out.println("Error :  account already exists against that name");
                }


            } else if (Acc_type.equals("Saving")) {
                SavingAccount sv = new SavingAccount();

                if (IsUniqueName(usr_name)) {
                    User new_user = sv.CreateAccount(usr_name, initial_depo);
                    userlist.add(new_user);

                } else {
                    System.out.println("Error :  account already exists against that name");
                }
            } else {
                FixedDeposit fd = new FixedDeposit();

                if (IsUniqueName(usr_name)) {
                    User new_user = fd.CreateAccount(usr_name, initial_depo);
                    if (new_user != null) {
                        userlist.add(new_user);
                    }

                } else {
                    System.out.println("Error :  account already exists against that name");
                }

            }

        }

        public void DepositProcess ( long depo_amount){
            String Acc_Type = "";

            long current_balance;
            int user_serial;

            for (int i = 0; i < userlist.size(); i++) {
                if (userlist.get(i).GetName().equals(active_username)) {
                    user_serial = i;

                    Acc_Type = userlist.get(i).GetAccountType();

                    current_balance = userlist.get(i).GetCurrentBalance();

                    if (Acc_Type.equals("Student")) {
                        long total_balance;
                        total_balance = sa.Deposit(current_balance, depo_amount);
                        userlist.get(user_serial).SetCurrentBalance(total_balance);

                    } else if (Acc_Type.equals("Saving")) {
                        long total_balance;
                        total_balance = sv.Deposit(current_balance, depo_amount);
                        userlist.get(user_serial).SetCurrentBalance(total_balance);
                    } else {

                        long total_balance;
                        total_balance = fd.Deposit(current_balance, depo_amount);
                        userlist.get(user_serial).SetCurrentBalance(total_balance);
                    }
                }
                break;

            }

        }


        public void WithdrawProcess ( long withdraw_amount){
            int user_serial;
            String Acc_Type;
            long current_balance;

            for (int i = 0; i < userlist.size(); i++) {
                if (userlist.get(i).GetName().equals(active_username)) {
                    user_serial = i;

                    Acc_Type = userlist.get(i).GetAccountType();

                    current_balance = userlist.get(i).GetCurrentBalance();

                    if (Acc_Type.equals("Student")) {
                        long total_balance;
                        total_balance = sa.Withdraw(current_balance, withdraw_amount);
                        userlist.get(user_serial).SetCurrentBalance(total_balance);

                    } else if (Acc_Type.equals("Saving")) {
                        long total_balance;
                        total_balance = sv.Withdraw(current_balance, withdraw_amount);
                        userlist.get(user_serial).SetCurrentBalance(total_balance);
                    } else {

                        long total_balance;
                        total_balance = fd.Withdraw(current_balance, withdraw_amount);
                        userlist.get(user_serial).SetCurrentBalance(total_balance);
                    }
                    break;


                }
            }
        }


        public void LoanRequestProcess ( long loan_amount)
        {
            Loan_info LI = new Loan_info();
            int user_serial;
            String Acc_Type;
            long current_balance;

            for (int i = 0; i < userlist.size(); i++) {
                if (userlist.get(i).GetName().equals(active_username)) {
                    user_serial = i;

                    Acc_Type = userlist.get(i).GetAccountType();

                    current_balance = userlist.get(i).GetCurrentBalance();


                    if (Acc_Type.equals("Student")) {
                        if (loan_amount <= 1000) {
                            LI.setLoaner_name(active_username);
                            LI.setRequested_loan_amount(loan_amount);
                            loner_info_list.add(LI);
                        }


                    } else if (Acc_Type.equals("Saving")) {

                        if (loan_amount <= 10000) {
                            LI.setLoaner_name(active_username);
                            LI.setRequested_loan_amount(loan_amount);
                            loner_info_list.add(LI);
                        }


                    } else {

                        if (loan_amount <= 100000) {
                            LI.setLoaner_name(active_username);
                            LI.setRequested_loan_amount(loan_amount);
                            loner_info_list.add(LI);
                        }

                    }
                    break;


                }
            }

        }
    }



 public class BankingSoftware {


    public static void main(String[] args) {
        Bank b = new Bank();

        System.out.println("Bank Created: MD, S1, S2, C1, C2, C3, C4, C5 created");


        while (true) {
            Scanner scr = new Scanner(System.in);
            String input = scr.nextLine();
            String[] command = input.split(" ");


            if (command[0].equals("Open")) {
                String usr = command[1];
                b.active_username = usr;
            }


            if (command[0].equals("Create")) {
                long initial_deposite = Long.parseLong(command[3]);
                String username = command[1];
                String Acc_Type = command[2];
                b.AccountCreationProcedure(username, Acc_Type, initial_deposite);
                b.active_username = username;


            }
            if (command[0].equals("Deposit")) {

                long deposit_amount = Long.parseLong(command[1]);


                b.DepositProcess(deposit_amount);


            }
            if (command[0].equals("Withdraw")) {

                long withdraw_amount = Long.parseLong(command[1]);


                b.WithdrawProcess(withdraw_amount);

            }

            if(command[0].equals("Request"))
            {
                long loan_amount = Long.parseLong(command[1]);
                b.LoanRequestProcess(loan_amount);

            }

            if(command[0].equals("Lookup"))
            {
                String nm=command[1];


            }


        }

    }
}

