package com.but42.geoquiz;

/**
 * Created by mikhail on 12/10/16.
 */
public class TrueFalse {
    private int mQuestion;

    private boolean mTrueQuestion;
    private boolean mIsCheater;

    public TrueFalse(int question, boolean trueQuestion, boolean isCheater) {
        this.mQuestion = question;
        this.mTrueQuestion = trueQuestion;
        this.mIsCheater = isCheater;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public boolean isCheater() {
        return mIsCheater;
    }

    public void setCheater(boolean cheater) {
        mIsCheater = cheater;
    }
}
