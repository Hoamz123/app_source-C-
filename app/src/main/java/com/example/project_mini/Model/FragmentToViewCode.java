package com.example.project_mini.Model;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project_mini.R;


public class FragmentToViewCode extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    private static final String key_imeCode = "KeyOfCode";

    // TODO: Rename and change types of parameters

    private ImageView imageView;
    private int imgId;
    private View view;

    public FragmentToViewCode() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentToViewCode newInstance(int imgId) {
        FragmentToViewCode fragment = new FragmentToViewCode();
        Bundle args = new Bundle();
        args.putInt(key_imeCode,imgId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //được gọi khi Fragment đc tạo và trước khi giao diên đc tạo
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imgId = getArguments().getInt(key_imeCode,-1);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_to_view_code, container, false);

        imageView = view.findViewById(R.id.imgFrg);

        view.setOnTouchListener((v, event) -> true);

        //nap du lieu thong qua Bundle

        if(imgId != -1){
            imageView.setImageResource(imgId);
        }
        else{
            Toast.makeText(getContext(),"Errol",Toast.LENGTH_SHORT).show();
        }

        return view;
    }
}