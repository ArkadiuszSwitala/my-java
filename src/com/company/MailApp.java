package com.company;

import com.company.helper.Mailer;

public class MailApp {

    public static void main(String[] args) {

        String to = "switek2411@vp.pl";
        String message = "Hej, co u Ciebie? To jest test.";

        Mailer mailer = new Mailer();
        mailer.send(to, message);
    }
}
