package foiled.boggle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Guest on 3/14/18.
 */

public class AlphaAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> minitialLetters;

    public AlphaAdapter (Context context, ArrayList<String> initialLetters) {
        this.mContext = context;
        this.minitialLetters = initialLetters;

    }

    @Override
    public int getCount() {
        return minitialLetters.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = inflater.inflate(R.layout.alpha_grid_item, null);

            TextView letterView = (TextView) gridView
                    .findViewById(R.id.grid_item_letter);

            letterView.setText(minitialLetters.get(position));
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
