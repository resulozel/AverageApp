package com.example.resulozel.ortalamaapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;


public class MainActivity extends AppCompatActivity {

    Button btnYeniDersEkle, btnYeniEklenenDersiSil, btnOrtalamaHesapla;
    LinearLayout rootLayout;
    AutoCompleteTextView etDersAdi, etYeniEklenenDersAdi;
    Spinner spnDersKredi, spnDersNotu, spnYeniDersKredi, spnYeniDersNotu;


    String[] harfNotlar;
    private final String[] ONERILECEK_DERSLER={"Matematik", "Kimya", "Fizik", "Edebiyat","Biyoloji","Felsefe"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        harfNotlar = getResources().getStringArray(R.array.tumNotlar);


        btnYeniDersEkle = findViewById(R.id.btnDersEkle);
        btnOrtalamaHesapla=findViewById(R.id.btnHesapla);

        rootLayout = findViewById(R.id.rootLayout);

        etDersAdi = findViewById(R.id.etDersAd);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ONERILECEK_DERSLER);
        etDersAdi.setAdapter(adapter);

        spnDersKredi = findViewById(R.id.spnKredi);
        spnDersNotu = findViewById(R.id.spnNot);

        if(rootLayout.getChildCount() == 0){
            btnOrtalamaHesapla.setVisibility(View.INVISIBLE);
        }else btnOrtalamaHesapla.setVisibility(View.VISIBLE);

        btnYeniDersEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etDersAdi.getText() != null && etDersAdi.getText().length() != 0) {
                    //xml kodu java koduna dönüştürülür
                    LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                    LayoutInflater inflater1 = getLayoutInflater();
                    LayoutInflater inflater2 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    final View yeniEklenecekDersLayout = inflater.inflate(R.layout.yeni_ders_layout, rootLayout, false);

                    //yeni dersi layouta eklemeden önce kullanıcının girdiği değerleri okuyalım
                    String dersAdi = etDersAdi.getText().toString();
                    int dersNotu = spnDersNotu.getSelectedItemPosition();
                    int dersKredi = spnDersKredi.getSelectedItemPosition();

                    //yeni dersi layouta eklemeden önce bu değerleri viewlara atayalım
                    //önce bu viewları bulalım.
                    etYeniEklenenDersAdi = yeniEklenecekDersLayout.findViewById(R.id.etYeniDersAd);
                    etYeniEklenenDersAdi.setAdapter(adapter);

                    spnYeniDersKredi = yeniEklenecekDersLayout.findViewById(R.id.spnYeniDersKredi);
                    spnYeniDersNotu = yeniEklenecekDersLayout.findViewById(R.id.spnYeniDersNot);

                    etYeniEklenenDersAdi.setText(dersAdi);
                    spnYeniDersNotu.setSelection(dersNotu);
                    spnYeniDersKredi.setSelection(dersKredi);

                    btnYeniEklenenDersiSil = yeniEklenecekDersLayout.findViewById(R.id.btnYeniDersSil);


                    btnYeniEklenenDersiSil.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            rootLayout.removeView(yeniEklenecekDersLayout);
                            if(rootLayout.getChildCount() == 0){
                                btnOrtalamaHesapla.setVisibility(View.INVISIBLE);
                            }else btnOrtalamaHesapla.setVisibility(View.VISIBLE);
                        }
                    });


                    rootLayout.addView(yeniEklenecekDersLayout);
                    btnOrtalamaHesapla.setVisibility(View.VISIBLE);
                    sifirla();
                } else {

                    FancyToast.makeText(MainActivity.this,"Ders Adını Giriniz",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }


            }
        });


    }

    private void sifirla() {

        etDersAdi.setText("");
        spnDersKredi.setSelection(0);
        spnDersNotu.setSelection(0);
    }


    public void ortalamaHesapla(View view) {

        double toplamNot = 0.0;
        double toplamKredi = 0.0;

        for (int i = 0; i < rootLayout.getChildCount(); i++) {

            View geciciSatir = rootLayout.getChildAt(i);

            AutoCompleteTextView dersAdi = geciciSatir.findViewById(R.id.etYeniDersAd);
            Spinner dersKredi = geciciSatir.findViewById(R.id.spnYeniDersKredi);
            Spinner dersNotu = geciciSatir.findViewById(R.id.spnYeniDersNot);

            Dersler geciciDers = new Dersler(dersAdi.getText().toString(), (dersKredi.getSelectedItemPosition()), dersNotu.getSelectedItemPosition());


            double geciciDersinKredisi = (double)(geciciDers.getDersKredi()+1);
            double geciciDersinNotDegeri= harfiNotaCevir(harfNotlar[((int) geciciDers.getDersNotu())]);

            toplamNot += geciciDersinNotDegeri * geciciDersinKredisi;
            toplamKredi += geciciDersinKredisi;


            //girilenTumDersler.add(geciciDers);

        }


        Toast.makeText(MainActivity.this,"ORTALAMA : "+ (toplamNot/toplamKredi) ,Toast.LENGTH_LONG).show();


    }

    private double harfiNotaCevir(String s) {

        double deger = 0.0;

        switch (s){

            case "AA" :
                deger = 4.0;
                break;

            case "BA" :
                deger = 3.5;
                break;

            case "BB" :
                deger = 3.0;
                break;

            case "CB" :
                deger = 2.5;
                break;

            case "CC" :
                deger = 2.0;
                break;

            case "DC" :
                deger = 1.5;
                break;

            case "DD" :
                deger = 1.0;
                break;

            case "FF" :
                deger = 0.0;
                break;

        }

        return deger;
    }
}
