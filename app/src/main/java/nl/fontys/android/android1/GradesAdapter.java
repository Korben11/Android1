package nl.fontys.android.android1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Stefan on 23-Mar-17.
 */

public class GradesAdapter extends BaseAdapter {

    private List<Grades> grades;
    private LayoutInflater layoutInflater;

    public GradesAdapter(Context context, List<Grades> grades){
        this.grades = grades;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return grades.size();
    }

    @Override
    public Object getItem(int position) {

        return grades.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//
     if (convertView == null){
        convertView = layoutInflater.inflate(R.layout.grades_row, parent, false);
    } //course grade date passed

    TextView tvCourse = (TextView) convertView.findViewById(R.id.tvCourse);
    TextView tvGrade = (TextView) convertView.findViewById(R.id.tvGrade);
    TextView tvDate = (TextView) convertView.findViewById(R.id.tvDate);
    TextView tvPassed = (TextView) convertView.findViewById(R.id.tvPassed);

    Grades grades = (Grades) getItem(position);
    tvCourse.setText(grades.getCourse());
    tvGrade.setText(grades.getGrade().toString());
    tvDate.setText(grades.getDate());
    tvPassed.setText(grades.getPassed().toString());
    return convertView;
    }
}
