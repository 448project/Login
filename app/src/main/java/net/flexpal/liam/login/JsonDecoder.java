package net.flexpal.liam.login;

/**
 * Created by Liam on 11/29/2015.
 */

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

class JsonDecoder {

    JSONArray array;

    public JsonDecoder(String s) {

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(s);
            array = (JSONArray)obj;
        }catch(ParseException pe){

        }
    }

    public JSONArray getArray() {
        String[] s = new String[5];
        for (int i = 0; i < array.size(); i++) {
            s[i] = (String) array.get(i);
        }
        return(array);
    }

}
