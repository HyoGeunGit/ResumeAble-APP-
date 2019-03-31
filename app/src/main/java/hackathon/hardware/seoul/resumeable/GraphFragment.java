package hackathon.hardware.seoul.resumeable;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraphFragment extends Fragment {
    BarChart bar;

    public static GraphFragment newInstance() {
        GraphFragment fragment = new GraphFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public GraphFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_graph, container, false);

        bar = (BarChart)view.findViewById(R.id.bar);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 50f,"Total"));
        entries.add(new BarEntry(1f, 20f,"Obtained"));
        entries.add(new BarEntry(2f, 35f,"Highest"));
        entries.add(new BarEntry(3f, 38.5f,"Average"));



        BarDataSet bSet = new BarDataSet(entries, "Marks");
        bSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        ArrayList<String> barFactors = new ArrayList<>();
        barFactors.add("속도(m/s)");
        barFactors.add("충격량");
        barFactors.add("각도평균");
        barFactors.add("총평균");


        XAxis xAxis = bar.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        BarData data = new BarData(bSet);
        data.setBarWidth(0.9f); // set custom bar width
        data.setValueTextSize(12);
        Description description = new Description();
        description.setTextColor(R.color.colorPrimary);
        description.setText("All values in marks");
        bar.setDescription(description);
        bar.setData(data);
        bar.setFitBars(true); // make the x-axis fit exactly all bars
        bar.invalidate(); // refresh
        bar.getXAxis().setValueFormatter(new IndexAxisValueFormatter(barFactors));

        Legend l = bar.getLegend();
        l.setFormSize(10f); // set the size of the legend forms/shapes
        l.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        l.setTextSize(12f);
        l.setTextColor(Color.BLACK);
        List<LegendEntry> lentries = new ArrayList<>();
        for (int i = 0; i < barFactors.size(); i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = ColorTemplate.VORDIPLOM_COLORS[i];
            entry.label = barFactors.get(i);
            lentries.add(entry);
        }
        l.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        l.setYEntrySpace(5f);
        l.setCustom(lentries);
        l.setCustom(lentries);
//return inflater.inflate(R.layout.fragment_maths, container, false);
        return view;
    }

}