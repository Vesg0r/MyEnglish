package com.an2.myapplication.data;

public class Test {
    private int mProgress;
    private String mTask;
    private String mQuestion;
    private String mAnswer1;
    private String mAnswer2;
    private String mAnswer3;

    public int getProgress() { return mProgress; }
    public String getTask() { return mTask; }
    public String getQuestion() { return mQuestion; }
    public String getAnswer1() { return mAnswer1; }
    public String getAnswer2() { return mAnswer2; }
    public String getAnswer3() { return mAnswer3; }

    public Test(){
        mProgress = 20;
        mTask = "Виберить правильний переклад";
        mQuestion = "- Він чоловік?";
        mAnswer1 = "Is he a man?";
        mAnswer2 = "He is a man?";
        mAnswer3 = "Man is a he?";
    }
}
