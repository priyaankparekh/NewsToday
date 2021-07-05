package com.example.newstoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailedView extends AppCompatActivity {

    TextView tvTitle,tvDate,tvSource,tvDescription;
    WebView webView;
    ImageView webImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        tvTitle = findViewById(R.id.tvTitle);
        tvDate = findViewById(R.id.tvDate);
        tvSource = findViewById(R.id.tvSource);
        tvDescription = findViewById(R.id.tvDescription);
        webImageView = findViewById(R.id.webImageView);
        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String date = intent.getStringExtra("time");
        String description = intent.getStringExtra("description");
        String imageUrl = intent.getStringExtra("urlToImage");
        String url = intent.getStringExtra("url");

        tvTitle.setText(title);
        tvDate.setText(date);
        tvSource.setText(source);
        tvDescription.setText(description);

        Picasso.with(DetailedView.this).load(imageUrl).into(webImageView);

        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}