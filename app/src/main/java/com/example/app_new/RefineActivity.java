package com.example.app_new;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RefineActivity extends AppCompatActivity {



    private Spinner spinnerAvailability;
    private EditText editTextStatus;
    private SeekBar seekBarDistance;
    private Button buttonSaveExplore;

   private Button coffee,business,hobbies,friendship,movies,dinning;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_refine);

        spinnerAvailability = findViewById(R.id.spinnerAvailability);
        editTextStatus = findViewById(R.id.editTextStatus);
        seekBarDistance = findViewById(R.id.seekBarDistance);
        buttonSaveExplore = findViewById(R.id.buttonSaveExplore);

        buttonSaveExplore.setOnClickListener(view -> saveData());


        coffee=findViewById(R.id.buttonCoffee);
        business=findViewById(R.id.buttonbusiness);
        hobbies=findViewById(R.id.buttonhobbies);
        friendship=findViewById(R.id.buttonfriendship);
        movies=findViewById(R.id.buttonmovies);
        dinning=findViewById(R.id.buttondinning);
        // Set click listeners for the buttons
        setButtonColorToggle(coffee);
        setButtonColorToggle(business);
        setButtonColorToggle(hobbies);
        setButtonColorToggle(friendship);
        setButtonColorToggle(movies);
        setButtonColorToggle(dinning);


    }

    private void saveData() {
        String status = editTextStatus.getText().toString();
        int distance = seekBarDistance.getProgress();
        String availability = spinnerAvailability.getSelectedItem().toString();

        // Process data or show a toast for demonstration
        Toast.makeText(this, "Saved with status: " + status + ", Distance: " + distance + "km, Availability: " + availability, Toast.LENGTH_LONG).show();
        Intent intent=new Intent(RefineActivity.this, ExploreFragment.class);
        startActivity(intent);
        finish();
    }


    private void setButtonColorToggle(final Button button) {
        // Initial state of the button color flag
        button.setTag(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isColorChanged = (boolean) button.getTag();
                if (isColorChanged) {
                    // Revert to original color
                    button.setBackgroundColor(Color.parseColor("#ffffff")); // replace with your original color
                } else {
                    // Change to new color
                    button.setBackgroundColor(Color.parseColor("#FF3700B3")); // replace with your new color
                }
                // Toggle the color state
                button.setTag(!isColorChanged);
            }
        });
    }


    }
