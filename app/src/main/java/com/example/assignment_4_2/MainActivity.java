package com.example.assignment_4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText userName, comment;
    Button bttnSubmit;
    TextView commentsView;
    ArrayList<String> comments = new ArrayList();
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText)findViewById(R.id.userName);
        comment = (EditText)findViewById(R.id.comment);
        bttnSubmit = (Button) findViewById(R.id.buttonSubmit);
        commentsView = (TextView) findViewById(R.id.comments);

        bttnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean feedback = false;
                if (userName.getText().length() == 0) {
                    userName.setBackgroundColor(Color.rgb(254, 150, 150));
                    feedback = true;
                }
                if (comment.getText().length() == 0) {
                    comment.setBackgroundColor(Color.rgb(254, 150, 150));
                    feedback = true;
                }
                if (feedback)
                    Toast.makeText(getBaseContext(), "Missing data!", Toast.LENGTH_SHORT).show();
                else {
                    count++;
                    addComments(userName.getText().toString(), comment.getText().toString());
                    String viewComments = fetchComments();
                    commentsView.setText(viewComments);
            }
            }
        });
    }
    void addComments(String userName, String comment) {
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        String format = s.format(new Date());
        String commentNew = count + "\t|\t " + format + " \t|\t " + userName + " \t|\t " + comment;
        this.comments.add(commentNew);
    }

    String fetchComments() {
        String s="";
        for (int i=0; i<comments.size();i++) {
            s += comments.get(i) + "\n";
        }
        return s;
    }
}
