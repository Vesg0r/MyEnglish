package com.an2.myapplication.ui.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.an2.myapplication.R;
import com.an2.myapplication.data.Test;
import com.an2.myapplication.data.Theme;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {
    private List<Test> mTest;
    private TestAdapter.OnTestClickListener mListener;
    public TestAdapter(ArrayList<Test> testList, OnTestClickListener listener) {
        mTest = testList;
        mListener = listener;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TestAdapter.TestViewHolder(inflater.inflate(R.layout.list_item_test, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        holder.bind(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v);
            }
        });
    }
    public interface OnTestClickListener {
        void onClick(View v);
    }

    @Override
    public int getItemCount() {
        return mTest.size();
    }

    public class TestViewHolder extends RecyclerView.ViewHolder{
        ProgressBar mProgress;
        TextView mTask;
        TextView mQuestion;
        Button mAnswer1;
        Button mAnswer2;
        Button mAnswer3;
        public void bind(int position) {
            Test test = mTest.get(position);
            mProgress.setProgress(test.getProgress());
            mTask.setText(test.getTask());
            mQuestion.setText(test.getQuestion());
            mAnswer1.setText(test.getAnswer1());
            mAnswer2.setText(test.getAnswer2());
            mAnswer3.setText(test.getAnswer3());
        }
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            mProgress = itemView.findViewById(R.id.TestProgress);
            mTask = itemView.findViewById(R.id.task_text);
            mQuestion = itemView.findViewById(R.id.question_text);
            mAnswer1 = itemView.findViewById(R.id.answer1);
            mAnswer2 = itemView.findViewById(R.id.answer2);
            mAnswer3 = itemView.findViewById(R.id.answer3);
        }


    }

}
