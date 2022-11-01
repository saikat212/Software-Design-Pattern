import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public  class MyServer {


    public static void main(String[] args) throws IOException {


        //System Part
        Subject subject=new Subject();

        StockInfo stk1 = new StockInfo("P1",3,40.00);
        StockInfo stk2 = new StockInfo("P2",4,30.00);
        StockInfo stk3 = new StockInfo("P3",5,80.00);
        StockInfo stk4 = new StockInfo("P4",6,25.00);
        StockInfo stk5 = new StockInfo("P5",7,15.00);
        StockInfo stk6 = new StockInfo("P6",9,50.00);

        subject.available_stock_list.add(stk1);
        subject.available_stock_list.add(stk2);
        subject.available_stock_list.add(stk3);
        subject.available_stock_list.add(stk4);
        subject.available_stock_list.add(stk5);
        subject.available_stock_list.add(stk6);


        //User Part

        Observer myObserver1 = new ObserverType1("Rahim");
        //Observer myObserver2 = new ObserverType1("Karim");
       // Observer myObserver3 = new ObserverType1("sakib");

        //Registering observer

        subject.register(myObserver1);
        //subject.register(myObserver2);
        //subject.register(myObserver3);


        //connection

        ServerSocket ss = null;
        try {
            ss=new ServerSocket(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Waiting for client ...... ");
        Socket s= null;//establishes connection
        try {
            s = ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client Connected ");



        Runnable r = new ClientRequestHandler(subject,myObserver1,s);
        new Thread(r).start();


        while (true)

        {
            Scanner sc = new Scanner(System.in);
            String[] input = new String[3];
            input = sc.nextLine().split(" ");
            String CommandName=input[0];

            if(CommandName.equalsIgnoreCase("I"))
            {
                String stock_name = input[1];
                double increased_price = Double.parseDouble(input[2]);
                subject.Increased_Stock_Price(stock_name,increased_price,s);


            }
            if(CommandName.equalsIgnoreCase("D"))
            {
                String stock_name = input[1];
                double decreased_price = Double.parseDouble(input[2]);
                subject.Decreased_Stock_Price(stock_name,decreased_price,s);


            }
            if(CommandName.equalsIgnoreCase("C"))
            {
                String stock_name = input[1];

                int changed_stock_count=Integer.parseInt(input[2]);
                subject.Stock_Count_Change(stock_name,changed_stock_count,s);


            }

        }
        //ss.close();
    }




    static class ClientRequestHandler implements Runnable
    {
        Subject subject;
        Observer observer;
        Socket s;

        public ClientRequestHandler(Subject subject,Observer observer,Socket s)
        {
            this.observer=observer;
            this.subject=subject;
            this.s=s;
        }

        @Override
        public void run() {



            while (true)
            {

                try{

                    //DataInputStream dis=new DataInputStream(s.getInputStream());
                    //String  str=(String)dis.readUTF();
                    String str="S P3";
                    String[] client_input = new String[3];
                    client_input=str.split(" ");




                    String CommandName1=client_input[0];
                    if(CommandName1.equalsIgnoreCase("S"))
                    {
                        String stock_name = client_input[1];

                        for (int i=0;i<subject.available_stock_list.size();i++)
                        {
                            StockInfo current_stock=subject.available_stock_list.get(i);
                            if(current_stock.StockName.equalsIgnoreCase(stock_name))
                            {
                                subject.SubscribeAction(observer,current_stock);
                                break;

                            }

                        }


                    }

                    if(CommandName1.equalsIgnoreCase("U"))
                    {
                        String stock_name = client_input[1];
                        for (int i=0;i<subject.available_stock_list.size();i++)
                        {
                            StockInfo current_stock=subject.available_stock_list.get(i);
                            if(current_stock.StockName.equalsIgnoreCase(stock_name))
                            {
                                subject.UnSubscribeAction(observer,current_stock);
                                break;

                            }

                        }

                    }
                }catch(Exception e){System.out.println(e);}



            }
        }
    }

}
