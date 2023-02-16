package org.application;

import java.io.*;
import java.net.URL;
public class HttpStatusImageDownloader {

    private static final HttpStatusChecker checker = new HttpStatusChecker();

    public void downloadStatusImage(int code) throws Exception{
        URL url = new URL(checker.getStatusImage(code));

        try(InputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(String.format("%d.jpg", code)))) {
            for ( int i; (i = in.read()) != -1; ) {
                out.write(i);
            }
        } catch (Exception e) {
            throw e;
        }

    }
}
