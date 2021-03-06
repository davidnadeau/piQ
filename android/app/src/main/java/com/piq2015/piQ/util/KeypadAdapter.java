package com.piq2015.piQ.util;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

/**
 * Created by aliasapps on 15-03-21.
 */
public class KeypadAdapter extends BaseAdapter {
    private Context mContext;

    public KeypadAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return keypad.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        int padding = 4;
        int buttonHeight = (int) (((float) Screen.getHeight() * .5 / 4));
        int buttonWidth = (int) (((float) Screen.getHeight() * .5 / 3));
        Log.v("TEST", "heiGHT: " + buttonHeight);
        Button button;
        if (convertView == null) {
            button = new Button(mContext);
            button.setPadding(0, 0, 0, 0);
            button.setHeight(buttonHeight);
            button.setWidth(buttonWidth);
            button.setTextSize(TypedValue.COMPLEX_UNIT_PX, 60);
        } else {
            button = (Button) convertView;
        }
        button.setText(keypad[position]);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((GridView) parent).performItemClick(v, position, 0);
            }
        });
        return button;
    }

    private static String[] keypad = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "peek", "0", "."
    };

    public static char positionToNumber(int position) {
        return keypad[position].toCharArray()[0];
    }

    public static boolean isPeek(int position) {
        return position == 9;
    }
}
