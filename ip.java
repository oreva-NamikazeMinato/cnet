package cn;
import java.net.*;
class ip{
    public InetAddress ip;
    public static void main(String[] args) {
        try{
InetAddress ip =InetAddress.getLocalHost();
System.out.println(ip);
String ip1=ip.getHostName();
System.out.println(ip1);
InetAddress ip2=InetAddress.getByName("sys25");
System.out.println(ip2);
        }
        catch(Exception e){
System.out.println(e);
        }
        
    }
}