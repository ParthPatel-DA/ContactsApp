package com.example.jswn.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private TextView textEmail;
    private  ListView list;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this,AddContact.class);
                startActivity(intent);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            Intent intent = new Intent(MainActivity.this,Login.class);
            startActivity(intent);
            MainActivity.this.finish();
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        textEmail = (TextView) findViewById(R.id.txtEmail);
//        textEmail.setText(user.getEmail());
        list = findViewById(R.id.lstContact);



        final ArrayList<MyData> arrayList = new ArrayList<>();
//        FirebaseUser user = firebaseAuth.getCurrentUser();
        final MyAdapter adapter = new MyAdapter(arrayList,this);
        list.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MyData d = dataSnapshot.getValue(MyData.class);
                arrayList.add(d);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        arrayList.add(new MyData(Name,Phone,Email));
//        arrayList.add(new MyData("Om Patel","935080944",""));
//        arrayList.add(new MyData("Jay Patel","209053909",""));
//        arrayList.add(new MyData("Ajay Patel","398598934",""));


    }

    private void DisplayData(){
//        String Phone="";
//        String Name="";
//        String Email="";
//        if(user != null) {
//            if (user.getPhoneNumber() != null) {
//                Phone = user.getPhoneNumber().toString();
//            }
//            if (user.getDisplayName() != null) {
//                Name = user.getDisplayName().toString();
//            }
//            if (user.getEmail() != null) {
//                Email = user.getEmail().toString();
//            }
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            firebaseAuth.signOut();
            Intent intent = new Intent(MainActivity.this,Login.class);
            startActivity(intent);
            MainActivity.this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
