package net.flexpal.liam.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements OnClickListener {

    Button login;
    Button register;
    EditText txtEmail;
    EditText txtPassword;
    String Email = "liam@me.com";
    String Password = "liam";
    String Who = "JJLH88";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.email_sign_in_button);
        register=(Button)findViewById(R.id.registerButton);
        txtEmail=(EditText)findViewById(R.id.email);
        txtPassword=(EditText)findViewById(R.id.password);

        login.setOnClickListener((OnClickListener) this);
        register.setOnClickListener((OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerButton:
                Intent i = new Intent(this, RegisterActivity.class);
                startActivity(i);

                break;

            case R.id.email_sign_in_button:
                signInAttempt();
                break;

        }
    }

    public void signInAttempt(){

        String strEmail=txtEmail.getText().toString().toLowerCase();
        String strPassword=txtPassword.getText().toString();

        if(TextUtils.isEmpty(strEmail)) {
            txtEmail.setError("Must enter an email");
            return;
        }else if(TextUtils.isEmpty(strPassword)){
            txtPassword.setError("Must enter a password");
            return;
        }else if(!isEmail(strEmail)){
            txtEmail.setError("Must be a valid email");
            return;
        }else if(!(strEmail.equalsIgnoreCase(Email)) || !(strPassword.equals(Password))){
            Context context = getApplicationContext();
            CharSequence text = "Email and Password combination was not found. Try Again!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }else if(strEmail.equalsIgnoreCase(Email) && strPassword.equals(Password)) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }

    public Boolean isEmail(String email) {
        if(email.contains("@")){
            return(true);
        }else{
            return(false);
        }
    }

    public void setLogin(){
        return;
    }
}
