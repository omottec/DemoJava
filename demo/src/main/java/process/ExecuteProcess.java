package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by qinbingbing on 6/16/16.
 */
public class ExecuteProcess {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("git help");
            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
