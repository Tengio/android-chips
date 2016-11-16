package com.tengio.android.chips;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseAdapter<VH extends RecyclerView.ViewHolder, T> extends RecyclerView.Adapter<VH> {

    private final List<T> items = new ArrayList<>();

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(List<T> items) {
        if (items != null) {
            this.items.addAll(items);
            notifyItemRangeInserted(this.items.size(), items.size());
        }
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        if (items != null) {
            this.items.clear();
            this.items.addAll(items);
        } else {
            this.items.clear();
        }
        notifyDataSetChanged();
    }

    public T getItem(int position) {
        return items.get(position);
    }

    public T removeItem(int position) {
        T item = items.remove(position);
        notifyItemRemoved(position);
        return item;
    }

    public void removeItems(int position, int count) {
        if (position < 0 || count == 0) {
            return;
        }

        for (int i = position + count - 1; i >= position; i--) {
            items.remove(i);
        }
        notifyItemRangeRemoved(position, count);
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public T removeItem(T item) {
        if (item == null) {
            return null;
        }

        final int position = items.indexOf(item);
        if (position >= 0) {
            return removeItem(position);
        }
        return item;
    }

    public int updateItem(T item) {
        if (item == null) {
            return -1;
        }
        final int position = items.indexOf(item);
        if (position >= 0) {
            items.remove(position);
            items.add(position, item);
            notifyItemChanged(position);
        }
        return position;
    }

    public void insertItem(int position, T item) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void insertItems(int position, Collection<T> items) {
        if (items == null) {
            return;
        }

        this.items.addAll(position, items);
        notifyItemRangeInserted(position, items.size());
    }

    public int getItemPosition(T object) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(object)) {
                return i;
            }
        }
        return -1;
    }
}