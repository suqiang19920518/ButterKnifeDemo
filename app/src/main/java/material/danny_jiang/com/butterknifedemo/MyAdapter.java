package material.danny_jiang.com.butterknifedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.ls.LSException;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by axing on 16/10/25.
 */

public class MyAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private Context context;
    private List<String> data;

    public MyAdapter(Context context, List<String> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_layout, null);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }

        holder.textView.setText(data.get(position));

        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.text_item)
        public TextView textView;

        public ViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }
}
