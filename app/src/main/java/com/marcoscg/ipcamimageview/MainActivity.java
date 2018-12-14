package com.marcoscg.ipcamimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.marcoscg.ipcamview.IPCamView;

public class MainActivity extends AppCompatActivity {

    private IPCamView ipCamView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipCamView = findViewById(R.id.ip_cam_view);
        ipCamView.setUrl("http://webcam.abaco-digital.es/zuda/image2.jpg");
        ipCamView.setInterval(1000); // In milliseconds, default 1000
        ipCamView.start();
    }

    public void stop(View v) {
        ipCamView.stop();
    }

    public void start(View v) {
        ipCamView.start();
    }
}
