package com.an2.myapplication.ui.common;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.an2.myapplication.R;
import com.an2.myapplication.data.Theory;

import java.util.List;

public class TheoryAdapter extends RecyclerView.Adapter<TheoryAdapter.TheoryViewHolder>{

    private List<Theory> mTheory;
    private TheoryAdapter.OnTheoryClickListener mListener;

    public TheoryAdapter(List<Theory> theoryList, TheoryAdapter.OnTheoryClickListener listener)
    {
        mTheory = theoryList;
        mListener = listener;
    }

    @NonNull
    @Override
    public TheoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TheoryViewHolder(inflater.inflate(R.layout.list_item_theory, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TheoryViewHolder holder, int position) {
        holder.bind(position);
        holder.mStarTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v);
            }
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v);
            }*/
        });
    }

    @Override
    public int getItemCount() {
        return mTheory.size();
    }

    public interface OnTheoryClickListener {
        void onClick(View v);
    }

    class TheoryViewHolder extends RecyclerView.ViewHolder {

        TextView mMainText;
        Button mStarTestButton;
        void bind(int position){
            Theory theory = mTheory.get(position);
            mMainText.setText(theory.getTheory());
        }

        TheoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mMainText = itemView.findViewById(R.id.main_text_theory);
            mStarTestButton = itemView.findViewById(R.id.start_test);
        }
    }
}

