package proj;

import model.Separator;

import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailService {
    static ArrayList<String> emails = Reader.getEmails();
    static ArrayList <Separator> list = toList(emails);
    public static int messagesSize;

    public static int getMessagesSize() {
        return messagesSize;
    }

    public static void main(String[] args) {
        Random random = new Random();

        String messages[] ={"Hi","Never gonna die", "lets goooooo", "okkkk", "Winner winner chicken dinner " , "I love java"};

        ExecutorService thread = Executors.newSingleThreadExecutor();

        thread.execute(() -> {
            for (Separator person : list) {
                person.setMessage(messages[random.nextInt(1,5)]);
            }
        });
        System.out.println(list);
        WriteService.writeInfo();


    }

    private static ArrayList<Separator> toList(ArrayList<String> emails) {


        ArrayList<Separator> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2})");

        for (String line : Reader.getEmails()) {
            LocalDateTime time = LocalDateTime.now();
            Matcher matcherDate = pattern.matcher(line);
            if (matcherDate.find()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                TemporalAccessor accessor = formatter.parse(matcherDate.group());
                LocalDateTime times = LocalDateTime.from(accessor);
                time=times;
            }
            String emailer =line.substring(22, 39);
            String email = line.substring(39, 71);
            String message = line.substring(71, 93);



                list.add(new Separator(time,emailer,email,message));
            }


        return list;
    }
    static int size(){
        System.out.println("Email larning soni : ");
        return list.size();

    }
}
