package com.kuycoding.pembelajaranfisika.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.kuycoding.pembelajaranfisika.R;
import com.kuycoding.pembelajaranfisika.quiz.QuizHelper;
import com.shreyaspatil.MaterialDialog.MaterialDialog;
import com.shreyaspatil.MaterialDialog.interfaces.DialogInterface;

import java.util.Objects;


public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    private QuizHelper quizHelper = new QuizHelper();
    private TextView tvQuestion, tvScore;
    private Button btn_a, btn_b, btn_c;
    private String mAnswer;

    private int questionNumber = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        btn_a = findViewById(R.id.btn_answer_a);
        btn_b = findViewById(R.id.btn_answer_b);
        btn_c = findViewById(R.id.btn_answer_c);
        tvQuestion = findViewById(R.id.tv_question);
        tvScore = findViewById(R.id.tv_score);
        tvScore.setText("0");

        btn_a.setOnClickListener(this);
        btn_b.setOnClickListener(this);
        btn_c.setOnClickListener(this);

        updateQuestion();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Quiz");
    }

    private void updateQuestion() {
        if (questionNumber < quizHelper.getQuestion()) {
            tvQuestion.setText(quizHelper.getQuestion(questionNumber));
            btn_a.setText(quizHelper.getChoice1(questionNumber));
            btn_b.setText(quizHelper.getChoice2(questionNumber));
            btn_c.setText(quizHelper.getChoice3(questionNumber));

            mAnswer = quizHelper.getCorrectAnswer(questionNumber);
            questionNumber++;
        } else {
            Intent intentResult = new Intent(QuizActivity.this, ResultQuizActivity.class);
            intentResult.putExtra("score", score);
            startActivity(intentResult);
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_answer_a:
                if (btn_a.getText() == mAnswer){
                    score = score + 10;
                    updateScore(score);
                    updateQuestion();
                    Toast.makeText(this, "benar", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                break;
            case R.id.btn_answer_b:
                if (btn_b.getText() == mAnswer){
                    score = score + 10;
                    updateScore(score);
                    updateQuestion();
                    Toast.makeText(this, "benar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
                break;
            case R.id.btn_answer_c:
                if (btn_c.getText() == mAnswer){
                    score = score + 10;
                    updateScore(score);
                    updateQuestion();
                    Toast.makeText(this, "benar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
        }
    }

    @SuppressLint("SetTextI18n")
    private void updateScore(int score) {
        tvScore.setText("" + score);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan Quiz", Toast.LENGTH_SHORT).show();
    }
}
