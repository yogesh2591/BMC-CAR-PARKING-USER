package com.omkar.bmccarparkinguser.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.omkar.bmccarparkinguser.Model.ParkingLot;
import com.omkar.bmccarparkinguser.R;

import java.util.ArrayList;

/**
 * Created by omkar on 16-Feb-18.
 */

public class ParkingLotAdaptor extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList<ParkingLot> parkingLots = null;

    public ParkingLotAdaptor(@NonNull Context context, int resource,ArrayList<ParkingLot> parkingLotArrayList) {
        super(context, resource, parkingLotArrayList);
        this.context = context;
        this.layoutResourceId = resource;
        this.parkingLots = parkingLotArrayList;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        parking_lot holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new parking_lot();

            holder.tv_lot_name= row.findViewById(R.id.tv_lotName);
            holder.tv_address = row.findViewById(R.id.tv_address);
            holder.tv_parking_space = row.findViewById(R.id.tv_parking_space);
            holder.tv_toatal_distance = row.findViewById(R.id.tv_distance);
            holder.iv_call= row.findViewById(R.id.iv_call);
            holder.iv_direction= row.findViewById(R.id.iv_direction);
            row.setTag(holder);
        }else
        {
            holder = (parking_lot) row.getTag();
        }
        final ParkingLot parkingLot = parkingLots.get(position);
        holder.tv_lot_name.setText(parkingLot.getLotname());
        holder.tv_address.setText(parkingLot.getAddress());
        holder.tv_parking_space.setText((parkingLot.getParkedcapacity() - parkingLot.getParkedvehicle()) +"");
        holder.iv_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click","iv_call");
            }
        });
        holder.iv_direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click","iv_direction");
            }
        });
        return row;
    }

    private static class parking_lot {

        TextView tv_lot_name;
        TextView tv_address;
        TextView tv_parking_space;
        TextView tv_toatal_distance;
        ImageView iv_call;
        ImageView iv_direction;
    }
}