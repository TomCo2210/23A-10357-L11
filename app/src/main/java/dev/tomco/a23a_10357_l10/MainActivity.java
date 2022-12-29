package dev.tomco.a23a_10357_l10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import dev.tomco.a23a_10357_l10.models.Car;
import dev.tomco.a23a_10357_l10.models.Garage;

public class MainActivity extends AppCompatActivity {
    private TextView main_LBL_title;
    private AppCompatEditText main_ET_text;
    private MaterialButton main_BTN_update;
    private MaterialButton main_BTN_saveGarage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();
        updateTitleOnScreen();

    }

    private void initViews() {
        main_BTN_update.setOnClickListener(v -> {
            setTitle(main_ET_text.getText().toString());
        });
        main_BTN_saveGarage.setOnClickListener(v -> updateCarAsFWD("15-336-66"));
    }

    private void updateCarAsFWD(String licensePlate){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference garageRef = db.getReference("garage");
        garageRef.child("allCars").child(licensePlate).child("fourWheelDrive").setValue(true);
    }

//    private void saveGarage() {
//        Garage garage = new Garage().setName("Garage 1");
//        garage.getAllCars().put(
//                "11-222-33",
//                new Car()
//                        .setLicensePlate("11-222-33")
//                        .setModel("Kia Picanto")
//                        .setType(Car.CarType.GASOLINE)
//                        .setPrice(60_000)
//                        .setFourWheelDrive(false)
//                        .setKmPerLiter(15)
//                        .setOdometer(60_000)
//                );
//        garage.getAllCars().put(
//                "15-336-66",
//                new Car()
//                        .setLicensePlate("15-336-66")
//                        .setModel("Mazda 2")
//                        .setType(Car.CarType.GASOLINE)
//                        .setPrice(25_000)
//                        .setFourWheelDrive(false)
//                        .setKmPerLiter(15)
//                        .setOdometer(220_000)
//        );
//        garage.getAllCars().put(
//                "111-22-333",
//                new Car()
//                        .setLicensePlate("111-22-333")
//                        .setModel("Honda Civic")
//                        .setType(Car.CarType.HYBRID)
//                        .setPrice(120_000)
//                        .setFourWheelDrive(false)
//                        .setKmPerLiter(20)
//                        .setOdometer(120)
//        );
//
//        FirebaseDatabase db = FirebaseDatabase.getInstance();
//        DatabaseReference garageRef = db.getReference("garage");
//        garageRef.setValue(garage);
//
//    }

    private void findViews() {
        main_LBL_title = findViewById(R.id.main_LBL_title);
        main_ET_text = findViewById(R.id.main_ET_text);
        main_BTN_update = findViewById(R.id.main_BTN_update);
        main_BTN_saveGarage = findViewById(R.id.main_BTN_saveGarage);
    }


    private void setTitle(String title) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference titleRef = database.getReference("title");
        Log.d("setTitle", title);
        titleRef.setValue(title);
    }

    private void updateTitleOnScreen(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference titleRef = database.getReference("title");
      //titleRef.addListenerForSingleValueEvent(new ValueEventListener() { // For one time data load.
        titleRef.addValueEventListener(new ValueEventListener() { // for all time data load.
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                main_LBL_title.setText(value);
                Log.d("Value Changed", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Canceled", "Failed to read value.", error.toException());
            }
        });
    }
}