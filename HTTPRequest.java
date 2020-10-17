import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest {
    public HTTPRequest() {
    }

    public String makeRequest(String URLString) {
        try {
            URL customURL = new URL(URLString);
            HttpURLConnection customHTTPConnection = (HttpURLConnection) customURL.openConnection();
            customHTTPConnection.setRequestMethod("GET");
            if (customHTTPConnection.getResponseCode() == 200) {
                return getJSONString(customHTTPConnection.getInputStream());
            }


        } catch (IOException e) {
        }

        return "Something is not right. Check your internet connection";

    }

    public String getJSONString(InputStream inputStream) {
        try {
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            StringBuffer JSONStringBuffer = new StringBuffer();
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                JSONStringBuffer.append(string);
            }

            return JSONStringBuffer.toString();
        } catch (IOException e) {
        }

        return null;
    }
}
