package seedu.address.logic.commands;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Method to Keep Track of User Activity Log
 */
//@@author danielweide
public class LoggingCommand {
    /**
     *keepLog Method to Write Activity Log To The ConnectUsLog.txt file
     */
    public void keepLog(String logText, String functionType) {
        try (FileWriter fileWrite = new FileWriter("ConnectUsLog.txt", true);
             BufferedWriter buffWriter = new BufferedWriter(fileWrite);
             PrintWriter out = new PrintWriter(buffWriter)) {
            out.println(functionType + "\t" + logText + "\t" + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.out.println("Error With ConnectUs.txt Logging");
        }
    }
    /**
     * startUpLog Method will record the time when the application starts
     */
    public void startUpLog() {
        try (FileWriter fileWrite = new FileWriter("ConnectUsLog.txt", true);
             BufferedWriter buffWriter = new BufferedWriter(fileWrite);
             PrintWriter out = new PrintWriter(buffWriter)) {
            out.println("Application Started on " + LocalDateTime.now());
        } catch (IOException e) {
            System.out.println("Error With ConnectUs.txt Logging");
        }
    }
}
