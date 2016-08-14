package com.lnyp.pswkeyboard.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lnyp.pswkeyboard.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * 九宫格键盘适配器
 */
public class KeyBoardAdapter extends BaseAdapter {


    private Context mContext;
    private ArrayList<Map<String, String>> valueList;

    public KeyBoardAdapter(Context mContext, ArrayList<Map<String, String>> valueList) {
        this.mContext = mContext;
        this.valueList = valueList;
    }

    @Override
    public int getCount() {
        return valueList.size();
    }

    @Override
    public Object getItem(int position) {
        return valueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.grid_item_virtual_keyboard, null);
            viewHolder = new ViewHolder();
            viewHolder.btnKey = (TextView) convertView.findViewById(R.id.btn_keys);
            viewHolder.imgDelete = (RelativeLayout) convertView.findViewById(R.id.imgDelete);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (position == 9) {
            viewHolder.imgDelete.setVisibility(View.INVISIBLE);
            viewHolder.btnKey.setVisibility(View.VISIBLE);
            viewHolder.btnKey.setText(valueList.get(position).get("name"));
            viewHolder.btnKey.setBackgroundColor(Color.parseColor("#e0e0e0"));
        } else if (position == 11) {
            viewHolder.btnKey.setBackgroundResource(R.mipmap.keyboard_delete_img);
            viewHolder.imgDelete.setVisibility(View.VISIBLE);
            viewHolder.btnKey.setVisibility(View.INVISIBLE);

        } else {
            viewHolder.imgDelete.setVisibility(View.INVISIBLE);
            viewHolder.btnKey.setVisibility(View.VISIBLE);

            viewHolder.btnKey.setText(valueList.get(position).get("name"));
        }

        return convertView;
    }

    /**
     * 存放控件
     */
    public final class ViewHolder {
        public TextView btnKey;
        public RelativeLayout imgDelete;
    }
}
