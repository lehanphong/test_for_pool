package vn.com.vndirect.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.com.vndirect.test.databinding.RowNumberBinding;

class NumberColorModel {
    int number;
    int color;

    public NumberColorModel(int number, int color) {
        this.number = number;
        this.color = color;
    }
}

//hint 2: https://developer.android.com/guide/topics/ui/layout/recyclerview em có thể đọc thêm về adapter và recycleview ở đây nhé (nếu cần)
public class ListNumberAdapter extends RecyclerView.Adapter<ListNumberAdapter.ViewHolder> {

    private ArrayList<NumberColorModel> listNumber;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber;
        TextView tvChangeColor;
        LinearLayout rootLayout;

        public ViewHolder(RowNumberBinding binding) {
            super(binding.getRoot());
            tvNumber = binding.tvNumber;
            tvChangeColor = binding.tvChangeColor;
            rootLayout = binding.rootLayout;
        }

        public void updateData(NumberColorModel numberModel) {
            tvNumber.setText(String.valueOf(numberModel.number));
            rootLayout.setBackgroundColor(numberModel.color);
            tvChangeColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //hint 3: em cần sử dụng notifyItemChanged(index); để thay đổi 1 item trong recycleview
                }
            });
        }

    }


    public ListNumberAdapter(ArrayList<NumberColorModel> listNumber) {
        this.listNumber = listNumber;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RowNumberBinding binding = RowNumberBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.updateData(listNumber.get(position));
    }

    @Override
    public int getItemCount() {
        return listNumber.size();
    }
}