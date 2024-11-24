package SeleniumWebDriverPart1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class VerifyLinkStatus {

    private static int invalidLinkCount = 0;

    /**
     * Verifies the status of a given link.
     *
     * @param link URL of the link to verify.
     * @throws IOException if an I/O exception occurs.
     */
    public static void verifyLink(String link) throws IOException {

        if (link != null && !link.isEmpty()) {
            try {
                URL url = new URL(link);

                // Open HTTP Connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Set Timeout
                connection.setConnectTimeout(3000);

                // Set request method to HEAD to check headers only
                connection.setRequestMethod("HEAD");

                // Connect to the URL
                connection.connect();

                // Check response code
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
//                    System.out.println(link + " : " + connection.getResponseMessage() + " : Valid Link");
                } else {
                    System.out.println(link + " : " + connection.getResponseMessage() + " : " + responseCode);
                    invalidLinkCount++;
                }

                // Disconnect the connection
                connection.disconnect();

            } catch (MalformedURLException e) {
                System.out.println(link + " : Malformed URL");
            } catch (IOException e) {
                System.out.println(link + " : Unable to connect");
            }
        } else {
            System.out.println("Link is either null or empty.");
        }
    }

    /**
     * Prints the total count of invalid links.
     */
    public static void getInvalidLinkCount() {
        System.out.println("Total Invalid Links: " + invalidLinkCount);
    }
}
