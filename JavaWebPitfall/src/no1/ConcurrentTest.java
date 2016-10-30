package no1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ConcurrentTest {

    private static int thread_num = 20;
    private static int client_num = 20;

    
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        // 50个线程可以同时访问
        final Semaphore semp = new Semaphore(thread_num);
        // 模拟2000个客户端访问
        for (int index = 0; index < client_num; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Thread:" + NO);
                        String host = "http://localhost:8080/JavaWebPitfall/BadTechnobabbleLibraryServlet?";
                        String para = "";
                        if(NO % 2 == 0) {
                        	para = "userid=lifengxing";
                        }else{
                        	para = "userid=beifeng";
                        }
                        System.out.println(host + para);
                        URL url = new URL(host);// 此处填写供测试的url
                        HttpURLConnection connection = (HttpURLConnection) url
                                .openConnection();
                        // connection.setRequestMethod("POST");
                        // connection.setRequestProperty("Proxy-Connection",
                        // "Keep-Alive");
                        connection.setDoOutput(true);
                        connection.setDoInput(true);

                        PrintWriter out = new PrintWriter(connection
                                .getOutputStream());
                        out.print(para);
                        out.flush();
                        out.close();

                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(connection
                                        .getInputStream()));

                        String line = "";
                        String result = "";
                        while ((line = in.readLine()) != null) {
                            result += line;
                        }

                        System.out.println("第：" + NO + " 个");
                        semp.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
}
