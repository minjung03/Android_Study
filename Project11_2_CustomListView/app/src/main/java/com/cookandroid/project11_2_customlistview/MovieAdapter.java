package com.cookandroid.project11_2_customlistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    Context mContext; // 메인 액티버티의 컨텍스트를 저장
    ArrayList<Movie> mData; // ListViewitem 아이템 데이터를 저장한 배열리스트를 저장

    public MovieAdapter(Context mContext, ArrayList<Movie> mData) { // 어댑터 생성시 컨텍스트와 데이터배열 가져옴
        this.mContext = mContext;
        this.mData = mData;
    }

    // 리스트 객체 내의 아이템의 개수를 반환
    @Override
    public int getCount() {
        return mData.size();
    }

    // 전달받은 position의 위치에 해당하는 리스트 객체 아이템을 반환
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    // 전달받은 position의 위치에 해당하는 리스트 객체 아이템의 행번호를 반환
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 화면에 보여지는 리스트뷰의 항목들을 출력하는 함수(항목이 5개이면 5번 호출됨)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 해당되는 항목의 어댑터에서 위치값, 재사용할 항목의 view, 항목의 뷰들을 포함하고 있는 리스트뷰

        // listitem 레이아웃을 inflate
        if(convertView == null){ // 재사용되는 converView가 없을 때
            convertView = View.inflate(mContext, R.layout.listitem1, null);
        }
        ImageView image = convertView.findViewById(R.id.imgPoster);
        TextView title = convertView.findViewById(R.id.txtTitle);
        TextView genre = convertView.findViewById(R.id.txtGenre);

        // Data Set(mData)에서 position에 위치한 데이터 참조 획득 후 아이템 내 각 위젯에 데이터 반영
        image.setImageDrawable(mData.get(position).image);
        title.setText(mData.get(position).title);
        genre.setText(mData.get(position).genre);

        return convertView;
    }
}
