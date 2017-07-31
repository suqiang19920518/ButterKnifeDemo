package material.danny_jiang.com.butterknifedemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv1)
    TextView tv1;

    @Bind(R.id.tv2)
    TextView tv2;

    @Bind(R.id.tv3)
    TextView tv3;

    @Bind(R.id.btn1)
    Button btn1;

    @Bind(R.id.btn2)
    Button btn2;

    @Bind(R.id.btn3)
    Button btn3;

    @Bind(R.id.listView_Main)
    ListView listView;

    @BindColor(R.color.colorAccent)
    int myColor;

    private int[] COLORS = new int[]{Color.RED, Color.GREEN, Color.BLUE};
    private List<TextView> textViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife需要在setContentView方法之后调用
        ButterKnife.bind(this);

        tv1.setText("TextView 1");
        tv2.setText("TextView 2");
        tv3.setText("TextView 3");

        textViews.add(tv1);
        textViews.add(tv2);
        textViews.add(tv3);

        //声明批量的操作
        ButterKnife.Action<TextView> action = new ButterKnife.Action<TextView>() {
            /**
             * 遍历集合进行批量操作
             * @param view      遍历集合中的元素
             * @param index     集合中元素所对应的下标
             */
            @Override
            public void apply(TextView view, int index) {
                view.setTextColor(COLORS[index]);
            }
        };

        //使用ButterKnife.apply方法将TextView集合申请批量操作
        ButterKnife.apply(textViews, action);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "BTN 设置Listener成功");

                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        List<String> data = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            data.add("Android-" + i);
        }

        MyAdapter adapter = new MyAdapter(this, data);

        listView.setAdapter(adapter);

    }

    @OnClick({R.id.btn2, R.id.btn3})
    public void btnClicked(View view){
        if (view instanceof Button) {
            Button button = (Button) view;
            Toast.makeText(this, button.getText() + " 被点击了", Toast.LENGTH_SHORT).show();
        }
    }
}
