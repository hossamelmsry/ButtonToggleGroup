package com.elzayet.buttontogglegroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import static android.view.View.NO_ID;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MaterialButtonToggleGroup materialButtonToggleGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialButtonToggleGroup = findViewById(R.id.activity_main_togglebutton);

        findViewById(R.id.activity_main_getchecked).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (materialButtonToggleGroup.isSingleSelection()) {
                    getCheckedButton();
                } else {
                    getCheckedButtons();
                }
            }
        });
    }

    private void getCheckedButtons() {
        List<Integer> checkedButtonIds = materialButtonToggleGroup.getCheckedButtonIds();
        Log.i(MainActivity.class.getSimpleName(), "getCheckedButtons(): " + checkedButtonIds.size());
        if (checkedButtonIds.size() > 0) {
            String toastText = "";
            for (Integer buttonId: checkedButtonIds) {
                MaterialButton checkedButton = findViewById(buttonId);
                String buttonText = checkedButton.getText().toString();
                toastText += buttonText + ", ";
            }
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
        }
    }

    private void getCheckedButton() {
        int checkedButtonId = materialButtonToggleGroup.getCheckedButtonId();
        Log.i(MainActivity.class.getSimpleName(), "getCheckedButton(): " + checkedButtonId);
        if (checkedButtonId != NO_ID) {
            MaterialButton checkedButton = findViewById(checkedButtonId);
            String buttonText = checkedButton.getText().toString();
            Toast.makeText(this, buttonText, Toast.LENGTH_SHORT).show();
        }
    }
}