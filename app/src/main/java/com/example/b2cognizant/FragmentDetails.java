package com.example.b2cognizant;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetails extends Fragment implements View.OnClickListener {
    TextView detailsTv;
    Button putButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view = inflater.inflate(R.layout.details_fragment,container,false);
         detailsTv = view.findViewById(R.id.tvDetails);
         putButton = view.findViewById(R.id.putEntryCp);
         putButton.setOnClickListener(this);
        return view;
    }

    public void updateTextview(String headline) {
        detailsTv.setText(headline);
    }

    @Override
    public void onClick(View view) {
        Uri tableNameUri = Uri.parse("content://entry.todo/entry");
        ContentValues values = new ContentValues();
        values.put("title","cognizant");
        values.put("subtitle","react");
        getContext().getContentResolver().insert(tableNameUri,values);
    }
}
