import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            while (true)
            {


                Scanner sc = new Scanner(System.in);
                String[] input = new String[4];
                input = sc.nextLine().split(" ");
                String Command_From_Client=input[0]+" "+input[1];

                dout.writeUTF(Command_From_Client);
                dout.flush();
                dout.close();


                DataInputStream dis=new DataInputStream(s.getInputStream());
                String  str=(String)dis.readUTF();
                System.out.println(str);


            }


        }catch(Exception e){System.out.println(e);}
    }
}  