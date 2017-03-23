package nl.fontys.android.android1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Stefan on 23-Mar-17.
 */

public class ScheduleAdapter extends BaseAdapter{

    private List<Calendar> calData;
    private LayoutInflater layoutInflater;
    private Context context;

    public ScheduleAdapter(Context context, List<Calendar> calData, LayoutInflater layoutInflater) {
        this.context = context;
        this.calData = calData;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return calData.size();
    }

    @Override
    public Object getItem(int position) {
        return calData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_cal_layout,null);
            holder = new ViewHolder();
            holder.subjectNameView = (TextView) convertView.findViewById(R.id.subjectName);
            holder.durationView = (TextView) convertView.findViewById(R.id.duration);
            holder.locationView = (TextView) convertView.findViewById(R.id.location);
            holder.teacherNameView = (TextView) convertView.findViewById(R.id.teacherName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Calendar calendar = this.calData.get(position);
        holder.teacherNameView.setText(calendar.getTeacherName());
        holder.subjectNameView.setText(calendar.getCourseName());
        holder.locationView.setText(calendar.getLocation());
        holder.durationView.setText(calendar.getDuration());

        return convertView;
    }

    static class ViewHolder{
        TextView teacherNameView;
        TextView subjectNameView;
        TextView locationView;
        TextView durationView;
    }
}
