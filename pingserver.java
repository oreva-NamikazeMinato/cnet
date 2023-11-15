import java.io.*;
import java.net.*;

public class pingserver {
    public static void main(String a[]) {
        String line1, line2;
        int i;
        ServerSocket ss;
        DataInputStream di;
        PrintStream ps;
        Socket soc;
        ss = null;
        soc = null;
        try {
            ss = new ServerSocket(9999);
        } catch (Exception e) {
            System.out.print(e);
        }
        System.out.println("Ping server");
        try {
            soc = ss.accept();
            di = new DataInputStream(soc.getInputStream());
            ps = new PrintStream(soc.getOutputStream());
            for (i = 0; i < 4; i++) {
                line1 = di.readLine();
                System.out.println("Pinged by client");
                ps.println(line1 + "reply from host:bytes=32b time<ms TTL=125");
            }
            di.close();
            ps.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}