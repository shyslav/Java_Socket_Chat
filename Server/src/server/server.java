package server;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Shyshkin Vladyslav on 15.11.2015.
 */
public class server{
    private static ServerSocket server;
    private static Socket connection;
    private static ArrayList<String> array = new ArrayList<String>();
    public static void main(String [] args) {
        try {
            System.out.println("Server Started");
            //создать сервер с портом 8189
            server = new ServerSocket(8189);
            System.out.println("Waiting for a client...");
            int i = 1;
            while (true)
            {
                //подключить пользователя
                connection = server.accept();
                Runnable run = new work(connection);
                Thread tr = new Thread(run);
                tr.start();
                i++;
            }
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}

