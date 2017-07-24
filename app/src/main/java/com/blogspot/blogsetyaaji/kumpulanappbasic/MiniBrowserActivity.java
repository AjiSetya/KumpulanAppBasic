package com.blogspot.blogsetyaaji.kumpulanappbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MiniBrowserActivity extends AppCompatActivity {

    @BindView(R.id.txtweburl)
    EditText txtweburl;
    @BindView(R.id.btnbukaweb)
    Button btnbukaweb;
    @BindView(R.id.webbrowser)
    WebView webbrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_browser);
        ButterKnife.bind(this);

        txtweburl.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    tampilWeb();
                    return true;
                }
                return false;
            }
        });
    }

    @OnClick(R.id.btnbukaweb)
    public void onViewClicked() {
        tampilWeb();
        String url = txtweburl.getText().toString();
        webbrowser.getSettings().setJavaScriptEnabled(true);
        webbrowser.loadUrl(url);
        webbrowser.setWebViewClient(new WebTampil());
    }

    private void tampilWeb() {
        String url = txtweburl.getText().toString();
        webbrowser.getSettings().setJavaScriptEnabled(true);
        webbrowser.loadUrl(url);
        webbrowser.setWebViewClient(new WebTampil());
    }

    private class WebTampil extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN){
            switch (keyCode){
                case KeyEvent.KEYCODE_BACK:
                    if (webbrowser.canGoBack()){
                        webbrowser.goBack();
                    } else {
                        Toast.makeText(this, "Tutup browser", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
