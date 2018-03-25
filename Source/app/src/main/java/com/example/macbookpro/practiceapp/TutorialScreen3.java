package com.example.macbookpro.practiceapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialScreen3 extends Fragment {


    public TutorialScreen3() {
        // Required empty public constructor
    }

    public static TutorialScreen3 newInstance() {
        
        Bundle args = new Bundle();
        
        TutorialScreen3 fragment = new TutorialScreen3();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial_screen3, container, false);
    }

}
