/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class LogReader {

    private List<LogRecord> records;

    public LogReader() {
        this.records = new ArrayList<>();
    }

    // 1. megoldás: arraylist nélkül, direkt módon kiírja
    public void readLogFile(JTextArea jta_logs, String event) throws IOException {
        String filename = "log.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        jta_logs.setText("");

        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] fields = splitLogData(line);
            LogRecord record = new LogRecord(fields);
            
            if (record.getEvent().equals(event)) {
                jta_logs.append(record.toString());
            }
        }

        reader.close();
    }
    
    // 2. megoldás: arraylistet térít vissza a feltétel által szűrve
    public ArrayList<LogRecord> readLogFileToArrayList(JTextArea jta_logs, String event) throws IOException {
        ArrayList<LogRecord> list = new ArrayList<>(); 
        String filename = "log.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        jta_logs.setText("");

        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] fields = splitLogData(line);
            LogRecord record = new LogRecord(fields);
            list.add(record);
        }

        reader.close();
        return list;
    }

    // .split() megoldás
    private String[] splitLogData(String logData) {
        List<String> fields = new ArrayList<>();
        StringBuilder fieldBuilder = new StringBuilder();

        for (int i = 0; i < logData.length(); i++) {
            char c = logData.charAt(i);

            if (c == ';') {
                fields.add(fieldBuilder.toString());
                fieldBuilder = new StringBuilder();
            } else {
                fieldBuilder.append(c);
            }
        }

        fields.add(fieldBuilder.toString());

        return fields.toArray(new String[0]);
    }
}
