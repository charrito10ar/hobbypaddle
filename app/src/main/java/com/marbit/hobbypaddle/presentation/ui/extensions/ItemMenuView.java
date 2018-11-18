package com.marbit.hobbypaddle.presentation.ui.extensions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.marbit.hobbypaddle.R;


public class ItemMenuView extends LinearLayout {

    FrameLayout iconBadge;

    @SuppressLint("ResourceType")
    public ItemMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ItemMenuView,0, 0);

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout.item_menu_view, this, true);
        ImageView iconMenu = view.findViewById(R.id.image_view_icon_menu);
        iconMenu.setImageDrawable(ContextCompat.getDrawable(getContext(), typedArray.getResourceId(0, R.drawable.ic_atlas_small)));
        TextView itemName = view.findViewById(R.id.text_view_item_menu_name);
        itemName.setText(typedArray.getText(1));
        ImageView rightArrow = view.findViewById(R.id.right_arrow);
        boolean showArrow = typedArray.getBoolean(2, true);
        if(!showArrow)
            rightArrow.setVisibility(INVISIBLE);
        iconBadge = view.findViewById(R.id.icon_badge);
        boolean showBadge = typedArray.getBoolean(3, false);
        if(showBadge) iconBadge.setVisibility(VISIBLE); else iconBadge.setVisibility(GONE);
    }

    public void setBadgeVisibility(boolean showBadge){
        if(showBadge)
            iconBadge.setVisibility(VISIBLE);
        else
            iconBadge.setVisibility(GONE);
    }
}