package com.bw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private String path = "http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=one";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                String data = getData();
                Log.e("jxm",""+data);
            }
        }).start();

    }
    //
    private String getData() {https://github.com/yujiugang/1609Ayjg.git

        try {
            URL url = new URL(path);
            //创建连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //判断条件
            if (urlConnection.getResponseCode() == 200){
                //加水管
                InputStream inputStream = urlConnection.getInputStream();
                //写出
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                //缓冲区
                byte[] bytes = new byte[1024];
                int lenghts = 0;
                //循环读取(写入)
                while ((lenghts = inputStream.read(bytes)) != -1){
                    byteArrayOutputStream.write(bytes,0,lenghts);
                }
                String s = byteArrayOutputStream.toString();
                return s;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  "";
    }
}
