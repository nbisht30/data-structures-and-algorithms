package hackerearth.dream11;

import javax.script.ScriptException;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class Solution {
    public static void main(String[] args) throws IOException, ScriptException, NoSuchMethodException {

        int limit = 2;

        List<String> result = Result.topArticles(limit);

        for (int i = 0; i < result.size(); i++) {
            System.out.println((result.get(i)));
        }
    }
}
