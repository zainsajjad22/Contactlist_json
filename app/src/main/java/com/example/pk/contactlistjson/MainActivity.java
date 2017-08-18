package zainsajjad.custom_contact_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityextends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<contact>searchResults = GetSearchResults();

        final ListView l = (ListView) findViewById(R.id.ListView01);
        l.setAdapter(new customrowAdapter(this, searchResults));

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, intposition, long id) {
                Object o = l.getItemAtPosition(position);
                contact fullObject = (contact) o;
                Toast.makeText(getApplicationContext(), "select one: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
            }
        });


    }

    private ArrayList<contact>GetSearchResults() {
        ArrayList<contact> results = new ArrayList<contact>();

        for (inti = 0; i<100; i++) {
            contact s = new contact();
            s.setName("zain");
            s.setGender("Male");
            s.setPhone("+923039227249");
            results.add(s);
        }
        return results;
    }

}
CustomRowAdapter:
        package zainsajjad.custom_contact_list;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;


public class customrowAdapterextends BaseAdapter {

    private static ArrayList<contact>searchArrayList;

    private LayoutInflatermInflater;


    public customrowAdapter(Context context, ArrayList<contact> results) {

        searchArrayList= results;
        mInflater= LayoutInflater.from(context);


    }

    @Override
    public intgetCount() {
        return searchArrayList.size();
    }

    @Override
    public Object getItem(intposition) {
        return searchArrayList.get(position);

    }

    @Override
    public long getItemId(intposition) {
        return position;

    }

    @Override
    public View getView(intposition, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.customrow, null);
            holder = new ViewHolder();
            holder.Name= (TextView) convertView.findViewById(R.id.name);
            holder.gender= (TextView) convertView.findViewById(R.id.cityState);
            holder.txtPhone= (TextView) convertView.findViewById(R.id.phone);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.Name.setText(searchArrayList.get(position).getName());
        holder.gender.setText(searchArrayList.get(position).getGender());
        holder.txtPhone.setText(searchArrayList.get(position).getPhone());

        return convertView;
    }

    static class ViewHolder {
        TextViewName;
        TextViewgender;
        TextViewtxtPhone;

    }
}
    Contact list:
        package zainsajjad.custom_contact_list;


public class contact {

    private String name = "";
    private String gender = "";
    private String phone = "";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        this.gender= gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPhone(String phone) {
        this.phone= phone;
    }

    public String getPhone() {
        return phone;
    }
