package seedu.address.logic.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;


/**
 * Method to Keep Track of User Activity Log
 */
public class LoggingCommand {
    private final Logger logger = LogsCenter.getLogger(LoggingCommand.class);
    /**
     *keepLog Method
     */
    public void keepLog(String logText, String functionType) {
        try (FileWriter fileWrite = new FileWriter("src/test/data/XMLUtilTest/ConnectUsLog.txt", true);
             BufferedWriter buffWriter = new BufferedWriter(fileWrite);
             PrintWriter out = new PrintWriter(buffWriter)) {
            out.println(functionType + "\t" + logText + "\t" + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.out.println("Error With ConnectUs.txt Logging");
        }
    }
}