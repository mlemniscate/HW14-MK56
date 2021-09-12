package ir.maktab;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    private static String txtFile = "List.txt";
    private static String myTextFile = "MyText.txt";
    private static String exeFile = "file.exe";

    public static void main(String[] args) throws IOException {
        useRandomAccessFile(txtFile);
    }

    private static void useRandomAccessFile(String file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        while (randomAccessFile.getFilePointer() != randomAccessFile.length()) {
            System.out.println(randomAccessFile.readLine());
            randomAccessFile.seek(randomAccessFile.getFilePointer());
        }
        randomAccessFile.close();
    }

    private static void writeRandomAccessFile(String file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.writeBytes("Mehran\n");
        randomAccessFile.close();
    }

    private static void showFileFeature() throws IOException {
        File file = new File(txtFile);
        System.out.println("file length: " + file.length());
        System.out.println("is directory: " + file.isDirectory());
        System.out.println("is file: " + file.isFile());
        System.out.println("name: " + file.getName());
        System.out.println("path: " + file.getPath());
        System.out.println("absolute path: " + file.getAbsolutePath());

        createFile("NewFile.txt");
    }

    private static void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(file.createNewFile()) {
            System.out.println("new file created.");
        } else {
            System.out.println("file already exists.");
        }
    }

    private static void writeFileOutputStream() throws IOException {
        int[] numbers = {98562321, 98562322, 98562323};
        byte[] outputArray = convertIntArrayToByteArray(numbers);
        FileOutputStream fileOutputStream = new FileOutputStream(exeFile);
        fileOutputStream.write(outputArray);
        fileOutputStream.close();
    }

    private static byte[] convertIntArrayToByteArray(int[] numbers) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(numbers.length * 4);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(numbers);
        return byteBuffer.array();
    }

    private static void readFileInputStream() throws IOException {
        List<Byte> byteList = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(exeFile);
        int inputByte;
        while (-1 != ( inputByte = fileInputStream.read())) {
            byteList.add((byte) inputByte);
        }
        System.out.println(byteList);
        fileInputStream.close();
    }

    private static void fileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter(myTextFile, true);
//        fileWriter.write("Milad\n");
//        fileWriter.write("Amir\n");
//        fileWriter.write("Mohammad\n");
        fileWriter.append("Milad2\n");
        fileWriter.append("Amir2\n");
        fileWriter.append("Mohammad2\n");
        fileWriter.close();
    }


    public static void fileReader() throws IOException {
        FileReader fileReader = new FileReader(myTextFile);
        int character;

        while (-1 != (character = fileReader.read())) {
            System.out.println("char: " + (char) character);
        }

        fileReader.close();
    }


}
