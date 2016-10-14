package com.but42.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by but on 14.10.2016.
 */
public class CheatActivity extends Activity {
    public static final String EXTRA_ANSWER_IS_TRUE = "com.but42.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.but42.geoquiz.answer_shown";

    private static final String KEY_RESULT = "result";
    private boolean mResult = false;

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswerButton;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        if (savedInstanceState != null) {
            mResult = savedInstanceState.getBoolean(KEY_RESULT);
            setText(mAnswerIsTrue);
        }

        setAnswerShownResult(mResult);

        mShowAnswerButton = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(mAnswerIsTrue);
                mResult = true;
                setAnswerShownResult(mResult);
            }
        });
    }

    private void setText(boolean mAnswerIsTrue) {
        if (mAnswerIsTrue)
            mAnswerTextView.setText(R.string.true_button);
        else
            mAnswerTextView.setText(R.string.false_button);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_RESULT, mResult);
    }
}
