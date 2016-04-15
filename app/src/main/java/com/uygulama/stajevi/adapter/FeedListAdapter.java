package com.uygulama.stajevi.adapter;





        import java.util.List;

        import android.app.Activity;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;
        import com.android.volley.toolbox.ImageLoader;
        import com.uygulama.stajevi.costum.FeedImageView;
        import com.uygulama.stajevi.R;
        import com.uygulama.stajevi.app.AppController;
        import com.uygulama.stajevi.model.News;


public class FeedListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<News> feedItems;
    ImageLoader imageLoader;

    public FeedListAdapter(Activity activity, List<News> feedItems) {

        this.feedItems = feedItems;
        this.activity=activity;
       imageLoader = AppController.getInstance().getImageLoader();
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.news_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView timestamp = (TextView) convertView
                .findViewById(R.id.timestamp);


        FeedImageView feedImageView = (FeedImageView) convertView
                .findViewById(R.id.feedImage1);

        News item = feedItems.get(position);

        name.setText(item.getNewsShortTitle());

        String date=item.getNewsStartDate();
        date=date.substring(0,10);
        timestamp.setText(date);



        // Feed image
        if (item.getTitleSourceUrl() != null) {
            feedImageView.setImageUrl(item.getTitleSourceUrl(), imageLoader);
            feedImageView.setVisibility(View.VISIBLE);
            feedImageView
                    .setResponseObserver(new FeedImageView.ResponseObserver() {
                        @Override
                        public void onError() {
                        }

                        @Override
                        public void onSuccess() {
                        }
                    });
        } else {
            feedImageView.setVisibility(View.GONE);
        }

        return convertView;
    }

}