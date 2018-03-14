package foiled.boggle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.randomButton) Button mRandomButton;
    @BindView(R.id.submitUserInputButton) Button mSubmitUserInputButton;
    @BindView(R.id.userInput) EditText mUserInput;
    GridView gridView;

    private Random randomGenerator;
    private ArrayList<String> output = new ArrayList<String>();
    private String[] alphas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] vowels = {"A", "E", "I", "O", "U"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mSubmitUserInputButton.setOnClickListener(this);

        for(int i = 0 ;output.size() < 8; i++){
            if (output.size() < 2) {
                randomGenerator = new Random();
                output.add(vowels[randomGenerator.nextInt(vowels.length)]);
            } else {
                randomGenerator = new Random();
                output.add(alphas[randomGenerator.nextInt(alphas.length)]);
            }
        }

        Collections.shuffle(output);
        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new AlphaAdapter(this, output));

    }

    @Override
    public void onClick(View v) {
        if( v == mSubmitUserInputButton) {
            String userInput = mUserInput.getText().toString();
            Toast.makeText(MainActivity.this, userInput, Toast.LENGTH_LONG).show();
        }
    }

}
