package com.example.subhash.sqlitesaveimages;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    Context context;
    ArrayList<DataModel> mcontact;


    public CustomAdapter(Context context, ArrayList<DataModel> dataModel){
        super(context, R.layout.list, dataModel);
        this.context=context;
        this.mcontact= dataModel;
    }

    public  class  Holder{
        TextView nameFV;
        ImageView pic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        DataModel data = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        Holder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {


            viewHolder = new Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list, parent, false);

            viewHolder.nameFV = (TextView) convertView.findViewById(R.id.txtViewer);
            viewHolder.pic = (ImageView) convertView.findViewById(R.id.imgView);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Holder) convertView.getTag();
        }


        viewHolder.nameFV.setText(data.getFName());
        viewHolder.pic.setImageBitmap(convertToBitmap(data.getImage()));


        // Return the completed view to render on screen
        return convertView;
    }
    //get bitmap image from byte array

    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }

}