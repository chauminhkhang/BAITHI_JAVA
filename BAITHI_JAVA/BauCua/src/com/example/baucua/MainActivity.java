package com.example.baucua;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	GridView gridView;
	gvwbaucua adapter;
	Integer[] dsbaucua = {R.drawable.nai,R.drawable.bau,R.drawable.ga,R.drawable.ca,R.drawable.cua,R.drawable.tom};
    AnimationDrawable cdXiNgau1, cdXiNgau2, cdXiNgau3;
    ImageView hinhXiNgau1,hinhXiNgau2,hinhXiNgau3;
    Random randomXiNgau;
    int giatriXiNgau1,giatriXiNgau2,giatriXiNgau3;
    Timer timer = new Timer();
    Handler handler;
    int tienthuong;
    Callback callback = new Callback() {
		@Override
		public boolean handleMessage(Message arg0) {
			randomXiNgau1();
			randomXiNgau2();
			randomXiNgau3();
			for(int i = 0; i < gtdatcuoc.length;i++)
			{
				if(gtdatcuoc[i] != 0)
				{
					if(i == giatriXiNgau1)
					{
						tienthuong += gtdatcuoc[i];
					}
					if(i == giatriXiNgau2)
					{
						tienthuong += gtdatcuoc[i];
					}
					if(i == giatriXiNgau3)
					{
						tienthuong += gtdatcuoc[i];
					}
					if(i != giatriXiNgau1 && i != giatriXiNgau2 && i != giatriXiNgau3)
					{
						tienthuong -= gtdatcuoc[i];
					}
				}
			}
			LuuDuLieu(tienthuong);
			tvwTien.setText(String.valueOf(tongtiencu + tienthuong));
			Log.d("KetQua",giatriXiNgau1 + " " + giatriXiNgau2 + " " + giatriXiNgau3 + " " + tienthuong);
			return false;
			
		}
	};
    public static Integer[] gtdatcuoc = new Integer[6];
    SharedPreferences Luutru;
    TextView tvwTien;
    int tongtiencu;
    
    
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gvwBauCua);
        adapter = new gvwbaucua(this,R.layout.banbaucua_layout, dsbaucua);
        gridView.setAdapter(adapter);
        hinhXiNgau1 = (ImageView) findViewById(R.id.imagexingau1);
        hinhXiNgau2 = (ImageView) findViewById(R.id.imagexingau2);
        hinhXiNgau3 = (ImageView) findViewById(R.id.imagexingau3);
        tvwTien = (TextView) findViewById(R.id.textViewTien);
        Luutru = getSharedPreferences("luutruthongtin", Context.MODE_PRIVATE);
        tongtiencu = Luutru.getInt("tongtien", 1000);
        tvwTien.setText(String.valueOf(tongtiencu));
        handler = new Handler(callback);
        
        
    }
	
	private void LuuDuLieu(int tienthuong){
		Editor edit = Luutru.edit();
		edit.putInt("tongtien", tongtiencu + tienthuong);
		edit.commit();
	}
	public void DoXiNgau(View v)
	{
		hinhXiNgau1.setImageResource(R.drawable.xingau);
		hinhXiNgau2.setImageResource(R.drawable.xingau);
		hinhXiNgau3.setImageResource(R.drawable.xingau);
		
		cdXiNgau1 = (AnimationDrawable) hinhXiNgau1.getDrawable();
		cdXiNgau1.start();
		cdXiNgau2 = (AnimationDrawable) hinhXiNgau2.getDrawable();
		cdXiNgau2.start();
		cdXiNgau3 = (AnimationDrawable) hinhXiNgau3.getDrawable();
		cdXiNgau3.start();
		tienthuong = 0;
		timer.schedule(new TimerTask() {	
			public void run() {
				handler.sendEmptyMessage(0);
			}
		}, 1000);
		
		
	}
	
	private void randomXiNgau1(){
		randomXiNgau = new Random();
		switch (randomXiNgau.nextInt(6)) {
		case 0:
			hinhXiNgau1.setImageResource(dsbaucua[0]);
			giatriXiNgau1 = dsbaucua[0];
			break;
		case 1:
			hinhXiNgau1.setImageResource(dsbaucua[1]);
			giatriXiNgau1 = dsbaucua[1];
			break;
		case 2:
			hinhXiNgau1.setImageResource(dsbaucua[2]);
			giatriXiNgau1 = dsbaucua[2];
			break;
		case 3:
			hinhXiNgau1.setImageResource(dsbaucua[3]);
			giatriXiNgau1 = dsbaucua[3];
			break;
		case 4:
			hinhXiNgau1.setImageResource(dsbaucua[4]);
			giatriXiNgau1 = dsbaucua[4];
			break;
		case 5:
			hinhXiNgau1.setImageResource(dsbaucua[5]);
			giatriXiNgau1 = dsbaucua[5];
			break;
		}
	}
	
	private void randomXiNgau2(){
		randomXiNgau = new Random();
		switch (randomXiNgau.nextInt(6)) {
		case 0:
			hinhXiNgau2.setImageResource(dsbaucua[0]);
			giatriXiNgau2 = dsbaucua[0];
			break;
		case 1:
			hinhXiNgau2.setImageResource(dsbaucua[1]);
			giatriXiNgau2 = dsbaucua[1];
			break;
		case 2:
			hinhXiNgau2.setImageResource(dsbaucua[2]);
			giatriXiNgau2 = dsbaucua[2];
			break;
		case 3:
			hinhXiNgau2.setImageResource(dsbaucua[3]);
			giatriXiNgau2 = dsbaucua[3];
			break;
		case 4:
			hinhXiNgau2.setImageResource(dsbaucua[4]);
			giatriXiNgau2 = dsbaucua[4];
			break;
		case 5:
			hinhXiNgau2.setImageResource(dsbaucua[5]);
			giatriXiNgau2 = dsbaucua[5];
			break;
		}
	}
	
	private void randomXiNgau3(){
		randomXiNgau = new Random();
		switch (randomXiNgau.nextInt(6)) {
		case 0:
			hinhXiNgau3.setImageResource(dsbaucua[0]);
			giatriXiNgau3 = dsbaucua[0];
			break;
		case 1:
			hinhXiNgau3.setImageResource(dsbaucua[1]);
			giatriXiNgau3 = dsbaucua[1];
			break;
		case 2:
			hinhXiNgau3.setImageResource(dsbaucua[2]);
			giatriXiNgau3 = dsbaucua[2];
			break;
		case 3:
			hinhXiNgau3.setImageResource(dsbaucua[3]);
			giatriXiNgau3 = dsbaucua[3];
			break;
		case 4:
			hinhXiNgau3.setImageResource(dsbaucua[4]);
			giatriXiNgau3 = dsbaucua[4];
			break;
		case 5:
			hinhXiNgau3.setImageResource(dsbaucua[5]);
			giatriXiNgau3 = dsbaucua[5];
			break;
		}
	}
}
