package net.flexpal.liam.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Button back;
    Button edit;
    EditText txtExp;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        back=(Button)findViewById(R.id.backButton);
        edit=(Button)findViewById(R.id.editButton);
        txtExp=(EditText)findViewById(R.id.expertiseText);
        name=(TextView)findViewById(R.id.userNameLabel);

        name.setText("Welcome: " + (new LoginActivity().Who));

        back.setOnClickListener((OnClickListener) this);
        edit.setOnClickListener((OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editButton:

                String experience = txtExp.getText().toString();
                if(!TextUtils.isEmpty(experience)) {
                    if (Integer.parseInt(experience) > 10) {
                        txtExp.setError("Must be a number between 1 and 10");
                    } else {
                        txtExp.setHint("Expertise Level: " + experience);
                    }
                }

                txtExp.setText("");
                break;

            case R.id.backButton:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
