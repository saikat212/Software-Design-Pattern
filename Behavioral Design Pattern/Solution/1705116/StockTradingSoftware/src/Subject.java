import java.net.Socket;
import java.util.*;

public class Subject implements  SubjectInterface{

    List<Observer> observerList=new ArrayList<Observer>();
    List<StockInfo> available_stock_list =new ArrayList<StockInfo>();

    @Override
    public void register(Observer obj) {
        this.observerList.add(obj);
        for (int i=0;i<this.available_stock_list.size();i++)
        {
            System.out.println(this.available_stock_list.get(i).StockName+"  "+this.available_stock_list.get(i).StockCount +"  "+this.available_stock_list.get(i).StockPrice);
        }

    }

    @Override
    public void notifyRegisteredUsers(String stk_name,String msg,Socket s)
    {
        for(Observer observer: observerList)
        {
            for (int i=0;i<observer.subscribed_stock_list.size();i++)
            {
                if(observer.subscribed_stock_list.get(i).StockName.equalsIgnoreCase(stk_name))
                {
                    observer.update(msg,s);
                    break;
                }

            }

        }

    }

    void SubscribeAction(Observer observer,StockInfo stkInfo)
    {

        observer.subscribed_stock_list.add(stkInfo);
    }

    void UnSubscribeAction(Observer observer,StockInfo stkInfo)
    {
        observer.subscribed_stock_list.remove(stkInfo);
    }

    void Increased_Stock_Price(String stk_name, double inc_price, Socket s)
    {
        StockInfo matching_stock=SearchStock(stk_name);
        matching_stock.StockPrice= matching_stock.StockPrice+inc_price;

        String str1=String.valueOf(inc_price);
        String str2=String.valueOf(matching_stock.StockPrice);

        String message = " The price of stock "+stk_name+"  is increased by "+str1+" .Current price is "+str2;
        notifyRegisteredUsers(stk_name,message,s);

    }

    void Decreased_Stock_Price(String stk_name,double dec_price,Socket s)
    {
        StockInfo matching_stock=SearchStock(stk_name);
        matching_stock.StockPrice= matching_stock.StockPrice - dec_price;

        String str1=String.valueOf(dec_price);
        String str2=String.valueOf(matching_stock.StockPrice);

        String message = " The price of stock "+stk_name+" is decreased by "+str1+" .Current price is "+str2;
        notifyRegisteredUsers(stk_name,message,s);

    }
    void Stock_Count_Change(String stk_name,int sc,Socket s)
    {
        StockInfo matching_stock=SearchStock(stk_name);

        matching_stock.StockCount=sc;

        String str1=String.valueOf(sc);
        String message = "The stock count of stock -"+stk_name+"- is changed . Current stock count is "+str1;
        notifyRegisteredUsers(stk_name,message,s);
    }

    StockInfo SearchStock(String stock_name)
    {
        for (int i=0;i<this.available_stock_list.size();i++)
        {
            StockInfo current_stock=this.available_stock_list.get(i);
            if(current_stock.StockName.equalsIgnoreCase(stock_name))
            {
               return current_stock;
            }

        }
        return null;
    }


}
