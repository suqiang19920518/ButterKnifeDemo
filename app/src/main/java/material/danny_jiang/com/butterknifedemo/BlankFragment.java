package material.danny_jiang.com.butterknifedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    @Bind(R.id.tv_fragment1)
    TextView tv_Fragment1;

    @Bind(R.id.tv_fragment2)
    TextView tv_Fragment2;

    @Bind(R.id.tv_fragment3)
    TextView tv_Fragment3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        ButterKnife.bind(this, view);

        tv_Fragment1.setText("fragment1");
        tv_Fragment2.setText("fragment2");
        tv_Fragment3.setText("fragment3");
        return view;
    }

}
