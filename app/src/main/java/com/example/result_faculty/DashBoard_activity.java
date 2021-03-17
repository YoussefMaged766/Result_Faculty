package com.example.result_faculty;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;


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

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                calc_gpa();

            }
        }, 5000);


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
//        database.getReference().child(auth.getUid()).child("gpa").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                txtgpa.setText(snapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
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

    void calc_gpa() {

        int sub1 = Integer.parseInt(subject1_degree.getText().toString());
        int sub2 = Integer.parseInt(subject2_degree.getText().toString());
        int sub3 = Integer.parseInt(subject3_degree.getText().toString());
        int sub4 = Integer.parseInt(subject4_degree.getText().toString());
        int sub5 = Integer.parseInt(subject5_degree.getText().toString());
        int sub6 = Integer.parseInt(subject6_degree.getText().toString());
        int sub7 = Integer.parseInt(subject7_degree.getText().toString());
        int sub8 = Integer.parseInt(subject8_degree.getText().toString());


        double gpa1 = 0;
        double gpa2 = 0;
        double gpa3 = 0;
        double gpa4 = 0;
        double gpa5 = 0;
        double gpa6 = 0;
        double gpa7 = 0;
        double gpa8 = 0;
        double gpa9 = 0;
        double gpa10 = 0;
        double gpa11 = 0;

        if (sub1 >= 90 && sub1 <= 100 || sub2 >= 90 && sub2 <= 100 || sub3 >= 90 && sub3 <= 100 || sub4 >= 90 && sub4 <= 100 || sub5 >= 90 && sub5 <= 100 || sub6 >= 90 && sub6 <= 100 || sub7 >= 90 && sub7 <= 100 || sub8 >= 90 && sub8 <= 100) {
            gpa1 = 4.0;
        } else if (sub1 > 85 && sub1 < 90 || sub2 > 85 && sub2 < 90 || sub3 > 85 && sub3 < 90 || sub4 > 85 && sub4 < 90 || sub5 > 85 && sub5 < 90 || sub6 > 85 && sub6 < 90 || sub7 > 85 && sub7 < 90 || sub8 > 85 && sub8 < 90) {
            gpa2 = 3.7;
        } else if (sub1 > 80 && sub1 < 85 || sub2 > 80 && sub2 < 85 || sub3 > 80 && sub3 < 85 || sub4 > 80 && sub4 < 85 || sub5 > 80 && sub5 < 85 || sub6 > 80 && sub6 < 85 || sub7 > 80 && sub7 < 85 || sub8 > 80 && sub8 < 85) {
            gpa3 = 3.3;
        } else if (sub1 > 75 && sub1 < 80 || sub2 > 75 && sub2 < 80 || sub3 > 75 && sub3 < 80 || sub4 > 75 && sub4 < 80 || sub5 > 75 && sub5 < 80 || sub6 > 75 && sub6 < 80 || sub7 > 75 && sub7 < 80 || sub8 > 75 && sub8 < 80) {
             gpa4 = 3.0;
        } else if (sub1 > 70 && sub1 < 75 || sub2 > 70 && sub2 < 75 || sub3 > 70 && sub3 < 75 || sub4 > 70 && sub4 < 75 || sub5 > 70 && sub5 < 75 || sub6 > 70 && sub6 < 75 || sub7 > 70 && sub7 < 75 || sub8 > 70 && sub8 < 75){
            gpa5= 2.7;
        }else if (sub1 > 65 && sub1 < 70 || sub2 > 65 && sub2 < 70 || sub3 > 65 && sub3 < 70 || sub4 > 65 && sub4 < 70|| sub5 > 65 && sub5 < 70 || sub6 > 65 && sub6 < 70|| sub7 > 65&& sub7 < 70 || sub8 > 65 && sub8 < 70){
            gpa6= 2.3;
        }else if (sub1 > 60 && sub1 < 65 || sub2 > 60 && sub2 < 65 || sub3 > 60 && sub3 < 65 || sub4 > 60 && sub4 < 65 || sub5 > 60 && sub5 < 65 || sub6 > 60 && sub6 < 65 || sub7 > 60 && sub7 < 65 || sub8 > 60 && sub8 < 65){
            gpa7= 2.0;
        }else if (sub1 > 55 && sub1 < 60 || sub2 > 55 && sub2 < 60 || sub3 > 55 && sub3 < 60 || sub4 > 55 && sub4 < 60 || sub5 > 55 && sub5 < 60 || sub6 > 55 && sub6 < 60 || sub7 >55 && sub7 < 60 || sub8 > 55 && sub8 < 60){
            gpa8= 1.7;
        }else if (sub1 > 50 && sub1 < 55 || sub2 > 50 && sub2 < 55 || sub3 > 50 && sub3 < 55 || sub4 > 50 && sub4 < 55 || sub5 > 50 && sub5 < 55 || sub6 > 50 && sub6 < 55 || sub7 > 50 && sub7 < 55 || sub8 > 50 && sub8 < 55){
            gpa9= 1.3;
        }else if (sub1 > 45 && sub1 < 50 || sub2 > 45 && sub2 < 50 || sub3 > 45 && sub3 < 50 || sub4 > 45 && sub4 < 50 || sub5 > 45 && sub5 < 50 || sub6 > 45 && sub6 < 50 || sub7 > 45 && sub7 < 50 || sub8 > 45 && sub8 < 50){
            gpa10= 1;
        } else {
            gpa11=0;
        }


        double result1 = (gpa1 * 3 + gpa2 * 2 + gpa3*3 + gpa4*3 + gpa6*2 + gpa5*2 + gpa7*1 + gpa2*2) / 18;
        DecimalFormat df = new DecimalFormat("#.##");
        txtgpa.setText(df.format(result1) + "");


    }
}