import java.net.Socket;

public interface SubjectInterface {
    void register(Observer obj);
    void notifyRegisteredUsers(String stk_name, String msg, Socket s);
}
