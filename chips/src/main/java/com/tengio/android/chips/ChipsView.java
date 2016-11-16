package com.tengio.android.chips;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Arrays;
import java.util.List;

public class ChipsView extends FrameLayout {

    private static final int DEFAULT_PADDING = 8;
    private RecyclerView recyclerView;
    private ChipsAdapter tagAdapter;
    private OnChipRemovedListener onChipRemovedListener;
    private int padding;

    public ChipsView(Context context) {
        super(context);
        init(null);
    }

    public ChipsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ChipsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(com.tengio.android.chips.R.layout.chips_view, this, true);
        float density = getContext().getResources().getDisplayMetrics().density;
        padding = (int) (DEFAULT_PADDING * density);
        if (attrs == null) {
            return;
        }
        TypedArray ta = getContext().obtainStyledAttributes(attrs, com.tengio.android.chips.R.styleable.ChipsView);
        padding = ta.getDimensionPixelSize(com.tengio.android.chips.R.styleable.ChipsView_padding, padding);
        ta.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        recyclerView = (RecyclerView) findViewById(com.tengio.android.chips.R.id.chips_view_rv);
        tagAdapter = new ChipsAdapter();

        SpacingDecoration spacing = new SpacingDecoration(0, padding, 0, 0);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(spacing);
        recyclerView.setAdapter(tagAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(),
                                              new RecyclerItemClickListener.OnItemClickListener() {
                                                  @Override
                                                  public void onItemClick(View view, int position) {
                                                      Chip c = tagAdapter.getItem(position);
                                                      removeItems(c);
                                                      if (onChipRemovedListener != null) {
                                                          onChipRemovedListener.onRemoved(c);
                                                      }
                                                  }
                                              }));
        tagAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if (tagAdapter.getItemCount() == 0) {
                    setTag(null);
                }
            }
        });
    }

    public void addItems(Chip... chips) {
        tagAdapter.addItems(Arrays.asList(chips));
    }

    public void removeItems(Chip... chips) {
        for (Chip chip : chips) {
            tagAdapter.removeItem(chip);
        }
    }

    public List<Chip> getCurrentItems() {
        return tagAdapter.getItems();
    }

    public void setItems(List<Chip> chipList) {
        tagAdapter.setItems(chipList);
    }

    public void setOnChipRemovedListener(OnChipRemovedListener onChipRemovedListener) {
        this.onChipRemovedListener = onChipRemovedListener;
    }
}
