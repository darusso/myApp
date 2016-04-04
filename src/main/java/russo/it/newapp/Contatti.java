package russo.it.newapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Contatti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatti);
        this.accedi();
    }

    public void accedi()
    {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(Contacts.People.CONTENT_URI,null,null,null,null);

        if (cur.getCount() > 0 )
        {
            while (cur.moveToNext())
            {
                String id = cur.getString(cur.getColumnIndex(Contacts.People._ID));
                String nome = cur.getString(cur.getColumnIndex(Contacts.People.DISPLAY_NAME));
                Toast.makeText(getApplicationContext(), "nome:" + nome, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
