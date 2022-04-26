package two.one.sqlitedrawer.ui.gallery;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;


import two.one.sqlitedrawer.MainActivity;

import two.one.sqlitedrawer.R;
import two.one.sqlitedrawer.service.MachineService;

public class GalleryFragment extends Fragment {

    private View chartView;
    private MachineService ms;
    BarChart barChart;
    ArrayList<String> salles = new ArrayList<>();
    Random random;
    ArrayList<BarEntry> barEntries = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        chartView = inflater.inflate(R.layout.fragment_gallery, container, false);

        ms = MainActivity.machineService;
        HashMap<String, Integer> stats = ms.machinesByMarque();

        int c = 0;

        for (Map.Entry<String, Integer> set : stats.entrySet()) {
            c++;
            barEntries.add(new BarEntry(c, set.getValue()));
            salles.add(set.getKey());
        }

        barChart = (BarChart) chartView.findViewById(R.id.chart);
        BarDataSet barDataSet = new BarDataSet(barEntries, "Les salles");

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(salles));
        XAxis bottomAxis = barChart.getXAxis();
        bottomAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        bottomAxis.setCenterAxisLabels(true);
        bottomAxis.setLabelCount(salles.size());
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);
        barChart.animateY(1000);

        return chartView;
    }
    }