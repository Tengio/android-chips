package com.tengio.android.chips;

import android.support.v7.widget.RecyclerView;

public class ChipViewHolder extends RecyclerView.ViewHolder {

    private final ChipView button;

    public ChipViewHolder(ChipView itemView) {
        super(itemView);
        button = itemView;
    }

    public void update(Chip chip) {
        button.update(chip);
    }
}
