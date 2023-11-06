package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Separator {
    private LocalDateTime time;
    private String mailer;
    private String email;
    private String message;


    public Separator(java.time.LocalDateTime time, String mailer, String email, String message) {
        this.time = time;
        this.mailer = mailer;
        this.email = email;
        this.message = message;
    }

    @Override
    public String toString() {
        return  time + " " + mailer + " " + email + " "+  message + "\n";
    }
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }



    public String getMailer() {
        return mailer;
    }

    public void setMailer(String mailer) {
        this.mailer = mailer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message += ", "+message;
    }
}
