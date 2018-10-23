package com.example.nisarahmed.calapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etBillAmout)
    EditText etBillAmout;
    @BindView(R.id.Tippercent)
    TextView Tippercent;
    @BindView(R.id.Tiptotal)
    TextView Tiptotal;
    @BindView(R.id.tvTotalAmount)
    TextView tvTotalAmount;
    float Good_TIP_PERCENTAGE = 20;
    float Regular_TIP_PERCENTAGE = 15;
    float best_TIP_PERCENTAGE = 25;

    float percant = 0;
    float tiptotal = 0;
    float finalbillamount = 0;
    float totalbillamount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTipValues();
    }

    private void setTipValues() {

        Tippercent.setText(getString(R.string.main_msg_tippercent, percant));
        Tiptotal.setText(getString(R.string.main_msg_tiptotal, tiptotal));
        tvTotalAmount.setText(getString(R.string.main_msg_billtotalresult, finalbillamount));

    }

    @OnClick({R.id.ibRegularservice, R.id.ibGoodservice, R.id.ibbestservice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibRegularservice:
                percant = Regular_TIP_PERCENTAGE;
                break;
            case R.id.ibGoodservice:
                percant = Good_TIP_PERCENTAGE;
                break;
            case R.id.ibbestservice:
                percant = best_TIP_PERCENTAGE;
                break;
        }
        calculatedfinalbillamount();
        setTipValues();
    }

    @OnTextChanged(R.id.etBillAmout)
    public void onTextChanged() {
        calculatedfinalbillamount();
        setTipValues();

    }

    private void calculatedfinalbillamount() {
        if(percant==0)
            percant=Regular_TIP_PERCENTAGE;
        if(!etBillAmout.getText().toString().equals("")&&!etBillAmout.getText().toString().equals("."))
       totalbillamount=Float.valueOf(etBillAmout.getText().toString());

        else
            totalbillamount=0;
        tiptotal=(totalbillamount*percant)/100;
        finalbillamount=tiptotal +totalbillamount;


    }
}
