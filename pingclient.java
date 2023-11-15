import java.io.*;
import java.net.*;

public class pingclient {
    public static void main(String args[]) {
        PrintWriter out = null;
        int i, j, k;
        BufferedReader networkIn = null;
        try {
            System.out.print("Enter IP Address:");
            DataInputStream in = new DataInputStream(System.in);
            String ip = in.readLine();
            Socket theSocket = new Socket(ip, 9999);
            networkIn = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(theSocket.getOutputStream());
            System.out.print("Pinging " + ip + " with 32 bytes of data");
            for (i = 0; i < 4; i++) {
                out.println(ip);
                out.flush();
                String inp = networkIn.readLine();
                if (inp != null) {
                    for (j = 0; j < 10000; j++) {
                        for (k = 0; k < 50000; k++) {
                        }
                    }
                    System.out.println("Reply from" + inp);
                } else {
                    for (i = 0; i < 4; i++) {
                        for (j = 0; j < 10000; j++) {
                            for (k = 0; k < 50000; k++) {
                            }
                            System.out.println("\nRequested time out");
                        }
                    }
                }
            }
        } catch (IOException e) {
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 10000; j++) {
                    for (k = 0; k < 50000; k++) {
                    }
                    System.out.println("\nRequested timeout");
                }
            }
        }
        try {
            if (networkIn != null)
                networkIn.close();
            if (out != null)
                out.close();
        } catch (Exception e) {
            System.out.println("\n Requested time out");
        }
    }
}