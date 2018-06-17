package com.example.android.knownews;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewsAdapter extends ArrayAdapter<News> {

        private Context mContext;

    public NewsAdapter(Activity context, ArrayList<News> news) {
            super(context, 0, news);
            mContext = context;
        }

        private static String dateFormatter(String dateString) {
            Date date = null;
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'");

            try {
                date = dateFormater.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            dateFormater = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");

            return dateFormater.format(date);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.news_item, parent, false);
            }

            final News currentNews = getItem(position);

            ImageView newsImg = (ImageView) listItemView.findViewById(R.id.news_image);
            assert currentNews != null;
            GlideApp.with(mContext)
                    .load(currentNews.getThumbnail())
                    .centerCrop()
                    .into(newsImg);

            newsImg.setVisibility(View.VISIBLE);

            TextView newsTitle = (TextView) listItemView.findViewById(R.id.news_title);
            newsTitle.setText(currentNews.getNewsTitle());

            TextView newsAuthor = (TextView) listItemView.findViewById(R.id.news_author);
            if (currentNews.getAuthor() != null) {
                newsAuthor.setText(currentNews.getAuthor());
            }


            TextView dateNtime = listItemView.findViewById(R.id.date_time);

            String date = dateFormatter(currentNews.getDateNtime());
            dateNtime.setText(date);

            TextView section = listItemView.findViewById(R.id.section);
            section.setText(currentNews.getSection());


            return listItemView;
        }


    }











