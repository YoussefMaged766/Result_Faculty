package com.example.result_faculty;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
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
    ProgressBar progressBar;

    TextView txtdegree, txtname, txtgpa, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8;
    TextView subject1_degree, subject2_degree, subject3_degree, subject4_degree, subject5_degree, subject6_degree, subject7_degree, subject8_degree;
    TextView subject1_code, subject2_code, subject3_code, subject4_code, subject5_code, subject6_code, subject7_code, subject8_code;
    double gpa;
    double gpa1;
    double gpa2;
    double gpa3;
    double gpa4;
    double gpa5;
    double gpa6;
    double gpa7;
    double gpa8;

    int sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        calling();
        profile_information();
        sub_names();
       // sub_degrees();
        sub_code();
        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sub_degrees();


            }
        }, 4500);
        final Handler handler2 = new Handler(Looper.getMainLooper());
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
        progressBar.setVisibility(View.GONE);
                calc_gpa();

            }
        }, 7000);



    }

    void calling() {
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        txtdegree = findViewById(R.id.txtdegree);
        txtname = findViewById(R.id.txtname);
        txtgpa = findViewById(R.id.txtgpa);
        progressBar = findViewById(R.id.progress);

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

    void sub_code() {
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

        sub1 = Integer.parseInt(subject1_degree.getText().toString());
        sub2 = Integer.parseInt(subject2_degree.getText().toString());
        sub3 = Integer.parseInt(subject3_degree.getText().toString());
        sub4 = Integer.parseInt(subject4_degree.getText().toString());
        sub5 = Integer.parseInt(subject5_degree.getText().toString());
        sub6 = Integer.parseInt(subject6_degree.getText().toString());
        sub7 = Integer.parseInt(subject7_degree.getText().toString());
        sub8 = Integer.parseInt(subject8_degree.getText().toString());


//        if (sub1 >= 90 && sub1 <= 100 || sub2 >= 90 && sub2 <= 100 || sub3 >= 90 && sub3 <= 100 || sub4 >= 90 && sub4 <= 100 || sub5 >= 90 && sub5 <= 100 || sub6 >= 90 && sub6 <= 100 || sub7 >= 90 && sub7 <= 100 || sub8 >= 90 && sub8 <= 100) {
//            gpa = 4.0;
//        } else if (sub1 >= 85 && sub1 < 90 || sub2 >= 85 && sub2 < 90 || sub3 >= 85 && sub3 < 90 || sub4 >= 85 && sub4 < 90 || sub5 >= 85 && sub5 < 90 || sub6 >= 85 && sub6 < 90 || sub7 >= 85 && sub7 < 90 || sub8 >= 85 && sub8 < 90) {
//            gpa = 3.7;
//        } else if (sub1 >= 80 && sub1 < 85 || sub2 >= 80 && sub2 < 85 || sub3 >= 80 && sub3 < 85 || sub4 >= 80 && sub4 < 85 || sub5 >= 80 && sub5 < 85 || sub6 >= 80 && sub6 < 85 || sub7 >= 80 && sub7 < 85 || sub8 >= 80 && sub8 < 85) {
//            gpa = 3.3;
//        } else if (sub1 >= 75 && sub1 < 80 || sub2 >= 75 && sub2 < 80 || sub3 >= 75 && sub3 < 80 || sub4 >= 75 && sub4 < 80 || sub5 >= 75 && sub5 < 80 || sub6 >= 75 && sub6 < 80 || sub7 >= 75 && sub7 < 80 || sub8 >= 75 && sub8 < 80) {
//            gpa = 3.0;
//        } else if (sub1 >= 70 && sub1 < 75 || sub2 >= 70 && sub2 < 75 || sub3 >= 70 && sub3 < 75 || sub4 >= 70 && sub4 < 75 || sub5 >= 70 && sub5 < 75 || sub6 >= 70 && sub6 < 75 || sub7 >= 70 && sub7 < 75 || sub8 >= 70 && sub8 < 75) {
//            gpa = 2.7;
//        } else if (sub1 >= 65 && sub1 < 70 || sub2 >= 65 && sub2 < 70 || sub3 >= 65 && sub3 < 70 || sub4 >= 65 && sub4 < 70 || sub5 >= 65 && sub5 < 70 || sub6 >= 65 && sub6 < 70 || sub7 >= 65 && sub7 < 70 || sub8 >= 65 && sub8 < 70) {
//            gpa = 2.3;
//        } else if (sub1 >= 60 && sub1 < 65 || sub2 >= 60 && sub2 < 65 || sub3 >= 60 && sub3 < 65 || sub4 >= 60 && sub4 < 65 || sub5 >= 60 && sub5 < 65 || sub6 >= 60 && sub6 < 65 || sub7 >= 60 && sub7 < 65 || sub8 >= 60 && sub8 < 65) {
//            gpa = 2.0;
//        } else if (sub1 >= 55 && sub1 < 60 || sub2 >= 55 && sub2 < 60 || sub3 >= 55 && sub3 < 60 || sub4 >= 55 && sub4 < 60 || sub5 >= 55 && sub5 < 60 || sub6 >= 55 && sub6 < 60 || sub7 >= 55 && sub7 < 60 || sub8 >= 55 && sub8 < 60) {
//            gpa = 1.7;
//        } else if (sub1 >= 50 && sub1 < 55 || sub2 >= 50 && sub2 < 55 || sub3 >= 50 && sub3 < 55 || sub4 >= 50 && sub4 < 55 || sub5 >= 50 && sub5 < 55 || sub6 >= 50 && sub6 < 55 || sub7 >= 50 && sub7 < 55 || sub8 >= 50 && sub8 < 55) {
//            gpa = 1.3;
//        } else if (sub1 >= 45 && sub1 < 50 || sub2 >= 45 && sub2 < 50 || sub3 >= 45 && sub3 < 50 || sub4 >= 45 && sub4 < 50 || sub5 >= 45 && sub5 < 50 || sub6 >= 45 && sub6 < 50 || sub7 >= 45 && sub7 < 50 || sub8 >= 45 && sub8 < 50) {
//            gpa = 1;
//        } else {
//            gpa = 0;
//        }


        if (sub1 >= 90 && sub1 <= 100) {
            gpa1 = 4.0;
        } else if (sub1 >= 85 && sub1 < 90) {
            gpa1 = 3.7;
        } else if (sub1 >= 80 && sub1 < 85) {
            gpa1 = 3.3;
        } else if (sub1 >= 75 && sub1 < 80) {
            gpa1 = 3.0;
        } else if (sub1 >= 70 && sub1 < 75) {
            gpa1 = 2.7;
        } else if (sub1 >= 65 && sub1 < 70) {
            gpa1 = 2.3;
        } else if (sub1 >= 60 && sub1 < 65) {
            gpa1 = 2.0;
        } else if (sub1 >= 55 && sub1 < 60) {
            gpa1 = 1.7;
        } else if (sub1 > 50 && sub1 < 55) {
            gpa1 = 1.3;
        } else if (sub1 > 45 && sub1 < 50) {
            gpa1 = 1.0;
        } else {
            gpa1 = 0;
        }

        if (sub2 >= 90 && sub2 <= 100) {
            gpa2 = 4.0;
        } else if (sub2 >= 85 && sub2 < 90) {
            gpa2 = 3.7;
        } else if (sub2 >= 80 && sub2 < 85) {
            gpa2 = 3.3;
        } else if (sub2 >= 75 && sub2 < 80) {
            gpa2 = 3.0;
        } else if (sub2 >= 70 && sub2 < 75) {
            gpa2 = 2.7;
        } else if (sub2 >= 65 && sub2 < 70) {
            gpa2 = 2.3;
        } else if (sub2 >= 60 && sub2 < 65) {
            gpa2 = 2.0;
        } else if (sub2 >= 55 && sub2 < 60) {
            gpa2 = 1.7;
        } else if (sub2 > 50 && sub2 < 55) {
            gpa2 = 1.3;
        } else if (sub2 > 45 && sub2 < 50) {
            gpa2 = 1.0;
        } else {
            gpa2 = 0;
        }


        if (sub3 >= 90 && sub3 <= 100) {
            gpa3 = 4.0;
        } else if (sub3 >= 85 && sub3 < 90) {
            gpa3 = 3.7;
        } else if (sub3 >= 80 && sub3 < 85) {
            gpa3 = 3.3;
        } else if (sub3 >= 75 && sub3 < 80) {
            gpa3 = 3.0;
        } else if (sub3 >= 70 && sub3 < 75) {
            gpa3 = 2.7;
        } else if (sub3 >= 65 && sub3 < 70) {
            gpa3 = 2.3;
        } else if (sub3 >= 60 && sub3 < 65) {
            gpa3 = 2.0;
        } else if (sub3 >= 55 && sub3 < 60) {
            gpa3 = 1.7;
        } else if (sub3 > 50 && sub3 < 55) {
            gpa3 = 1.3;
        } else if (sub3 > 45 && sub3 < 50) {
            gpa3 = 1.0;
        } else {
            gpa3 = 0;
        }


        if (sub4 >= 90 && sub4 <= 100) {
            gpa4 = 4.0;
        } else if (sub4 >= 85 && sub4 < 90) {
            gpa4 = 3.7;
        } else if (sub4 >= 80 && sub4 < 85) {
            gpa4 = 3.3;
        } else if (sub4 >= 75 && sub4 < 80) {
            gpa4 = 3.0;
        } else if (sub4 >= 70 && sub4 < 75) {
            gpa4 = 2.7;
        } else if (sub4 >= 65 && sub4 < 70) {
            gpa4 = 2.3;
        } else if (sub4 >= 60 && sub4 < 65) {
            gpa4 = 2.0;
        } else if (sub4 >= 55 && sub4 < 60) {
            gpa4 = 1.7;
        } else if (sub4 > 50 && sub4 < 55) {
            gpa4 = 1.3;
        } else if (sub4 > 45 && sub4 < 50) {
            gpa4 = 1.0;
        } else {
            gpa4 = 0;
        }


        if (sub5 >= 90 && sub5 <= 100) {
            gpa5 = 4.0;
        } else if (sub5 >= 85 && sub5 < 90) {
            gpa5 = 3.7;
        } else if (sub5 >= 80 && sub5 < 85) {
            gpa5 = 3.3;
        } else if (sub5 >= 75 && sub5 < 80) {
            gpa5 = 3.0;
        } else if (sub5 >= 70 && sub5 < 75) {
            gpa5 = 2.7;
        } else if (sub5 >= 65 && sub5 < 70) {
            gpa5 = 2.3;
        } else if (sub5 >= 60 && sub5 < 65) {
            gpa5 = 2.0;
        } else if (sub5 >= 55 && sub5 < 60) {
            gpa5 = 1.7;
        } else if (sub5 > 50 && sub5 < 55) {
            gpa5 = 1.3;
        } else if (sub5 > 45 && sub5 < 50) {
            gpa5 = 1.0;
        } else {
            gpa5 = 0;
        }


        if (sub6 >= 90 && sub6 <= 100) {
            gpa6 = 4.0;
        } else if (sub6 >= 85 && sub6 < 90) {
            gpa6 = 3.7;
        } else if (sub6 >= 80 && sub6 < 85) {
            gpa6 = 3.3;
        } else if (sub6 >= 75 && sub6 < 80) {
            gpa6 = 3.0;
        } else if (sub6 >= 70 && sub6 < 75) {
            gpa6 = 2.7;
        } else if (sub6 >= 65 && sub6 < 70) {
            gpa6 = 2.3;
        } else if (sub6 >= 60 && sub6 < 65) {
            gpa6 = 2.0;
        } else if (sub6 >= 55 && sub6 < 60) {
            gpa6 = 1.7;
        } else if (sub6 > 50 && sub6 < 55) {
            gpa6 = 1.3;
        } else if (sub6 > 45 && sub6 < 50) {
            gpa6 = 1.0;
        } else {
            gpa6 = 0;
        }


        if (sub7 >= 90 && sub7 <= 100) {
            gpa7 = 4.0;
        } else if (sub7 >= 85 && sub7 < 90) {
            gpa7 = 3.7;
        } else if (sub7 >= 80 && sub7 < 85) {
            gpa7 = 3.3;
        } else if (sub7 >= 75 && sub7 < 80) {
            gpa7 = 3.0;
        } else if (sub7 >= 70 && sub7 < 75) {
            gpa7 = 2.7;
        } else if (sub7 >= 65 && sub7 < 70) {
            gpa7 = 2.3;
        } else if (sub7 >= 60 && sub7 < 65) {
            gpa7 = 2.0;
        } else if (sub7 >= 55 && sub7 < 60) {
            gpa7 = 1.7;
        } else if (sub7 > 50 && sub7 < 55) {
            gpa7 = 1.3;
        } else if (sub7 > 45 && sub7 < 50) {
            gpa7 = 1.0;
        } else {
            gpa7 = 0;
        }


        if (sub8 >= 90 && sub8 <= 100) {
            gpa8 = 4.0;
        } else if (sub8 >= 85 && sub8 < 90) {
            gpa8 = 3.7;
        } else if (sub8 >= 80 && sub8 < 85) {
            gpa8 = 3.3;
        } else if (sub8 >= 75 && sub8 < 80) {
            gpa8 = 3.0;
        } else if (sub8 >= 70 && sub8 < 75) {
            gpa8 = 2.7;
        } else if (sub8 >= 65 && sub8 < 70) {
            gpa8 = 2.3;
        } else if (sub8 >= 60 && sub8 < 65) {
            gpa8 = 2.0;
        } else if (sub8 >= 55 && sub8 < 60) {
            gpa8 = 1.7;
        } else if (sub8 > 50 && sub8 < 55) {
            gpa8 = 1.3;
        } else if (sub8 > 45 && sub8 < 50) {
            gpa8 = 1.0;
        } else {
            gpa8 = 0;
        }

//        switch (sub1){
//
//                case 1: if (sub1>=90 && sub1<=100){
//                    gpa1 = 4.0;
//                    break;
//                }
//                case 2:  if (  sub1 >=85 && sub1 <90 ){
//                        gpa1 = 3.7;
//                        break;
//                    }
//                case 3:   if (  sub1 >=80 && sub1 <85 ){
//                        gpa1 = 3.3;
//                        break;
//                    }
//                case 4:  if (  sub1 >=75 && sub1 <80 ){
//                        gpa1 = 3.0;
//                        break;
//                    }
//                case 5:  if (  sub1 >=70 && sub1 <75 ){
//                        gpa1 = 2.7;
//                        break;
//                    }
//                case 6 : if (  sub1 >=65 && sub1 <70 ){
//                        gpa1 = 2.3;
//                        break;
//                    }
//                case 7:   if (  sub1 >=60 && sub1 <65 ){
//                        gpa1 = 2.0;
//                        break;
//                    }
//                case 8:  if (  sub1 >=55 && sub1 <60 ){
//                        gpa1 = 1.7;
//                        break;
//                    }
//                case 9:if (  sub1 >50 && sub1<55 ){
//                        gpa1 = 1.3;
//                        break;
//                    }
//                case 10:  if (  sub1 >45 && sub1 <50 ){
//                        gpa1 = 1.0;
//                        break;
//                    }
//            }
//
//        switch (sub2){
//            case 1: if (sub2>=90 && sub2<=100){
//                gpa2 = 4.0;
//                break;
//            }
//            case 2:  if (  sub2 >=85 && sub2 <90 ){
//                gpa2 = 3.7;
//                break;
//            }
//            case 3:   if (  sub2 >=80 && sub2 <85 ){
//                gpa2 = 3.3;
//                break;
//            }
//            case 4:  if (  sub2 >=75 && sub2 <80 ){
//                gpa2 = 3.0;
//                break;
//            }
//            case 5:  if (  sub2 >=70 && sub2 <75 ){
//                gpa2 = 2.7;
//                break;
//            }
//            case 6 : if (  sub2>=65 && sub2 <70 ){
//                gpa2 = 2.3;
//                break;
//            }
//            case 7:   if (  sub2 >=60 && sub2 <65 ){
//                gpa2 = 2.0;
//                break;
//            }
//            case 8:  if (  sub2 >=55 && sub2 <60 ){
//                gpa2 = 1.7;
//                break;
//            }
//            case 9:if (  sub2 >50 && sub2<55 ){
//                gpa2 = 1.3;
//                break;
//            }
//            case 10:  if (  sub2 >45 && sub2 <50 ){
//                gpa2 = 1.0;
//                break;
//            }
//
//        }
//
//        switch (sub3){
//            case 1: if (sub3>=90 && sub3<=100){
//                gpa3 = 4.0;
//                break;
//            }
//            case 2:  if (  sub3 >=85 && sub3 <90 ){
//                gpa3 = 3.7;
//                break;
//            }
//            case 3:   if (  sub3 >=80 && sub3 <85 ){
//                gpa3 = 3.3;
//                break;
//            }
//            case 4:  if (  sub3 >=75 && sub3 <80 ){
//                gpa3 = 3.0;
//                break;
//            }
//            case 5:  if (  sub3 >=70 && sub3 <75 ){
//                gpa3 = 2.7;
//                break;
//            }
//            case 6 : if (  sub3 >=65 && sub3 <70 ){
//                gpa3 = 2.3;
//                break;
//            }
//            case 7:   if (  sub3 >=60 && sub3 <65 ){
//                gpa3 = 2.0;
//                break;
//            }
//            case 8:  if (  sub3 >=55 && sub3 <60 ){
//                gpa3 = 1.7;
//                break;
//            }
//            case 9:if (  sub3 >50 && sub3<55 ){
//                gpa3 = 1.3;
//                break;
//            }
//            case 10:  if (  sub3 >45 && sub3 <50 ){
//                gpa3 = 1.0;
//                break;
//            }
//        }
//
//        switch (sub4){
//            case 1: if (sub4>=90 && sub4<=100){
//                gpa4 = 4.0;
//                break;
//            }
//            case 2:  if (  sub4 >=85 && sub4 <90 ){
//                gpa4 = 3.7;
//                break;
//            }
//            case 3:   if (  sub4 >=80 && sub4 <85 ){
//                gpa4 = 3.3;
//                break;
//            }
//            case 4:  if (  sub4 >=75 && sub4 <80 ){
//                gpa4 = 3.0;
//                break;
//            }
//            case 5:  if (  sub4 >=70 && sub4 <75 ){
//                gpa4 = 2.7;
//                break;
//            }
//            case 6 : if (  sub4 >=65 && sub4 <70 ){
//                gpa4 = 2.3;
//                break;
//            }
//            case 7:   if (  sub4 >=60 && sub4 <65 ){
//                gpa4 = 2.0;
//                break;
//            }
//            case 8:  if (  sub4 >=55 && sub4 <60 ){
//                gpa4 = 1.7;
//                break;
//            }
//            case 9:if (  sub4 >50 && sub4<55 ){
//                gpa4 = 1.3;
//                break;
//            }
//            case 10:  if (  sub4 >45 && sub4 <50 ){
//                gpa4= 1.0;
//                break;
//            }
//        }
//
//        switch (sub5){
//            case 1: if (sub5>=90 && sub5<=100){
//                gpa5 = 4.0;
//                break;
//            }
//            case 2:  if (  sub5 >=85 && sub5 <90 ){
//                gpa5 = 3.7;
//                break;
//            }
//            case 3:   if (  sub5 >=80 && sub5 <85 ){
//                gpa5 = 3.3;
//                break;
//            }
//            case 4:  if (  sub5 >=75 && sub5 <80 ){
//                gpa5 = 3.0;
//                break;
//            }
//            case 5:  if (  sub5 >=70 && sub5 <75 ){
//                gpa5 = 2.7;
//                break;
//            }
//            case 6 : if (  sub5 >=65 && sub5 <70 ){
//                gpa5 = 2.3;
//                break;
//            }
//            case 7:   if (  sub5 >=60 && sub5 <65 ){
//                gpa5 = 2.0;
//                break;
//            }
//            case 8:  if (  sub5 >=55 && sub5 <60 ){
//                gpa5 = 1.7;
//                break;
//            }
//            case 9:if (  sub5 >50 && sub5<55 ){
//                gpa5 = 1.3;
//                break;
//            }
//            case 10:  if (  sub5 >45 && sub5 <50 ){
//                gpa5 = 1.0;
//                break;
//            }
//        }
//
//        switch (sub6){
//            case 1: if (sub6>=90 && sub6<=100){
//                gpa6 = 4.0;
//                break;
//            }
//            case 2:  if (  sub6 >=85 && sub6 <90 ){
//                gpa6 = 3.7;
//                break;
//            }
//            case 3:   if (  sub6 >=80 && sub6 <85 ){
//                gpa6 = 3.3;
//                break;
//            }
//            case 4:  if (  sub6 >=75 && sub6 <80 ){
//                gpa6 = 3.0;
//                break;
//            }
//            case 5:  if (  sub6 >=70 && sub6 <75 ){
//                gpa6 = 2.7;
//                break;
//            }
//            case 6 : if (  sub6 >=65 && sub6 <70 ){
//                gpa6 = 2.3;
//                break;
//            }
//            case 7:   if (  sub6 >=60 && sub6 <65 ){
//                gpa6 = 2.0;
//                break;
//            }
//            case 8:  if (  sub6 >=55 && sub6 <60 ){
//                gpa6 = 1.7;
//                break;
//            }
//            case 9:if (  sub6 >50 && sub6<55 ){
//                gpa6 = 1.3;
//                break;
//            }
//            case 10:  if (  sub6 >45 && sub6 <50 ){
//                gpa6 = 1.0;
//                break;
//            }
//        }
//
//        switch (sub7){
//            case 1: if (sub7>=90 && sub7<=100){
//                gpa7 = 4.0;
//                break;
//            }
//            case 2:  if (  sub7 >=85 && sub7 <90 ){
//                gpa7 = 3.7;
//                break;
//            }
//            case 3:   if (  sub7 >=80 && sub7 <85 ){
//                gpa7 = 3.3;
//                break;
//            }
//            case 4:  if (  sub7 >=75 && sub7 <80 ){
//                gpa7 = 3.0;
//                break;
//            }
//            case 5:  if (  sub7 >=70 && sub7 <75 ){
//                gpa7 = 2.7;
//                break;
//            }
//            case 6 : if (  sub7 >=65 && sub7 <70 ){
//                gpa7 = 2.3;
//                break;
//            }
//            case 7:   if (  sub7 >=60 && sub7 <65 ){
//                gpa7 = 2.0;
//                break;
//            }
//            case 8:  if (  sub7>=55 && sub7 <60 ){
//                gpa7 = 1.7;
//                break;
//            }
//            case 9:if (  sub7 >50 && sub7<55 ){
//                gpa7 = 1.3;
//                break;
//            }
//            case 10:  if (  sub7 >45 && sub7 <50 ){
//                gpa7 = 1.0;
//                break;
//            }
//        }
//
//        switch (sub8){
//            case 1: if (sub8>=90 && sub8<=100){
//                gpa8 = 4.0;
//                break;
//            }
//            case 2:  if (  sub8 >=85 && sub8 <90 ){
//                gpa8 = 3.7;
//                break;
//            }
//            case 3:   if (  sub8 >=80 && sub8 <85 ){
//                gpa8 = 3.3;
//                break;
//            }
//            case 4:  if (  sub8 >=75 && sub8 <80 ){
//                gpa8 = 3.0;
//                break;
//            }
//            case 5:  if (  sub8 >=70 && sub8 <75 ){
//                gpa8 = 2.7;
//                break;
//            }
//            case 6 : if (  sub8 >=65 && sub8 <70 ){
//                gpa8 = 2.3;
//                break;
//            }
//            case 7:   if (  sub8 >=60 && sub8 <65 ){
//                gpa8 = 2.0;
//                break;
//            }
//            case 8:  if (  sub8 >=55 && sub8 <60 ){
//                gpa8 = 1.7;
//                break;
//            }
//            case 9:if (  sub8 >50 && sub8<55 ){
//                gpa8 = 1.3;
//                break;
//            }
//            case 10:  if (  sub8 >45 && sub8 <50 ){
//                gpa8 = 1.0;
//                break;
//            }
//        }
        //degree colors

        if (sub1 >= 80 && sub1 <= 100) {
            subject1_degree.setTextColor(getResources().getColor(R.color.green));
        } else if (sub1 >= 50 && sub1 < 80) {
            subject1_degree.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            subject1_degree.setTextColor(getResources().getColor(R.color.red));
        }

        if (sub2 >= 80 && sub2 <= 100) {
            subject2_degree.setTextColor(getResources().getColor(R.color.green));
        } else if (sub2 >= 50 && sub2 < 80) {
            subject2_degree.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            subject2_degree.setTextColor(getResources().getColor(R.color.red));
        }

        if (sub3 >= 80 && sub3 <= 100) {
            subject3_degree.setTextColor(getResources().getColor(R.color.green));
        } else if (sub3 >= 50 && sub3 < 80) {
            subject3_degree.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            subject3_degree.setTextColor(getResources().getColor(R.color.red));
        }

        if (sub4 >= 80 && sub4 <= 100) {
            subject4_degree.setTextColor(getResources().getColor(R.color.green));
        } else if (sub4 >= 50 && sub4 < 80) {
            subject4_degree.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            subject4_degree.setTextColor(getResources().getColor(R.color.red));
        }

        if (sub5 >= 80 && sub5 <= 100) {
            subject5_degree.setTextColor(getResources().getColor(R.color.green));
        } else if (sub5 >= 50 && sub5 < 80) {
            subject5_degree.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            subject5_degree.setTextColor(getResources().getColor(R.color.red));
        }

        if (sub6 >= 80 && sub6 <= 100) {
            subject6_degree.setTextColor(getResources().getColor(R.color.green));
        } else if (sub6 >= 50 && sub6 < 80) {
            subject6_degree.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            subject6_degree.setTextColor(getResources().getColor(R.color.red));
        }

        if (sub7 >= 80 && sub7 <= 100) {
            subject7_degree.setTextColor(getResources().getColor(R.color.green));
        } else if (sub7 >= 50 && sub7 < 80) {
            subject7_degree.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            subject7_degree.setTextColor(getResources().getColor(R.color.red));

        }
        if (sub8 >= 80 && sub8 <= 100) {
            subject8_degree.setTextColor(getResources().getColor(R.color.green));
        } else if (sub8 >= 50 && sub8 < 80) {
            subject8_degree.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            subject8_degree.setTextColor(getResources().getColor(R.color.red));
        }

        double result1 = (gpa1 * 3 + gpa2 * 2 + gpa3 * 1 + gpa4 * 3 + gpa5 * 2 + gpa6 * 2 + gpa7 * 3 + gpa8 * 2) / 18;
        DecimalFormat df = new DecimalFormat("#.##");
        txtgpa.setText(df.format(result1) + "");




    }



}