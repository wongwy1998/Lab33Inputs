package my.edu.tarc.lab33inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
         private Spinner spinnerAge;
         private RadioGroup radioGroupGender;
         private RadioButton radioButtonMale,radioButtonFemale;
         private CheckBox checkBoxSmoker;
         private TextView textViewpremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewpremium = findViewById(R.id.textViewPremium);

        //Create an adapter and link it to the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Position =" +position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){

        int position;
        float premium = 0;
        position = spinnerAge.getSelectedItemPosition();
        switch (position){
            case 0:
                // calculate premium
                premium = 50;
                break;
            case 1:
                premium = 55;break;

            case 2:
                premium = 60;break;

            case 3:
                premium = 70;break;

            case 4:
                premium = 120;break;

            case 5:
                premium =160;break;

            case 6:
                premium = 200;break;

            case 7:
                premium= 250;break;

        }

        int gender;
        gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            switch (position){
                case 2:
                    gender = 50;
                    premium = premium +gender;
                    break;
                case 3:
                    gender = 100;premium = premium +gender;break;
                case 4:
                    gender = 100;premium = premium +gender;break;
                case 5:
                    gender = 50;premium = premium +gender;break;
                default: break;

            }

        }

        if(checkBoxSmoker.isChecked()){
            switch(position){
                case 3:
                    premium = premium +100;break;
                case 4:
                    premium = premium +150;break;
                case 5:
                    premium = premium +150;break;
                case 6:
                    premium = premium +250;break;
                case 7:
                    premium = premium +250;break;
                    default: break;


            }

        }

        textViewpremium.setText(getString(R.string.premium)+ " " +premium);

    }
}
