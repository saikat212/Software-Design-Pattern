import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ObserverType1 implements  Observer{

    String nameOfObserver;
    public ObserverType1(String nm)
    {
        this.nameOfObserver=nm;
    }
    @Override
    public void update(String msg, Socket s) {
        String SentMessage=nameOfObserver + " has received an alert : "+msg;
        //System.out.println(nameOfObserver + " has received an alert : "+msg);

        try {
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF(SentMessage);
            dout.flush();
            dout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
