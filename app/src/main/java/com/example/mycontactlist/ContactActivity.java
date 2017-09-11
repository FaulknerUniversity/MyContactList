package com.example.mycontactlist;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

public class ContactActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initListButton();
        initMapButton();
        initSettingsButton();
        initToggleButton();
        setForEditing(false);
        initChangeDateButton();
    } //end protected void onCreate(Bundle savedInstanceState)


    private void initListButton(){
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent (ContactActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } //end public void onClick(View v)
        });
    } //private void initMapButton()

    private void initMapButton(){
        ImageButton ibList = (ImageButton) findViewById( R.id.imageButtonMap);
        ibList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent (ContactActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } //end public void onClick(View v)
        });
    } //end private void initListButton()

    private void initSettingsButton(){
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonSettings);
        ibList.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent (ContactActivity.this, ContactSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } //end public void onClick(View v)
        });
    } //end private void initListButton()

    private void initToggleButton(){
        final ToggleButton editToggle = (ToggleButton)findViewById(R.id.toggleButtonEdit);
        editToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                setForEditing(editToggle.isChecked());
            }
        });
    } //end private void initToggleButton(){

    public void setForEditing(boolean enabled) {
        EditText editName = (EditText) findViewById(R.id.editName);
        EditText editAddress = (EditText) findViewById(R.id.editAddress);
        EditText editCity = (EditText) findViewById(R.id.editCity);
        EditText editState = (EditText) findViewById(R.id.editState);
        EditText editZipCode = (EditText) findViewById(R.id.editZipcode);
        EditText editPhone = (EditText) findViewById(R.id.editHome);
        EditText editCell = (EditText) findViewById(R.id.editCell);
        EditText editEmail = (EditText) findViewById(R.id.editEMail);
        Button buttonChange = (Button) findViewById(R.id.btnBirthday);
        Button buttonSave = (Button) findViewById(R.id.buttonSave);

        editName.setEnabled(enabled);
        editAddress.setEnabled(enabled);
        editCity.setEnabled(enabled);
        editState.setEnabled(enabled);
        editZipCode.setEnabled(enabled);
        editPhone.setEnabled(enabled);
        editCell.setEnabled(enabled);
        editEmail.setEnabled(enabled);
        buttonChange.setEnabled(enabled);
        buttonSave.setEnabled(enabled);

        if(enabled){
            editName.requestFocus();
        }

    } //end public void setForEditing(boolean visible)

    @Override
    public void didFinishDateDialog(Calendar selectedTime) {
        TextView birthDay = (TextView) findViewById(R.id.textBirthday);
        birthDay.setText(DateFormat.format("MM/dd/yyyy",
                selectedTime.getTimeInMillis()).toString());
    }

    private void initChangeDateButton() {
        Button changeDate = (Button) findViewById(R.id.btnBirthday);
        changeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog datePickerDialog = new DatePickerDialog();
                datePickerDialog.show(fm, "DatePick");
        }
    });
}

} //end public class ContactActivity extends AppCompatActivity

