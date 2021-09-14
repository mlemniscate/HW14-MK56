package ir.maktab.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket clientSocket = serverSocket.accept();
            System.out.println("client connected");
            while (true) {
                readMessage(clientSocket);
                writeMessage(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readMessage(Socket clientSocket) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("client: " + bufferedReader.readLine());
    }

    private static void writeMessage(Socket clientSocket) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
        printWriter.println(scanner.nextLine());
        printWriter.flush();
    }
}
