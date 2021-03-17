package com.example.result_faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DashBoard_activity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth auth;

    TextView txtdegree, txtname, txtgpa, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8;
    TextView subject1_degree, subject2_degree, subject3_degree, subject4_degree, subject5_degree, subject6_degree, subject7_degree, subject8_degree;
    TextView subject1_code, subject2_code, subject3_code, subject4_code, subject5_code, subject6_code, subject7_code, subject8_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        calling();
        profile_information();
        sub_names();
        sub_degrees();
        sub_code();
        calc_gpa();


    }

    void calling() {
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        txtdegree = findViewById(R.id.txtdegree);
        txtname = findViewById(R.id.txtname);
        txtgpa = findViewById(R.id.txtgpa);

        subject1 = findViewById(R.id.subject1);
        subject2 = findViewById(R.id.subject2);
        subject3 = findViewById(R.id.subject3);
        subject4 = findViewById(R.id.subject4);
        subject5 = findViewById(R.id.subject5);
        subject6 = findViewById(R.id.subject6);
        subject7 = findViewById(R.id.subject7);
        subject8 = findViewById(R.id.subject8);

        subject1_degree = findViewById(R.id.subject1_degree);
        subject2_degree = findViewById(R.id.subject2_degree);
        subject3_degree = findViewById(R.id.subject3_degree);
        subject4_degree = findViewById(R.id.subject4_degree);
        subject5_degree = findViewById(R.id.subject5_degree);
        subject6_degree = findViewById(R.id.subject6_degree);
        subject7_degree = findViewById(R.id.subject7_degree);
        subject8_degree = findViewById(R.id.subject8_degree);

        subject1_code = findViewById(R.id.subject1_code);
        subject2_code = findViewById(R.id.subject2_code);
        subject3_code = findViewById(R.id.subject3_code);
        subject4_code = findViewById(R.id.subject4_code);
        subject5_code = findViewById(R.id.subject5_code);
        subject6_code = findViewById(R.id.subject6_code);
        subject7_code = findViewById(R.id.subject7_code);
        subject8_code = findViewById(R.id.subject8_code);

    }

    void profile_information() {
        database.getReference().child(auth.getUid()).child("degree").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                txtdegree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
/*        database.getReference().child(auth.getUid()).child("gpa").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               txtgpa.setText(snapshot.getValue().toString());
          }

           @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
                  });
      */
        database.getReference().child(auth.getUid()).child("name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                txtname.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    void sub_names() {
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject1).child(constant.subject_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject1.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject2).child(constant.subject_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject2.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject3).child(constant.subject_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject3.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject4).child(constant.subject_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject4.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject5).child(constant.subject_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject5.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject6).child(constant.subject_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject6.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject7).child(constant.subject_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject7.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject8).child(constant.subject_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject8.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    void sub_degrees() {
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject1).child(constant.subject_degree).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject1_degree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject2).child(constant.subject_degree).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject2_degree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject3).child(constant.subject_degree).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject3_degree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject4).child(constant.subject_degree).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject4_degree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject5).child(constant.subject_degree).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject5_degree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject6).child(constant.subject_degree).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject6_degree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject7).child(constant.subject_degree).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject7_degree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject8).child(constant.subject_degree).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject8_degree.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    void sub_code(){
        database.getReference().child(auth.getUid()).child("subject").child(constant.subject1).child(constant.subject_code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject1_code.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child(auth.getUid()).child("subject").child(constant.subject2).child(constant.subject_code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject2_code.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child(auth.getUid()).child("subject").child(constant.subject3).child(constant.subject_code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject3_code.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child(auth.getUid()).child("subject").child(constant.subject4).child(constant.subject_code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject4_code.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child(auth.getUid()).child("subject").child(constant.subject5).child(constant.subject_code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject5_code.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child(auth.getUid()).child("subject").child(constant.subject6).child(constant.subject_code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject6_code.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child(auth.getUid()).child("subject").child(constant.subject7).child(constant.subject_code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject7_code.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        database.getReference().child(auth.getUid()).child("subject").child(constant.subject8).child(constant.subject_code).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subject8_code.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    void calc_gpa(){

        int sub1 = Integer.valueOf(subject1_degree.getText().toString());
        int sub2 = Integer.valueOf(subject2_degree.getText().toString());
        int result = sub1+sub2;
        txtgpa.setText(subject2_degree.getText().toString() + subject1_degree.getText().toString());


    }
}