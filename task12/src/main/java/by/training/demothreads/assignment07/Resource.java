package by.training.demothreads.assignment07;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Resource {
    private FileWriter fileWriter;

    public Resource(String file) throws IOException {
        fileWriter = new FileWriter(file, true);
    }

    public synchronized void writing(String str, int i) {
        try {
            fileWriter.append(str).append(" ");
            TimeUnit.MILLISECONDS.sleep(100);
            ;
            fileWriter.append("-> ").append(String.valueOf(i)).append("\n");
        } catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        } catch (InterruptedException e) {
            System.err.print("ошибка потока: " + e);
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
