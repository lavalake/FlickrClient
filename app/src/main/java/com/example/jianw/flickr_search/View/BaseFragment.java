package com.example.jianw.flickr_search.View;

import android.app.Fragment;
import android.support.annotation.MainThread;
import android.widget.Toast;

/**
 * Created by jian1.w on 11/27/2018.
 */

public abstract class BaseFragment extends Fragment {
        @MainThread
        public void showToast(final String message) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
}
