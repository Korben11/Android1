package nl.fontys.android.android1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Stefan on 23-Mar-17.
 */

public class GradesAdapter extends BaseAdapter {

    private List<Calendar> calendars;
    private LayoutInflater layoutInflater;

    public GradesAdapter(Context context, List<Calendar> calendars){
        this.calendars = calendars;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return calendars.size();
    }

    @Override
    public Object getItem(int position) {

        return calendars.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if (convertView == null){
////            convertView = layoutInflater.inflate(R.layout.a)
//        }
        return null;
    }
}
