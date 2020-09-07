package com.an2.myapplication.data;
import android.graphics.drawable.Drawable;

public class Theme {
    private String mMain;
    private String mDescription;
    private String mLesson;
    private String mPoints;
    private int mProgress;
    private Drawable mColorMain;


    public String getMain() {
        return mMain;
    }
    public String getDescription() { return mDescription; }
    public int getProgress() { return mProgress; }
    public String getLesson() { return mLesson; }
    public String getPoints() { return mPoints; }
    public Drawable getColor() { return mColorMain; }


    public Theme(String s, Drawable color){
        switch (s)
        {
            case "Start":{
                mMain = "Початковий курс";
                mDescription = "Почни говорити англійською! Запам'ятовуй найпотрібніші " +
                        "фрази для щоденного спілкування.";
                mLesson = "5 уроків";
                this.mColorMain = color;
                mPoints = "0/15";
                mProgress = 0;
                break;
            }
            case "Grammar":{
                mMain = "Граматика";
                mDescription = "Почни будувати речення англійською! Дізнайся, що іноді можна обійтись" +
                        "без артикля.";
                mLesson = "6 уроків";
                this.mColorMain = color;
                mPoints = "6/30";
                mProgress = 20;
                break;
            }
            case "Verb":{
                mMain = "Дієслова";
                mDescription = "Найпопулярніші фразові дієслова для всіх випадків життя. Збагати свою" +
                        "промову складною розмоною лексикою. Прикинься, що англійська - твоя рідна мова!";
                mLesson = "15 уроків";
                this.mColorMain = color;
                mPoints = "0/50";
                mProgress = 0;
                break;
            }
        }
    }
}
