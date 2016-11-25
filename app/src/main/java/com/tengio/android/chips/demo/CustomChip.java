package com.tengio.android.chips.demo;

import com.tengio.android.chips.Chip;

public class CustomChip implements Chip {

    private final String title;

    public CustomChip(String value) {
        this.title = value;
    }

    @Override
    public String getLabel() {
        return title;
    }

    @Override
    public boolean canDelete() {
        return false;
    }
}
