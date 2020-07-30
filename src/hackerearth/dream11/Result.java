package hackerearth.dream11;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Nikhil Bisht
 * @date 10-06-2020
 */
class Result {

    /*
     * Complete the 'topArticles' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER limit as parameter.
     */

    public static List<String> topArticles(int limit){
        PriorityQueue<Article> articlesPQ = new PriorityQueue<>();
        boolean isPageValid = true;
        for (int i = 1; i > 0; i++) {
            String response;
            try {
                response = getRequest(i);
                isPageValid = parseJsonAndFillValidArticlesPQ(response, articlesPQ);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            if (!isPageValid) break;
        }
        List<String> retArticles = new ArrayList<>();
        while (limit != 0) {
            Article tempArticle = articlesPQ.poll();
            String title = tempArticle.getTitle();
            if (title == null) {
                title = tempArticle.getStory_title();
            }
            retArticles.add(title);
            limit--;
        }
        return retArticles;
    }

    public static String getRequest(int pageNum) throws IOException {
        String url = "https://jsonmock.hackerrank.com/api/articles?page=" + pageNum;
        URL urlForGetRequest = new URL(url);
        String readLine;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            return response.toString();
        } else {
            return null;
        }
    }

    public static boolean parseJsonAndFillValidArticlesPQ(String json, PriorityQueue<Article> articlesPQ) throws ScriptException {
        ScriptEngine engine;
        ScriptEngineManager sem = new ScriptEngineManager();
        engine = sem.getEngineByName("javascript");
        String script = "Java.asJSONCompatible(" + json + ")";
        Object result = engine.eval(script);

        Map jsonAsMap = (Map) result;
        List<Map> dataArray = (List) jsonAsMap.get("data");
        if (dataArray.size() == 0) {
            return false;
        }
        for (Map articleObj : dataArray) {
            Article newArticle = new Article();
            articleObj.forEach((key, value) -> {
                if (key.equals("title")) {
                    if (value != null) {
                        newArticle.setTitle(value.toString());
                    } else {
                        newArticle.setTitle(null);
                    }
                } else if (key.equals("story_title")) {
                    if (value != null) {
                        newArticle.setStory_title(value.toString());
                    } else {
                        newArticle.setStory_title(null);
                    }
                } else if (key.equals("num_comments")) {
                    if (value != null) {
                        newArticle.setNum_comments((Integer) value);
                    } else {
                        newArticle.setNum_comments(0);
                    }
                }
            });
            if (newArticle.getTitle() != null || newArticle.getStory_title() != null) {
                articlesPQ.add(newArticle);
            }
        }
        return true;
    }

    private static class Article implements Comparable<Article> {
        private String title;
        private String story_title;
        private Integer num_comments;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStory_title() {
            return story_title;
        }

        public void setStory_title(String story_title) {
            this.story_title = story_title;
        }

        public Integer getNum_comments() {
            return num_comments;
        }

        public void setNum_comments(Integer num_comments) {
            this.num_comments = num_comments;
        }

        @Override
        public int compareTo(Article o) {
            return o.num_comments - this.num_comments;
        }
    }
}
