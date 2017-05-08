package phromphong.smes_borrow_return;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Callback;

/**
 * Created by phrompongkhagtes on 4/27/2017 AD.
 */

public class MyAdapter extends BaseAdapter {


    private final ArrayList<BorrowReturn> details;
    private final LayoutInflater inflater;

    public MyAdapter(BorrowReturnActivity activity, ArrayList<BorrowReturn> details) {
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Object getItem(int position) {
        return details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
   public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.activity_click_return, null);

        TextView borrow_id = (TextView) view.findViewById(R.id.textView0);
        borrow_id.setText(details.get(position).borrow_id);

        TextView textview = (TextView) view.findViewById(R.id.textViewa);
       textview.setText(details.get(position).borrow_code);

        TextView prob_name = (TextView) view.findViewById(R.id.textViewb);
       prob_name.setText(details.get(position).prob_name);

       TextView name = (TextView) view.findViewById(R.id.textViewc);
        name.setText(details.get(position).imem_first_name);

        return view;

    }

}
