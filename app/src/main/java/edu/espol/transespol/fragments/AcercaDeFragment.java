package edu.espol.transespol.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.espol.transespol.R;

/**
 * Created by john on 1/02/17.
 */
public class AcercaDeFragment extends Fragment {
    public AcercaDeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static WebViewFragment newInstance() {
        WebViewFragment fragment = new WebViewFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_acerca_de, container, false);
        return root;
    }
}
