package com.tengio.android.chips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChipView extends RelativeLayout {

    private TextView title;

    public ChipView(Context context) {
        super(context);
    }

    public ChipView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static ChipView inflate(ViewGroup group) {
        return (ChipView) LayoutInflater.from(group.getContext()).inflate(com.tengio.android.chips.R.layout.chip_view, group, false);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        title = (TextView) findViewById(com.tengio.android.chips.R.id.chip_view_title);
    }

    public void update(Chip chip) {
        title.setText(chip.getLabel());
    }
}
