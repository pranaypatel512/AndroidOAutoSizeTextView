package com.pranay.androidoautosizetextview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvAutoSize;
    private Button btnAddContent, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();
    }

    private void initView() {
        btnAddContent = (Button) findViewById(R.id.btnAddContent);
        btnReset = (Button) findViewById(R.id.btnReset);
        tvAutoSize = (TextView) findViewById(R.id.tvAutoSize);
        btnAddContent.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddContent:
                addStringInTextView();
                break;
            case R.id.btnReset:
                resetTextView();
                break;
        }
    }

    private void addStringInTextView() {
        tvAutoSize.setText(tvAutoSize.getText()+getString(R.string.str_add_new_text));
    }
    private void resetTextView(){
        tvAutoSize.setText(getString(R.string.this_is_autosize_textview));
        tvAutoSize.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_NONE);
        tvAutoSize.setAutoSizeTextTypeUniformWithConfiguration(12,100,2, TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
    }
}
