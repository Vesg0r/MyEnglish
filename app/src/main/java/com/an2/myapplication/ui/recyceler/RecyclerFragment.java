package com.an2.myapplication.ui.recyceler;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.an2.myapplication.HeaderListener;
import com.an2.myapplication.R;
import com.an2.myapplication.data.Grammar;
import com.an2.myapplication.data.Test;
import com.an2.myapplication.data.Theme;
import com.an2.myapplication.data.Theory;
import com.an2.myapplication.data.Vocabulary;
import com.an2.myapplication.ui.common.GrammarAdapter;
import com.an2.myapplication.ui.common.TestAdapter;
import com.an2.myapplication.ui.common.ThemesAdapter;
import com.an2.myapplication.ui.common.TheoryAdapter;
import com.an2.myapplication.ui.common.VocabularyAdapter;
import java.util.ArrayList;
import java.util.Objects;

public class RecyclerFragment extends Fragment {
    private final String THEMES = "THEMES";
    private final String GRAMMAR ="GRAMMAR";
    private final String THEORY ="THEORY";
    private final String TEST = "TEST";
    private final String VOCABULARY = "VOCABULARY";
    private String type;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString("TYPE", "");
        }
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        switch (type) {
            case THEMES: {
                if(getActivity() != null) {
                    ((HeaderListener) getActivity()).setTitle("Теми");
                }
                ArrayList<Theme> themes = new ArrayList<>();
                themes.add(new Theme("Start", ContextCompat.getDrawable(getContext(),R.drawable.rectstart)));
                themes.add(new Theme("Grammar",ContextCompat.getDrawable(getContext(),R.drawable.rectgramm)));
                themes.add(new Theme("Verb",ContextCompat.getDrawable(getContext(),R.drawable.rectverb)));
                mAdapter = new ThemesAdapter(themes, new ThemesAdapter.OnThemeClickListener() {
                    @Override
                    public void onClick(View v) {
                        RecyclerFragment fragment = new RecyclerFragment();
                        Bundle arguments = new Bundle();
                        arguments.putString("TYPE","GRAMMAR");
                        fragment.setArguments(arguments);
                        Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, fragment)
                                .addToBackStack(fragment.toString())
                                .commit();
                    }
                });
                break;
            }
            case GRAMMAR: {
                if(getActivity() != null) {
                    ((HeaderListener) getActivity()).setTitle("Граматика");
                }
                ArrayList<Grammar> grammars = new ArrayList<>();
                grammars.add(new Grammar("first",ContextCompat.getDrawable(getContext(),R.drawable.rectstart)));
                grammars.add(new Grammar("second",ContextCompat.getDrawable(getContext(),R.drawable.rectgramm)));
                grammars.add(new Grammar("third",ContextCompat.getDrawable(getContext(),R.drawable.rectverb)));
                grammars.add(new Grammar("fourth",ContextCompat.getDrawable(getContext(),R.drawable.rectfourth)));
                grammars.add(new Grammar("fifth",ContextCompat.getDrawable(getContext(),R.drawable.rectstart)));
                grammars.add(new Grammar("sixth",ContextCompat.getDrawable(getContext(),R.drawable.rectgramm)));
                mAdapter = new GrammarAdapter(grammars, new GrammarAdapter.OnGrammarClickListener() {
                    @Override
                    public void onClick(View v) {
                        RecyclerFragment fragment = new RecyclerFragment();
                        Bundle arguments = new Bundle();
                        arguments.putString("TYPE","THEORY");
                        fragment.setArguments(arguments);
                        Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, fragment)
                                .addToBackStack(fragment.toString())
                                .commit();
                    }
                });
                break;
            }
            case THEORY: {
                if(getActivity() != null) {
                    ((HeaderListener) getActivity()).setTitle("Теорітичні відомості");
                }
                ArrayList<Theory> theory = new ArrayList<>();
                theory.add(new Theory());
                mAdapter = new TheoryAdapter(theory, new TheoryAdapter.OnTheoryClickListener() {
                    @Override
                    public void onClick(View v) {
                        RecyclerFragment fragment = new RecyclerFragment();
                        Bundle arguments = new Bundle();
                        arguments.putString("TYPE","TEST");
                        fragment.setArguments(arguments);
                        Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, fragment)
                                .addToBackStack(fragment.toString())
                                .commit();
                    }
                });
                break;
            }
            case TEST: {
                if(getActivity() != null) {
                    ((HeaderListener) getActivity()).setTitle("Тест");
                }
                ArrayList <Test> test = new ArrayList<>();
                test.add(new Test());
                mAdapter = new TestAdapter(test, new TestAdapter.OnTestClickListener() {
                    @Override
                    public void onClick(View v) { }
                });
                break;
            }
            case VOCABULARY: {
                if(getActivity() != null) {
                    ((HeaderListener) getActivity()).setTitle("Словник");
                }
                ArrayList<Vocabulary> vocabulary = new ArrayList<>();
                vocabulary.add(new Vocabulary());
                mAdapter = new VocabularyAdapter(vocabulary, new VocabularyAdapter.OnVocabularyClickListener() {
                    @Override
                    public void onClick(View v) { }
                });
                break;
            }
        }
        mRecyclerView.setAdapter(mAdapter);
    }
}