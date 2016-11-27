package com.tengio.android.chips;

import android.view.View;

public interface OnChipRemovedListener {

    boolean shouldRemove(int position, Chip chip, View chipView);

    void onRemoved(Chip chip);
}
