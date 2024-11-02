package com.revertescript;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revertescript.functional.reversers.QueryReverser;

/**
 * This class represents a script responsible for reversing queries based on
 * their query type. Each query is parsed and reversed using a specific
 * implementation of {@link QueryReverser}. The reversed result of each query is
 * displayed in the console.
 *
 * To use this class, provide the path to a file containing the script to be
 * processed as a command-line argument. The script is read from the file,
 * queries are parsed and reversed, and the result is displayed in the console.
 *
 * Example usage:
 *
 * <pre>
 * java -jar ReverteScript path/to/file.txt
 * </pre>
 *
 * @author Luan Nadaletti
 */
@SpringBootApplication
public class ReverteScript {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ReverteScript.class, args);
	}
}
