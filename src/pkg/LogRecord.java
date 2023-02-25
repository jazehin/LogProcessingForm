/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg;

public class LogRecord {
    private String timestamp;
    private String user;
    private String ip;
    private String event;

    public LogRecord(String[] records) {
        this.timestamp = records[0];
        this.user = records[1];
        this.ip = records[2];
        this.event = records[3];
    }
    
    public String getTimestamp() {
        return timestamp;
    }

    public String getUser() {
        return user;
    }

    public String getIp() {
        return ip;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "(" + timestamp + ") " + user + " " + event + " eseményt váltott ki " + ip + " IP címről\n";
    }
    
    
}