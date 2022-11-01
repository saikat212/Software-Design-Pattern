import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void update(String msg, Socket s);
    List<StockInfo> subscribed_stock_list =new ArrayList<StockInfo>();
}
