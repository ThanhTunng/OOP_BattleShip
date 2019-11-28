package battleship.utils;

import battleship.model.History;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CSV {
    private static String filePath = "history.csv";

    public static void writeDataInNextLine(History history) {
        File file = new File(filePath);
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(file, true));

            String[] data = {
                    history.getPlayerName(),
                    history.getWin().toString(),
                    history.getRatio()
            };
            writer.writeNext(data);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> readLineByLine()  {
        try {
            CSVReader reader = new CSVReader(new FileReader("history.csv"));
            List<String[]> histories = reader.readAll();
            return histories;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
}
