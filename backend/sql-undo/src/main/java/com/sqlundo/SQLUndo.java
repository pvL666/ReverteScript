package com.sqlundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author Luan Nadaletti
 */
@SpringBootApplication
public class SQLUndo {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SQLUndo.class, args);
    }
}
