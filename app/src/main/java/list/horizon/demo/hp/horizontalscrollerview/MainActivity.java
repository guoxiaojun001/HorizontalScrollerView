package list.horizon.demo.hp.horizontalscrollerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] titles1 = {"类型", "爱情", "喜剧", "动画", "剧情", "恐怖", "惊悚", "科幻", "动作", "悬疑", "冒险", "战争", "奇幻", "运动", "家庭", "古装", "武侠", "西部", "历史", "传记", "情色", "歌舞", "短片", "纪录片", "其他"};
    private String[] titles2 = {"地区", "大陆", "美国", "韩国", "日本", "中国", "中国香港", "中国台湾", "泰国", "印度", "法国", "英国", "澳大利亚", "其他"};
    private String[] titles3 = {"年代", "2017以后", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "90年代", "80年代", "70年代", "其他"};

    View view0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout hscrollerview= (LinearLayout)findViewById(R.id.hscrollerview);

        setData(hscrollerview);
    }


    private void setData(LinearLayout hscrollerview) {
        //① 创建item布局，并添加到水平线性布局中
        //由于第一个和其他的item不一样所以我们分别添加，相应的为其添加两种不同的item布局
        //第一种item布局不要加边框背景
        //第二种item布局要加边框背景

        // ② 先添加第一个数据
        view0 = View.inflate(this, R.layout.item_hscollerview0, null);
        TextView tv0 = (TextView) view0.findViewById(R.id.tv0);
        tv0.setText(titles2[0]);
        //添加进去
        hscrollerview.addView(view0);

        // ③ 再循环添加后面的数据
        for (int i = 1; i < titles1.length; i++) {
            View view = View.inflate(this,R.layout.item_hscollerview1, null);
            CheckBox tv1 = (CheckBox) view.findViewById(R.id.tv1);

            //创建好TextView后就立马给它设置点击事件的监听
            setListener(tv1);

            tv1.setText(titles1[i]);

            //添加进去
            hscrollerview.addView(view);
        }
    }


    private void setListener(final TextView tv1) {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, tv1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
