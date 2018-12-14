/*
 * IPCamImageView - IPCamView.java
 * Created by Marcos Calvo García on 14/12/18 16:14.
 * Copyright (c) 2018. All rights reserved.
 *
 * Last modified 14/12/18 16:14.
 */

package com.marcoscg.ipcamview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class IPCamView extends ImageView {

    private Bitmap bitmap = null;
    private boolean run = false;
    private String url = null;
    private int interval = 1000;

    public IPCamView(Context context) {
        super(context);
    }

    public IPCamView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public IPCamView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    public IPCamView setUrl(String url) {
        this.url = url;
        return this;
    }

    public IPCamView setInterval(int interval) {
        this.interval = interval;
        return this;
    }

    public void start() {
        if (url == null || run)
            return;

        run = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    try {
                        bitmap = getBitmapFromURL(url + "?" + System.currentTimeMillis());
                        post(new Runnable() {
                            public void run() {
                                setImageBitmap(bitmap);
                            }
                        });

                        Thread.sleep(interval);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void start(String url) {
        setUrl(url);
        start();
    }

    public void stop() {
        run = false;
    }

    private Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IPCamView, defStyleAttr, 0);
            try {
                url = typedArray.getString(R.styleable.IPCamView_url);
                interval = typedArray.getInteger(R.styleable.IPCamView_interval, 1000);
            } finally {
                typedArray.recycle();
            }
        }
    }

}

