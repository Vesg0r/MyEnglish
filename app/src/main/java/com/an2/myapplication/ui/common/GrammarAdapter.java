package com.an2.myapplication.ui.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.an2.myapplication.R;
import com.an2.myapplication.data.Grammar;

import java.util.List;

public class GrammarAdapter extends RecyclerView.Adapter<GrammarAdapter.GrammarViewHolder> {

    private List<Grammar> mGrammars;
    private OnGrammarClickListener mListener;

    public GrammarAdapter(List<Grammar> grammarList, OnGrammarClickListener listener){
        mGrammars = grammarList;
        mListener = listener;
    }
    @NonNull
    @Override
    public GrammarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new GrammarViewHolder(inflater.inflate(R.layout.list_item_grammar, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GrammarViewHolder holder, int position) {
        holder.bind(position);
        if(position == 2)holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGrammars.size();
    }

    public interface OnGrammarClickListener {
        void onClick(View v);
    }

    class GrammarViewHolder extends RecyclerView.ViewHolder {
        View mMainView;
        TextView mTextMain;
        ImageView mStarImage1;
        ImageView mStarImage2;
        ImageView mStarImage3;

        void bind(int position){
            Grammar grammar = mGrammars.get(position);
            mTextMain.setText(grammar.getString());
            mMainView.setBackground(grammar.getColorMain());
        }

        GrammarViewHolder(@NonNull View itemView) {
            super(itemView);
            mMainView = itemView.findViewById(R.id.main_view_grammar);
            mTextMain = itemView.findViewById(R.id.main_text_grammar);
            mStarImage1 = itemView.findViewById(R.id.star_image1);
            mStarImage2 = itemView.findViewById(R.id.star_image2);
            mStarImage3 = itemView.findViewById(R.id.star_image3);
        }
    }
}
