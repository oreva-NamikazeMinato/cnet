import java.net.*;
import java.io.*;

class fileclient {
    public static void main(String args[]) throws IOException {
        try {
            Socket s = new Socket("LocalHost", 1010);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String msg = br.readLine();
            System.out.println("Received file:" + msg);
            FileInputStream fis = new FileInputStream(msg + ".txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            System.out.println("Enter the new file name:");
            String fname = br1.readLine();
            FileOutputStream fos = new FileOutputStream(fname + ".txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 2048);
            int msg1;
            while ((msg1 = bis.read()) != -1)
                fos.write((char) msg1);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}