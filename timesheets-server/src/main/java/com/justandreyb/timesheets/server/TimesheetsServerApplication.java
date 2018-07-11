package com.justandreyb.timesheets.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.justandreyb.timesheets.server.web.TimesheetsWebClient;

/**
 * Entry point to the application
 *
 * @author justandreyb
 */
@SpringBootApplication
public class TimesheetsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimesheetsServerApplication.class, args);

        TimesheetsWebClient webClient = new TimesheetsWebClient();
        System.out.println(webClient.getResult());
    }
    
}