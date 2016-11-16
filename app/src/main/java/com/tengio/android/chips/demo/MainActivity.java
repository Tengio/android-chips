package com.tengio.android.chips.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tengio.android.chips.Chip;
import com.tengio.android.chips.ChipsView;
import com.tengio.android.chips.OnChipRemovedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ChipsView chipsView;
    private TextView debugView;
    private Button addButton;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Chip> chipList = new ArrayList<>();
        count = 0;
        for (; count < 10; count++) {
            chipList.add(new CustomChip("Chip " + count));
        }
        debugView = (TextView) findViewById(R.id.debug_view);
        chipsView = (ChipsView) findViewById(R.id.custom_chips);
        chipsView.setItems(chipList);
        chipsView.setOnChipRemovedListener(new OnChipRemovedListener() {
            @Override
            public void onRemoved(Chip chip) {
                debugView.setText("Chip: " + chip.getLabel() + " removed");
            }
        });
        addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chipsView.addItems(new CustomChip("New " + ++count));
            }
        });
    }
}
