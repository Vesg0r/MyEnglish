package com.an2.myapplication.ui.common;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.an2.myapplication.R;
import com.an2.myapplication.data.Theme;

import java.util.List;


public class ThemesAdapter extends RecyclerView.Adapter<ThemesAdapter.ThemeViewHolder> {

    private List<Theme> mThemes;
    private OnThemeClickListener mListener;

    public ThemesAdapter(List<Theme> themeList, OnThemeClickListener listener){
        mThemes = themeList;
        mListener = listener;
    }
    @NonNull
    @Override
    public ThemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ThemeViewHolder(inflater.inflate(R.layout.list_item_theme, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeViewHolder holder, int position) {
        holder.bind(position);
        if(position == 1) holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mThemes.size();
    }

    public interface OnThemeClickListener {
        void onClick(View v);
    }

    class ThemeViewHolder extends RecyclerView.ViewHolder {

        View mMainView;
        TextView mMainText;
        TextView mDescriptionText;
        View mLessonView;
        TextView mLessonText;
        ImageView mStarImage;
        TextView mPointsText;
        ProgressBar mPointsProgress;

        void bind(int position){
            Theme theme = mThemes.get(position);
            mMainView.setBackground(theme.getColor());
            mMainText.setText(theme.getMain());
            mDescriptionText.setText(theme.getDescription());
            mLessonText.setText(theme.getLesson());
            mPointsText.setText(theme.getPoints());
            mPointsProgress.setProgress(theme.getProgress());
        }

        ThemeViewHolder(@NonNull View itemView) {
            super(itemView);
            mMainView = itemView.findViewById(R.id.main_view);
            mMainText = itemView.findViewById(R.id.main_text);
            mDescriptionText = itemView.findViewById(R.id.discription_text);
            mLessonView = itemView.findViewById(R.id.lesson_view);
            mLessonText = itemView.findViewById(R.id.lesson_text);
            mStarImage = itemView.findViewById(R.id.star_image);
            mPointsText = itemView.findViewById(R.id.points_text);
            mPointsProgress = itemView.findViewById(R.id.progressBar);
        }
    }
}
