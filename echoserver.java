package cn;
import java.io.*;
import java.net.*;

class echoserver {
    public static void main(String a[]) {
        try {
            Socket s = null;
            ServerSocket ss = new ServerSocket(8000);
            s = ss.accept();
            System.out.println(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            
            while (true) {
                String str = br.readLine();
                if (str.equals(".")){
System.out.println("yes");
                    break;
                }

                System.out.println("\nMesssage received from client:" + str);
          
            }
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}