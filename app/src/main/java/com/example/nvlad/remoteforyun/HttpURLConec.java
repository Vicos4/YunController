package com.example.nvlad.remoteforyun;

import android.app.Application;

import java.net.HttpURLConnection;

public class HttpURLConec extends Application
{
    //public URl url = null;
    public HttpURLConnection con = null;

    public HttpURLConnection getGlobalVariable() {
        return con;
    }





}
