package net.flexpal.liam.login;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.GridLabelRenderer;

public class GymUsageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_usage);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.setTitle("Gym Usage");
        GridLabelRenderer renderer = graph.getGridLabelRenderer();

        new GetLogs(this, graph).execute("1");
    }


}
