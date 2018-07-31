package com.example.timurbadretdinov.inception.ui.splash;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timurbadretdinov.inception.R;


public class SplashFragment extends Fragment {

    private static final String ARG_IMAGE = "image";
    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";

    private int image;
    private String title;
    private String descr;

    public SplashFragment() {
    }

    public static SplashFragment newInstance(int image, String title, String descr) {
        SplashFragment fragment = new SplashFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE, image);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, descr);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            image = getArguments().getInt(ARG_IMAGE);
            title = getArguments().getString(ARG_TITLE);
            descr = getArguments().getString(ARG_DESCRIPTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        ImageView ivPic = view.findViewById(R.id.ivImage);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvDesrc = view.findViewById(R.id.tvDescr);

        ivPic.setImageDrawable(getResources().getDrawable(image));
        tvTitle.setText(title);
        tvDesrc.setText(descr);
        return view;
    }
}
