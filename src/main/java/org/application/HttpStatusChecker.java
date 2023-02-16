package org.application;

import javax.xml.crypto.URIReferenceException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        String urlText = String.format("https://http.cat/%d.jpg", code);
        URL url = new URL(urlText);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if(httpURLConnection.getResponseCode() != 200)
            throw new URIReferenceException("There is not image for HTTP status " + code);
        return urlText;
    }
}
