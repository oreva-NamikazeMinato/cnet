package cn;

import java.io.*;
import java.net.*;

class echoclient {
    public static void main(String a[]) {
        try {
            Socket s = new Socket("LocalHost", 8000);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter print = new PrintWriter(s.getOutputStream());
            System.out.println("\nMessage to be echoed:");
            String str = br1.readLine();
            print.println(str);
            print.flush();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}