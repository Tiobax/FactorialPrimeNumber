import java.io.FileWriter;
import java.io.IOException;


public class LogFile {


    public static FileWriter log;

    public static synchronized void write(String str) {
        try {
            log.write(str);
            log.write('\n');
            log.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openFile() {
        try {
            log = new FileWriter("log.txt",false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeFile() {
        try {
            log.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
