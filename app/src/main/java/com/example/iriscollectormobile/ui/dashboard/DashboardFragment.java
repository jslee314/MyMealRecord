package com.example.iriscollectormobile.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.iriscollectormobile.MainViewModel;
import com.example.iriscollectormobile.R;
import com.firebase.ui.auth.AuthUI;

public class DashboardFragment extends Fragment {
    Button btnLogout;
    private MainViewModel mMainViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        mMainViewModel.getDashboardText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        btnLogout=root.findViewById(R.id.camera_button_left);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance().signOut(getActivity().getApplicationContext()); // 로그아웃 처리 함수(AuthUI를 사용하는 provider로 로그인한 경우)

            }
        });


        return root;
    }
}