package com.example.zh.my;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
public String path="http://api.tianapi.com/ai/?key=11500f2566e70105ee1c28a12f5f750a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s=getData();
                Log.i("AA","ss"+s);
            }
        }).start();
    }

    private String getData() {
        try {
            URL url = new URL(path);
            //开启一个连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //判断连接是否成功
            if (connection.getResponseCode()==200) {
                //使用输入流，来获取到接口数据，读
                InputStream inputStream = connection.getInputStream();
                //使用输出流，去展示数据，写
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len=0;
                if ((len=inputStream.read(bytes))!=-1) {
                    byteArrayOutputStream.write(bytes,0,len);
                }
                String s = byteArrayOutputStream.toString();
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
return "";
    }
}
