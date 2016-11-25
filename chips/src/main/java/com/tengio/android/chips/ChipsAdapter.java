package com.tengio.android.chips;

import android.view.ViewGroup;

public class ChipsAdapter extends BaseAdapter<ChipViewHolder, Chip> {

    private static final int TYPE_STANDARD = 0;
    private static final int TYPE_DELETABLE = 1;

    @Override
    public ChipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChipView view = viewType == TYPE_STANDARD ? ChipView.standard(parent) : ChipView.deletable(parent);
        return new ChipViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (getItems().get(position).canDelete()) {
            return TYPE_DELETABLE;
        }
        return TYPE_STANDARD;
    }

    @Override
    public void onBindViewHolder(ChipViewHolder holder, int position) {
        holder.update(getItem(position));
    }
}
