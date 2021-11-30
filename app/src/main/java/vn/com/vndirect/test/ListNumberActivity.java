package vn.com.vndirect.test;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

import vn.com.vndirect.test.databinding.ActivityListBinding;

public class ListNumberActivity extends AppCompatActivity {
    private ActivityListBinding binding;
    private ListNumberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //init adapter + set data for recycleview
        adapter = new ListNumberAdapter(fakeData());
        binding.rcvNumber.setAdapter(adapter);

        //listener for view
        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListNumberActivity.this, "Click to Submit", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Fake Data for adapter
     * */
    private ArrayList<NumberColorModel> fakeData() {
        ArrayList<NumberColorModel> listNumber = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            listNumber.add(new NumberColorModel(i, randColor(i % 4)));
        }
        return listNumber;
    }

    private int randColor(int number) {
        switch (number) {
            case 0:
                return ActivityCompat.getColor(this, R.color.purple_200);
            case 1:
                return ActivityCompat.getColor(this, R.color.teal_700);
            case 2:
                return ActivityCompat.getColor(this, R.color.design_default_color_primary_dark);
            default:
                return ActivityCompat.getColor(this, R.color.design_default_color_error);
        }
    }
}