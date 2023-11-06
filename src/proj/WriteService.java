package proj;

import model.Separator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteService {
    private static final Logger LOGGER = Logger.getLogger(WriteService.class.getName());
        static void writeInfo(){

            String reportFilePath = "files/e-mail_analysis_report.txt";
            try {
                 BufferedWriter writer = new BufferedWriter(new FileWriter(reportFilePath));


                    //Пишем сводный отчет
                    writer.write("Total emails :  "  + EmailService.size());
                    LOGGER.info("No way");
                    writer.newLine();
                    writer.write("Messages:  " + EmailService.getMessagesSize());
                    writer.newLine();

             } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}