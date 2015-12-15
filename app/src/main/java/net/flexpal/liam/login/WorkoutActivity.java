package net.flexpal.liam.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class WorkoutActivity extends AppCompatActivity{

    Spinner gym;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        gym = (Spinner) findViewById(R.id.gym);
        adapter = ArrayAdapter.createFromResource(this, R.array.gym_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gym.setAdapter(adapter);
    }

    public void submit_form(View view){
        CheckBox bicep = (CheckBox) findViewById(R.id.biceps);
        CheckBox tricep = (CheckBox) findViewById(R.id.triceps);
        CheckBox chest = (CheckBox) findViewById(R.id.chest);
        CheckBox back = (CheckBox) findViewById(R.id.back);
        CheckBox shoulder = (CheckBox) findViewById(R.id.shoulders);
        CheckBox legs = (CheckBox) findViewById(R.id.legs);
        CheckBox calves = (CheckBox) findViewById(R.id.calves);
        CheckBox abs = (CheckBox) findViewById(R.id.abs);
        CheckBox cardio = (CheckBox) findViewById(R.id.cardio);
        EditText in = (EditText) findViewById(R.id.inTime);
        EditText out = (EditText) findViewById(R.id.outTime);
        bicep.setChecked(false);
        tricep.setChecked(false);
        chest.setChecked(false);
        back.setChecked(false);
        shoulder.setChecked(false);
        legs.setChecked(false);
        calves.setChecked(false);
        abs.setChecked(false);
        cardio.setChecked(false);
        in.setText("");
        out.setText("");
        Context context = getApplicationContext();
        CharSequence text = "Workout logged successful";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        return;
    }

    public void selectItem(View view){

    }
    public void back(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

}
