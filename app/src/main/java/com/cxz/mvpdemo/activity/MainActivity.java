package com.cxz.mvpdemo.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.cxz.mvpdemo.AppComponent;
import com.cxz.mvpdemo.R;
import com.cxz.mvpdemo.activity.component.DaggerMainActivityComponent;
import com.cxz.mvpdemo.activity.module.MainActivityModule;
import com.cxz.mvpdemo.activity.presenter.MainPresenter;
import com.cxz.mvpdemo.activity.view.MainView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:55
 */
public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;
    @BindView(R.id.et_message)
    EditText etMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent).mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
    }

    @OnClick(R.id.btn_toast)
    void onClick() {
        mainPresenter.showToast(etMessage.getText().toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
