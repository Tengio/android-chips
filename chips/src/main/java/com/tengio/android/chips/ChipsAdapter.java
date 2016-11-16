package com.tengio.android.chips;

import android.view.ViewGroup;

public class ChipsAdapter extends BaseAdapter<ChipViewHolder, Chip> {

    @Override
    public ChipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChipView view = ChipView.inflate(parent);
        return new ChipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChipViewHolder holder, int position) {
        holder.update(getItem(position));
    }
}
