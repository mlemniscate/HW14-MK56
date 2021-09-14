package ir.maktab.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 5000);
            while(true) {
                writeMessage(clientSocket);
                readMessage(clientSocket);
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
