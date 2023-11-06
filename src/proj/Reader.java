package proj;

import model.Separator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    static private ArrayList<String> emails = new ArrayList<String>();
    static void findItem() {

        BufferedReader fileReader;


        try {
            fileReader = new BufferedReader(new FileReader("files/emails.txt"));


            String line;
            for (int i = 0; (line = fileReader.readLine())!=null ; i++) {
                emails.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {


        }
    }



    public static ArrayList<String> getEmails() {
        findItem();
        return emails;
    }
}

