package edu.espol.transespol.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import edu.espol.transespol.R;

/**
 * Created by john on 1/02/17.
 */
public class RutaSalidaFragment extends Fragment {

    private WebView mWebView;
    public RutaSalidaFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RutaSalidaFragment newInstance() {
        RutaSalidaFragment fragment = new RutaSalidaFragment();
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
        View root = inflater.inflate(R.layout.fragment_webview, container, false);
        mWebView = (WebView) root.findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("https://transespol.herokuapp.com/rutaEstudianteSalida");
        return root;
    }
}
