import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Shyshkin Vladyslav on 15.11.2015.
 */
public class main {
    private static Socket connection;
    private static InputStream input;
    private static OutputStream output;
    public static void main(String [] args)
    {
        try {
            try {
                connection = new Socket("127.0.0.1", 8189);
                input = connection.getInputStream();
                output = connection.getOutputStream();
                Scanner in = new Scanner(System.in);
                Scanner get = new Scanner(input);
                PrintWriter out = new PrintWriter(output, true);
                boolean done = false;
                String line = null;
                while (true) {
                    //ожидание пока пользователь напишет фразу
                      line = in.nextLine();
                    //отослать фразу на сервер
                      out.println(line);
                    //ожидание ответа от севрера
                       // System.out.println(get.nextLine());
                }
            }
            finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
