package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Shyshkin Vladyslav on 15.11.2015.
 */
public class work implements Runnable {
    private Socket incoming;
    private static InputStream input;
    private static OutputStream output;

    public work(Socket i) {
        incoming = i;
    }

    @Override
    public void run() {
        try {
            //входящий и исходящий поток
            input = incoming.getInputStream();
            output = incoming.getOutputStream();
            //получить входящие данные
            Scanner in = new Scanner(input);
            //получить данные введенные в консоль
            Scanner get = new Scanner(System.in);
            PrintWriter out = new PrintWriter(output, true);
            String line = null;
            while (true) {
                //принять ответ от клиента
                line = in.nextLine();
                System.out.println("Client:" + line);
//                if(get.hasNext())
//                {
//                    line = get.nextLine();
//                    out.println("SERVER:"+line); // отсылаем клиенту обратно ту самую строку текста.
//                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
