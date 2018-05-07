package com.bignerdranch.android.test6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private WebView webView;
    private Button btn_go;
    private EditText et_url;
    private String urlHead="http://";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }



    private void initView() {
        btn_go= (Button) findViewById(R.id.button);
        et_url= (EditText) findViewById(R.id.Edit);
        btn_go.setOnClickListener(this);
        WebView webView= (WebView)findViewById(R.id.my_webView);
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        webView.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        //自适应屏幕
      //  webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
       // webView.getSettings().setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);   //在当前的webview中跳转到新的url

                return true;
            }



});

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlHead+et_url.getText().toString()));
                Intent choose=Intent.createChooser(intent,"选择一个浏览器");
                startActivity(choose);
                break;
        }
    }
}

