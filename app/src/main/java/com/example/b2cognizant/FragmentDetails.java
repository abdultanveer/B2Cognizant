package com.example.b2cognizant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetails extends Fragment {
    TextView detailsTv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view = inflater.inflate(R.layout.details_fragment,container,false);
         detailsTv = view.findViewById(R.id.tvDetails);
        return view;
    }

    public void updateTextview(String headline) {
        detailsTv.setText(headline);
    }
}
