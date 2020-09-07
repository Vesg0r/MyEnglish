package com.an2.myapplication.ui.common;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.an2.myapplication.R;
import com.an2.myapplication.data.Vocabulary;
import java.util.List;

public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.VocabularyViewHolder>
{
    private List<Vocabulary> mVocabulary;
    private VocabularyAdapter.OnVocabularyClickListener mListener;

    public VocabularyAdapter(List<Vocabulary> vocabularyList, OnVocabularyClickListener listener){
        mVocabulary = vocabularyList;
        mListener = listener;
    }
    @NonNull
    @Override
    public VocabularyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new VocabularyViewHolder(inflater.inflate(R.layout.list_item_vocabulary, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VocabularyViewHolder holder, int position) {
        holder.bind(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mVocabulary.size();
    }

    public interface OnVocabularyClickListener {
        void onClick(View v);
    }

    class VocabularyViewHolder extends RecyclerView.ViewHolder {
    TextView mVocabularyText;
        void bind(int position) {
            Vocabulary vocabulary = mVocabulary.get(position);
            mVocabularyText.setText(vocabulary.GetVocabularyText());
        }
        VocabularyViewHolder(@NonNull View itemView) {
            super(itemView);
            mVocabularyText = itemView.findViewById(R.id.vocabulary_text);
        }
    }
}
