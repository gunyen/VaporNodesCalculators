package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Coin {

    static Pattern DOUBLE_PATTERN = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");

    public static double coinPrice(String coin) throws IOException {
        // Make a URL to the web page
        URL url = new URL(coin);

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = null;

            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                double[] nums = Arrays.stream(line.replaceAll("[^0-9.]+", " ").trim().split(" ")).mapToDouble(Double::parseDouble).toArray();
                if (nums.length > 1) {
                    return nums[1];
                } else {
                    return nums[0];
                }
            }
        }
        return -1;

    }

//    public static double[] extractDoubles(String input) {
//        return DOUBLE_PATTERN.matcher(input).results()
//                .mapToDouble(m -> Double.parseDouble(m.group()))
//                .toArray();
//    }
}
