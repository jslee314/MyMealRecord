package com.example.iriscollectormobile.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.iriscollectormobile.R;
import com.example.iriscollectormobile.data.UserHistory;
import java.util.List;

public class UserHistoryAdapter extends ArrayAdapter<UserHistory> {

    public UserHistoryAdapter(@NonNull Context context, int resource, List<UserHistory> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_userhistory, parent, false);
        }

        ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.dateTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);

        UserHistory userHistory = getItem(position);

        boolean isPhoto = userHistory.getIrisImageUrl() != null;
        if (isPhoto) {
            dateTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(userHistory.getIrisImageUrl())
                    .into(photoImageView);
        } else {
            dateTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            dateTextView.setText(userHistory.getAcquisitionDate());
        }
        authorTextView.setText(userHistory.getUsername());

        return convertView;
    }


}