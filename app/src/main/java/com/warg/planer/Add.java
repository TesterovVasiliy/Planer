package com.warg.planer;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.warg.planer.database.DBHelper;

import static com.warg.planer.database.DBSchema.*;

public class Add extends AppCompatActivity {

    private SQLiteDatabase mDatabase;
    private EditText mAddName;
    private EditText mAddDescription;
    private EditText mAddData;
    private Button mBtnAddBirthday;
    private String mName = "", mDescription = "", mData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mDatabase = new DBHelper(getApplicationContext()).getWritableDatabase();

        mAddName = (EditText) findViewById(R.id.addName);
        mAddDescription = (EditText) findViewById(R.id.addDescription);
        mAddData = (EditText) findViewById(R.id.addData);
        mBtnAddBirthday = (Button) findViewById(R.id.btnAddBirthday);
    }

    public void AddBirthday(View view) {
        mName = mAddName.getText().toString();
        mDescription = mAddDescription.getText().toString();
        mData = mAddData.getText().toString();
        if (mName.equals("") | mDescription.equals("") | mData.equals("")) {
            Toast.makeText(this, "Заполните все поля для сохранения", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(this, mName + " - " + mDescription + " - " + mData, Toast.LENGTH_SHORT).show();
            getContentValues();
            //getDB();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void getContentValues() {
        ContentValues values = new ContentValues();
        values.put(Cols.NAME, mName);
        values.put(Cols.DESCRIPTION, mDescription);
        values.put(Cols.DATA, mData);
        values.put(Cols.CHECKIN, true);
        mDatabase.insert(PlanerTable.NAME, null, values);
        //Toast.makeText(this, "Все ок", Toast.LENGTH_SHORT).show();
    }

    /*private void getDB(){
        Cursor cursor = mDatabase.query(PlanerTable.NAME,null,null,null,null,null,null);
        cursor.moveToLast();
        //TextView textView = (TextView) findViewById(R.id.textView2);
        //textView.setText(cursor.getString(0)+" - "+cursor.getString(1).toString()+" - "+cursor.getString(2).toString()+" - "+cursor.getString(3).toString()+" - "+cursor.getString(4));
    }*/
}