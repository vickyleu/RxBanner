package cn.levey.rxbanner.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.levey.bannerlib.RxBanner;
import cn.levey.rxbanner.R;
import cn.levey.rxbanner.fake.FakeData;
import cn.levey.rxbanner.loader.FrescoLoader;

/**
 * Created by Levey on 2018/4/10 14:47.
 * e-mail: m@levey.cn
 */

public class DemoFragment extends Fragment {

    public static final String FRAGMENT_ID = "FRAGMENT_ID";

    @BindView(R.id.banner_view)
    RxBanner bannerView;
    @BindView(R.id.fragment_id)
    TextView tvFragmentId;
    Unbinder unbinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int fragmentId = 1;
        if(getArguments() != null) {
            fragmentId = getArguments().getInt(FRAGMENT_ID, 1);
        }
        View view = inflater.inflate(R.layout.fragment_view, container, false);

        if(view == null){
            throw new NullPointerException("just demo");
        }
        unbinder = ButterKnife.bind(this, view);
        bannerView
                .setLoader(new FrescoLoader())
                .setDatas(FakeData.FAKE_DATA())
                .start();
        tvFragmentId.setText("Fragment " + fragmentId);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        bannerView.onResume();
    }
}