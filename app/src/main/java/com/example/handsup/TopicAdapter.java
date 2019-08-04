package com.example.handsup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TopicAdapter extends BaseAdapter {

    private final Context mContext;
    private final Topic[] topics;

    // 1 You use this constructor to instantiate a TopicAdapter
    public TopicAdapter(Context context, Topic[] topics) {
        this.mContext = context;
        this.topics = topics;
    }

    // 2 You return the number of cells to render here.
    @Override
    public int getCount() {
        return topics.length;
    }

    // 3 You don’t need to return an id for this tutorial, so just return 0.
    // Android still requires you to provide an implementation for this method.
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4 See #3, but instead return null
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5 You return a dummy TextView as the cell view for your GridView.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1
        final Topic topic = topics[position];

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_topic, null);
        }

        // 3
        final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
        //final TextView authorTextView = (TextView)convertView.findViewById(R.id.textview_book_author);
//        final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);

        // 4
        imageView.setImageResource(topic.getImage());
        nameTextView.setText(topic.getName());
//        authorTextView.setText(mContext.getString(topic.getAuthor()));

        return convertView;
    }


}


