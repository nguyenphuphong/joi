package joi;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java for Olympiad in Informatics Extension
 */
public abstract class JoiExtension {
    private static final String SPACE = " ";

    /**
     * Read a given file and return the content in array of String
     * 
     * @param filepath path of file
     * 
     * @return Array of lines
     */
    protected String[] read(String filepath) {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filepath))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filepath, e);
        }
        
        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    /**
     * Write content to a given file
     * 
     * @param filepath given file path
     * @param content content to be written
     */
    protected void write(String filepath, String content) {
        try {
            Files.write(Paths.get(filepath), (content + System.lineSeparator()).getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file: " + filepath, e);
        }
    }

    /**
     * Convert a string to array of integers
     * 
     * @param line line need to be contains only integer separated by space. Ex: "1 2 3 4"
     * @return Array of integers. Ex: [1, 2, 3, 4]
     */
    protected int[] numberize(String line) {
        String[] s = line.trim().split(SPACE);
        int[] result = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }

        return result;
    }

    /**
     * Convert an array of integers to string
     * 
     * @param numbers given array of integers. Ex: [1, 2, 3, 4]
     * @return Stringtify of array. Ex: "1 2 3 4"
     */
    protected String stringtify(int... numbers) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            builder.append(numbers[i] + SPACE);
        }
        return builder.toString().trim();
    }
}
