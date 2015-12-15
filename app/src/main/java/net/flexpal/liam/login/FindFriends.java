package net.flexpal.liam.login;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FindFriends  extends AppCompatActivity {

    ListView findFriendsList;
    String[] usernames;
    String[] expertise;
    int[] images = {R.drawable.dan_small, R.drawable.chris_small,R.drawable.skylar_small };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friends);

        Resources res=getResources();
        usernames = res.getStringArray(R.array.usernames);
        expertise = res.getStringArray(R.array.expertise);

        findFriendsList = (ListView) findViewById(R.id.findFriends);
        myAdapter adapter = new myAdapter(this,usernames,images, expertise);
        findFriendsList.setAdapter(adapter);
    }
}

class myAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] usernamesArray;
    String[] expertiseArray;
    myAdapter(Context c, String[] usernames, int images[],String[] expertise)
    {
        super(c,R.layout.single_row,R.id.textView4, usernames);
        this.context = c;
        this.images = images;
        this.usernamesArray = usernames;
        this.expertiseArray = expertise;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row =inflator.inflate(R.layout.single_row, parent, false);

        ImageView myImage = (ImageView) row.findViewById(R.id.imageView);
        TextView myUsername = (TextView) row.findViewById(R.id.textView4);
        TextView myExpertise = (TextView) row.findViewById(R.id.textView6);

        myImage.setImageResource(images[position]);
        myUsername.setText(usernamesArray[position]);
        myExpertise.setText(expertiseArray[position]);


        return row;


    }
}