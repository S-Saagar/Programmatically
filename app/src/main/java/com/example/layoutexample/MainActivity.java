package com.example.layoutexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CustomLayout customLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customLayout = new CustomLayout(this);
        setContentView(customLayout);

        customLayout.button_right.setOnClickListener(clickedButton());
        customLayout.button_left.setOnClickListener(clickedButton());
    }

    private View.OnClickListener clickedButton() {
        return v -> {
            switch (v.getId()) {
                case R.id.button_right:
                    Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_left:
                    Toast.makeText(MainActivity.this, "Left", Toast.LENGTH_SHORT).show();
                    break;
            }
        };
    }
}
