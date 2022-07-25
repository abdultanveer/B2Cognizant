package com.example.b2cognizant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHeadlines extends Fragment implements AdapterView.OnItemClickListener {
    ListView headlinesListView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view = inflater.inflate(R.layout.headlines_fragment,container,false);
         headlinesListView = view.findViewById(R.id.headlinesLv);
         headlinesListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowView) {
        String itemClicked = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(getContext(), itemClicked, Toast.LENGTH_SHORT).show();
    }
}
