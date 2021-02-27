package com.example.TrackHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URISyntaxException;
import java.sql.SQLException;

@SpringBootApplication
public class ZTrackApplication {

    public static void main(String[] args) throws URISyntaxException, SQLException {
        SpringApplication.run(ZTrackApplication.class, args);
    }

}
