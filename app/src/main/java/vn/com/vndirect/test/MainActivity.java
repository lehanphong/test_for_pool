package vn.com.vndirect.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import vn.com.vndirect.test.databinding.ActivityMainBinding;

/**
 * BT1: khi nhập $tên vào ô edittext và click vào button Go!
 * -> mở màn tiếp theo và hiển thị "hello $tên" (như clip demo)
 *

 * BT2: khi click checkbox "Check me, please" thì enable button "Submit"
 * khi bỏ check thì button Submit disable lại (như clip demo)
 *
 * BT3: khi click vào "Bay màu" thì set lại background của row/item thành màu trắng (như clip demo)
 *
 * BT4: khi click button Submit
 * -> $tên ở BT 1 được format lại các chữ cái đầu cho đúng chính tả viết hoa khi viết Tên.
 * ví dụ: người dùng nhập "NgUyễn tiẾn đứC" thì format lại thành "Nguyễn Tiến Đức"
 *
 * */

public class MainActivity extends AppCompatActivity {
    //project có 3 hint: 1,2,3 - là những keywork hoặc link để e có thể tìm hiểu thêm (nếu cần) nhé!
    //hint 1: https://developer.android.com/topic/libraries/view-binding em có thể đọc thêm về binding ở đây nhé! (nếu cần)
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListNumberActivity.class);
                startActivity(intent);
            }
        });
    }
}