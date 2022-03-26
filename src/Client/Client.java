package Client;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private String address;
    private int port;

    private BufferedReader reader;
    private PrintWriter writer;
    private DataOutputStream dataOutput;
    private DataInputStream dataInput;

    public Client(String address, int port) throws IOException, InterruptedException {
        this.address = address;
        this.port = port;

        socket = new Socket(address, port);

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            dataOutput = new DataOutputStream(socket.getOutputStream());
            dataInput = new DataInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        while (true)
        {
            writer.println("PING::SEND_MESSAGE");
            writer.flush();
            Thread.sleep(1000);
        }
    }

    public void menu(){
        int choose = 0;
        while (true) {
            System.out.println("********  USER MENU  ********");
            System.out.println("1. LOGIN");
            System.out.println("2. SEND MESSAGE");
            System.out.println("3. GET HISTORY");
            System.out.println("4. SEND FILE");
            System.out.println("5. LOGOUT");
            System.out.println("6. EXIT");
            System.out.println("********-------------********");

            Operation operation = Operation.NULL;
            switch (choose)
            {
                case 1:
                    operation = Operation.LOGIN;
                    break;
                case 2:
                    operation = Operation.SEND_MESSAGE;
                    break;
                case 3:
                    operation = Operation.GET_HISTORY;
                    break;
                case 4:
                    operation = Operation.FILE_TRANSFER;
                    break;
                case 5:
                    operation = Operation.LOGOUT;
                    break;
                case 6:
                    System.out.println("Closing app...");
                    return;
            }

            action(operation);
        }
    }

    public void action(Operation operation){
        switch (operation)
        {
            case LOGIN:
                sendMessage();
                break;
        }
    }

    public void sendMessage(){

    }

    public void receiveMessage(){

    }
}
