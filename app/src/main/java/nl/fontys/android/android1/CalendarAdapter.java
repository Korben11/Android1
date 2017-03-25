package nl.fontys.android.android1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Korben on 23.3.2017.
 */

public class CalendarAdapter extends BaseAdapter {
    private List<Calendar> calendars;
    private LayoutInflater layoutInflater;

    public CalendarAdapter(Context context, List<Calendar> calendars){
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

        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.calendar_row, parent, false);
        }

        TextView tvTeacher = (TextView) convertView.findViewById(R.id.tvTeacher);
        TextView tvCourse = (TextView) convertView.findViewById(R.id.tvCourse);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);
        TextView tvStart = (TextView) convertView.findViewById(R.id.tvStart);
        TextView tvEnd = (TextView) convertView.findViewById(R.id.tvEnd);

        Calendar calendar = (Calendar) getItem(position);
        tvTeacher.setText(calendar.getTeacherName());
        tvCourse.setText(calendar.getCourseName());
        tvLocation.setText(calendar.getLocation());
        tvStart.setText(calendar.getStart());
        tvEnd.setText(calendar.getEnd());
        return convertView;
    }
}
