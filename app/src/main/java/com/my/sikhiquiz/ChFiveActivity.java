package com.my.sikhiquiz;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ChFiveActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private String answer = "";
	private double score = 0;
	private double n = 0;
	private HashMap<String, Object> vmap = new HashMap<>();
	private double q = 0;
	
	private ArrayList<HashMap<String, Object>> lmap = new ArrayList<>();
	
	private LinearLayout linear_play;
	private LinearLayout linear8;
	private LinearLayout linear2;
	private LinearLayout linear18;
	private LinearLayout linear6;
	private LinearLayout linear17;
	private LinearLayout linear7;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview1;
	private TextView textview3;
	private TextView textview4;
	private LinearLayout Linear_hint;
	private LinearLayout linear20;
	private LinearLayout linear19;
	private TextView textview5;
	private TextView textview16;
	private TextView textview2;
	private LinearLayout round1;
	private LinearLayout round2;
	private LinearLayout round3;
	private LinearLayout round4;
	private Button button1;
	private TextView textview6;
	private CheckBox checkbox1;
	private TextView textview7;
	private CheckBox checkbox2;
	private TextView textview8;
	private CheckBox checkbox3;
	private TextView textview9;
	private CheckBox checkbox4;
	private LinearLayout linear9;
	private LinearLayout linear21;
	private LinearLayout linear15;
	private LinearLayout linear12;
	private LinearLayout linear11;
	private LinearLayout linear16;
	private LinearLayout linear10;
	private LinearLayout linear13;
	private TextView textview12;
	private TextView textview15;
	private TextView textview10;
	private TextView textview11;
	private LinearLayout linear14;
	private LinearLayout linear22;
	private TextView textview13;
	private TextView textview17;
	private TextView textview14;
	
	private TimerTask t;
	private SharedPreferences sp;
	private Intent i = new Intent();
	private ObjectAnimator object = new ObjectAnimator();
	private MediaPlayer MP;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ch_five);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear_play = findViewById(R.id.linear_play);
		linear8 = findViewById(R.id.linear8);
		linear2 = findViewById(R.id.linear2);
		linear18 = findViewById(R.id.linear18);
		linear6 = findViewById(R.id.linear6);
		linear17 = findViewById(R.id.linear17);
		linear7 = findViewById(R.id.linear7);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		textview1 = findViewById(R.id.textview1);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		Linear_hint = findViewById(R.id.Linear_hint);
		linear20 = findViewById(R.id.linear20);
		linear19 = findViewById(R.id.linear19);
		textview5 = findViewById(R.id.textview5);
		textview16 = findViewById(R.id.textview16);
		textview2 = findViewById(R.id.textview2);
		round1 = findViewById(R.id.round1);
		round2 = findViewById(R.id.round2);
		round3 = findViewById(R.id.round3);
		round4 = findViewById(R.id.round4);
		button1 = findViewById(R.id.button1);
		textview6 = findViewById(R.id.textview6);
		checkbox1 = findViewById(R.id.checkbox1);
		textview7 = findViewById(R.id.textview7);
		checkbox2 = findViewById(R.id.checkbox2);
		textview8 = findViewById(R.id.textview8);
		checkbox3 = findViewById(R.id.checkbox3);
		textview9 = findViewById(R.id.textview9);
		checkbox4 = findViewById(R.id.checkbox4);
		linear9 = findViewById(R.id.linear9);
		linear21 = findViewById(R.id.linear21);
		linear15 = findViewById(R.id.linear15);
		linear12 = findViewById(R.id.linear12);
		linear11 = findViewById(R.id.linear11);
		linear16 = findViewById(R.id.linear16);
		linear10 = findViewById(R.id.linear10);
		linear13 = findViewById(R.id.linear13);
		textview12 = findViewById(R.id.textview12);
		textview15 = findViewById(R.id.textview15);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		linear14 = findViewById(R.id.linear14);
		linear22 = findViewById(R.id.linear22);
		textview13 = findViewById(R.id.textview13);
		textview17 = findViewById(R.id.textview17);
		textview14 = findViewById(R.id.textview14);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		round1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				checkbox1.setEnabled(true);
			}
		});
		
		round2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				checkbox2.setEnabled(true);
			}
		});
		
		round3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				checkbox3.setEnabled(true);
			}
		});
		
		round4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				checkbox4.setEnabled(true);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (answer.equals("")) {
					
				}
				else {
					if (vmap.get("ans").toString().equals("a")) {
						checkbox1.setTextColor(0xFF4CAF50);
						checkbox2.setTextColor(0xFFF44336);
						checkbox3.setTextColor(0xFFF44336);
						checkbox4.setTextColor(0xFFF44336);
					}
					if (vmap.get("ans").toString().equals("b")) {
						checkbox1.setTextColor(0xFFF44336);
						checkbox2.setTextColor(0xFF4CAF50);
						checkbox3.setTextColor(0xFFF44336);
						checkbox4.setTextColor(0xFFF44336);
					}
					if (vmap.get("ans").toString().equals("c")) {
						checkbox1.setTextColor(0xFFF44336);
						checkbox2.setTextColor(0xFFF44336);
						checkbox3.setTextColor(0xFF4CAF50);
						checkbox4.setTextColor(0xFFF44336);
					}
					if (vmap.get("ans").toString().equals("d")) {
						checkbox1.setTextColor(0xFFF44336);
						checkbox2.setTextColor(0xFFF44336);
						checkbox4.setTextColor(0xFFF44336);
						checkbox4.setTextColor(0xFF4CAF50);
					}
				}
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (answer.equals("")) {
									LayoutInflater Inflater = getLayoutInflater();
									View toastview=
									 Inflater.inflate(R.layout.toast3,null);
									
									LinearLayout linear=(LinearLayout)
									toastview.findViewById(R.id.linear1);
									
									
									Toast toast = new
									Toast(getApplicationContext());
									toast.setDuration(Toast.LENGTH_SHORT);
									toast.setView(toastview);
									toast.show();
								}
								else {
									if (vmap.get("ans").toString().equals(answer)) {
										score++;
										LayoutInflater Inflater = getLayoutInflater();
										View toastview=
										 Inflater.inflate(R.layout.toast1,null);
										
										LinearLayout linear=(LinearLayout)
										toastview.findViewById(R.id.linear1);
										
										
										Toast toast = new
										Toast(getApplicationContext());
										toast.setDuration(Toast.LENGTH_SHORT);
										toast.setView(toastview);
										toast.show();
									}
									else {
										LayoutInflater Inflater = getLayoutInflater();
										View toastview=
										 Inflater.inflate(R.layout.toast2,null);
										
										LinearLayout linear=(LinearLayout)
										toastview.findViewById(R.id.linear1);
										
										
										Toast toast = new
										Toast(getApplicationContext());
										toast.setDuration(Toast.LENGTH_SHORT);
										toast.setView(toastview);
										toast.show();
									}
									textview4.setText(String.valueOf((long)(score)).concat("/".concat(String.valueOf((long)(n)))));
									textview11.setText(String.valueOf((long)(score)).concat("/".concat(String.valueOf((long)(n)))));
									if (n == 10) {
										sp.edit().putString("score", textview4.getText().toString()).commit();
										sp.edit().putString("score", textview11.getText().toString()).commit();
										linear_play.setVisibility(View.GONE);
										linear8.setVisibility(View.VISIBLE);
									}
									else {
										answer = "";
										_falseCheckboxes();
									}
								}
								checkbox1.setTextColor(0xFF2196F3);
								checkbox2.setTextColor(0xFF2196F3);
								checkbox3.setTextColor(0xFF2196F3);
								checkbox4.setTextColor(0xFF2196F3);
							}
						});
					}
				};
				_timer.schedule(t, (int)(500));
				if (score < 5) {
					textview15.setText("Try Again!");
					textview15.setTextColor(0xFFBF360C);
				}
				else {
					textview15.setText("Completed");
					textview15.setTextColor(0xFF3F51B5);
				}
				_click_animation_2(button1);
			}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				_selected(checkbox1, "a");
				_click_animation_2(checkbox1);
			}
		});
		
		checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				_selected(checkbox2, "b");
				_click_animation_2(checkbox2);
			}
		});
		
		checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				_selected(checkbox3, "c");
				_click_animation_2(checkbox3);
			}
		});
		
		checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				_selected(checkbox4, "d");
				_click_animation_2(checkbox4);
			}
		});
	}
	
	private void initializeLogic() {
		n = 0;
		score = 0;
		lmap = new Gson().fromJson("[\n{\n\"ques\" : \"ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਨੇ ਕਿੰਨੀਆਂ ਵਾਰਾ ਲਿਖਿਆ?\nHow many vaars written Guru Arjun Dev Ji?\",\n\"a\" : \"੩\n3\",\n\"b\" : \"੪\n4\",\n\"c\" : \"੫\n5\",\n\"d\" : \"੬\n6\",\n\"ans\" : \"d\"\n},\n\n{\n\"ques\" : \"ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਦੀ ਬਾਣੀ ਕਿੰਨੇ ਰਾਗਾ ਵਿਚ ਦਰਜ ਹੈ?\nHow many Ragas used by Guru Arjun Dev Ji?\",\n\"a\" : \"੩੦\n30\",\n\"b\" : \"੨੭\n27\",\n\"c\" : \"੨੯\n29\",\n\"d\" : \"੨੮\n28\",\n\"ans\" : \"a\"\n},\n\n{\n\"ques\" : \"ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਨੂੰ ਗੁਰੁਤਾਗੱਦੀ ਕਦੂ ਮਿਲੀ?\nWhen did Guru Arjun Dev Ji get Gurugaddi?\",\n\"a\" : \"੧੫੮੧\n1581\",\n\"b\" : \"੧੫੮੨\n1582\",\n\"c\" : \"੧੫੮੩\n1583\",\n\"d\" : \"੧੫੮੦\n1580\",\n\"ans\" : \"a\"\n},\n\n{\n\"ques\" : \"ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਦੇ ਪੁੱਤਰ ਦਾ ਕਿ ਨਾਮ ਸੀ ?\nWho was the Sahibjada of Guru Arjun Dev Ji?\",\n\"a\" : \"ਗੁਰੂ ਅਮਰ ਦਾਸ ਜੀ \nGuru Amardas ji\",\n\"b\" : \"ਗੁਰੂ ਹਰਗੋਬਿੰਦ ਸਾਹਿਬ ਜੀ \nGuru Hargobind sahib ji\",\n\"c\" : \"ਗੁਰੂ ਤੇਗ ਬਹਾਦਰ ਸਾਹਿਬ ਜੀ\nGuru Tegh bahadur sahib ji\",\n\"d\" : \"ਗੁਰੂ ਰਾਮ ਦਾਸ ਜੀ\nGuru Ramdas ji\",\n\"ans\" : \"b\"\n},\n\n{\n\"ques\" : \"ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਨੂੰ ਗੁਰਗੱਦੀ ਕਿੱਥੇ ਮਿਲੀ ?\nAt which place Guru Arjun Dev Ji got Gurugaddi?\",\n\"a\" : \"ਗੋਇੰਦਵਾਲ਼\nGoendval\",\n\"b\" : \"ਸੋਧਰਾ\nSodhra\",\n\"c\" : \"ਅੰਮ੍ਰਿਤਸਰ\nAmritsar\",\n\"d\" : \"ਤਰਨ ਤਾਰਨ\nTaran Taaran\",\n\"ans\" : \"a\"\n},\n\n{\n\"ques\" : \"ਸ੍ਰੀ ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਨੇ ਕਿਹੜਾ ਨਗਰ ਵਸਾਇਆ ਸੀ?\nWhich city was settled by Sri Guru Arjan Dev ji?\",\n\"a\" : \"ਸ੍ਰੀ ਅੰਮ੍ਰਿਤਸਰ ਸਾਹਿਬ\nShri Amritsar sahib\",\n\"b\" : \"ਦਿੱਲੀ\n Delhi\",\n\"c\" : \"ਰੋਪੜ\n Ropar\",\n\"d\" : \"ਸ੍ਰੀ ਤਰਨਤਾਰਨ ਸਾਹਿਬ\n Taran taaran sahib\",\n\"ans\" : \"d\"\n},\n\n{\n\"ques\" : \"ਸ੍ਰੀ ਗੁਰੂ ਗ੍ਰੰਥ ਸਾਹਿਬ ਜੀ ਵਿੱਚ ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਦੇ ਕਿੰਨੇ ਸ਼ਬਦ ਦਰਜ ਹਨ?\nHow many words of Guru Arjan Dev Ji are recorded in Sri Guru Granth Sahib Ji?\",\n\"a\" : \"੨੩੧੨\n2312\",\n\"b\" : \"੧੯੧੨\n1912\",\n\"c\" : \"੧੫੧੨\n1512\",\n\"d\" : \"੧੬੧੨\n1612\",\n\"ans\" : \"a\"\n},\n\n{\n\"ques\" : \"ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਨੇ ਸੁਖਮਨੀ ਸਾਹਿਬ ਜੀ ਨੂੰ ਕਿਸ ਰਾਗ ਵਿੱਚ\n  ਉਚਾਰਣ ਕੀਤਾ ਸੀ?\nIn which raga did Guru Arjan Dev ji sing Sukhmani Sahib ji?\",\n\"a\" : \"ਰਾਗ ਸਾਰੰਗ\n Raag sarang\",\n\"b\" : \"ਰਾਗ ਬਿਹਾਗੜਾ\n Raag bihagra\",\n\"c\" : \"ਰਾਗ ਗਉੜੀ\nRaag gaudi\",\n\"d\" : \"ਰਾਗ ਆਸਾ \nRaag asa\",\n\"ans\" : \"c\"\n},\n\n{\n\"ques\" : \"ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਦਾ ਆਖਰੀ ਸੰਦੇਸ਼ ਕੀ ਸੀ?\n  What was the last message of Guru Arjan Dev Ji?\",\n\"a\" : \"ਨਾਮ ਜਪੋ\n Naam japo\",\n\"b\" : \"ਵੰਡ ਛਕੋ\n Vand shako\",\n\"c\" : \"ਕੀਰਤ ਕਰੋ\n Kirat Karo\",\n\"d\" : \"ਕੋਈ ਵੀ ਧਰਮ ਜਾਂ ਫਿਰਕਾ ਸ਼ਕਤੀ ਤੋਂ ਬਿਨਾਂ ਨਹੀਂ ਰਹਿ ਸਕਦੇ\nNo religion or community can live without power\",\n\"ans\" : \"d\"\n},\n\n{\n\"ques\" : \"ਜਦੋਂ ਗੁਰੂ ਅਰਜਨ ਦੇਵ ਜੀ ਨੇ ਬਾਣੀ ਦੀ ਸੰਪਾਦਨਾ ਕੀਤੀ ਤਾਂ ਕਿੰਨੇ ਅੰਗ ਸਨ?\nHow many parts were there when Guru Arjan Dev ji edited Bani?\",\n\"a\" : \"੧੦੭੪ਅੰਗ\n1074 ang\",\n\"b\" : \"੯੭੪ਅੰਗ\n974 ang\",\n\"c\" : \"੫੧੩ ਅੰਗ\n 513 ang\",\n\"d\" : \"੧੪੩੦ ਅੰਗ\n 1430 ang\",\n\"ans\" : \"b\"\n}\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		_pickQuestion();
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)1, 0xFF2196F3, 0xFFFFFFFF));
		round1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)1, 0xFF2196F3, 0xFFFFFFFF));
		round2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)1, 0xFF2196F3, 0xFFFFFFFF));
		round3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)1, 0xFF2196F3, 0xFFFFFFFF));
		round4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)1, 0xFF2196F3, 0xFFFFFFFF));
		linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)0, 0xFFFFFFFF, 0xFF795548));
		linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)0, 0xFFFFFFFF, 0xFFB71C1C));
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFFEEEEEE,0xFFB2EBF2};
			SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
			SketchUi.setCornerRadius(d*20);
			SketchUi.setStroke(d*1,0xFF008DCD);
			round1.setElevation(d*12);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			round1.setBackground(SketchUiRD);
			round1.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFFEEEEEE,0xFFB2EBF2};
			SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
			SketchUi.setCornerRadius(d*20);
			SketchUi.setStroke(d*1,0xFF008DCD);
			round2.setElevation(d*12);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			round2.setBackground(SketchUiRD);
			round2.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFFEEEEEE,0xFFB2EBF2};
			SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
			SketchUi.setCornerRadius(d*20);
			SketchUi.setStroke(d*1,0xFF008DCD);
			round3.setElevation(d*12);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			round3.setBackground(SketchUiRD);
			round3.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFFEEEEEE,0xFFB2EBF2};
			SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
			SketchUi.setCornerRadius(d*20);
			SketchUi.setStroke(d*1,0xFF008DCD);
			round4.setElevation(d*12);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			round4.setBackground(SketchUiRD);
			round4.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFFEEEEEE,0xFFB2EBF2};
			SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
			SketchUi.setCornerRadius(d*20);
			SketchUi.setStroke(d*1,0xFF008DCD);
			linear6.setElevation(d*12);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			linear6.setBackground(SketchUiRD);
			linear6.setClickable(true);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFFEEEEEE,0xFF795548};
			SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
			SketchUi.setCornerRadius(d*20);
			SketchUi.setStroke(d*1,0xFF795548);
			button1.setElevation(d*12);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF795548}), SketchUi, null);
			button1.setBackground(SketchUiRD);
			button1.setClickable(true);
		}
		_Elevation(button1, 14);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_Music();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		MP.pause();
	}
	public void _selected(final CheckBox _checkbox, final String _answer) {
		if (_checkbox.isChecked()) {
			answer = _answer;
			_falseCheckboxes();
			_checkbox.setChecked(true);
		}
		else {
			answer = "";
		}
	}
	
	
	public void _falseCheckboxes() {
		checkbox1.setChecked(false);
		checkbox2.setChecked(false);
		checkbox3.setChecked(false);
		checkbox4.setChecked(false);
	}
	
	
	public void _bounce(final View _view) {
		object.setTarget(_view);
		object.setPropertyName("rotation");
		object.setFloatValues((float)(90), (float)(0));
		object.setDuration((int)(1000));
		object.setInterpolator(new BounceInterpolator());
		object.start();
	}
	
	
	public void _setBgCorners(final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
		gd.setColor(Color.parseColor("#" + _color.replace("#", ""))); /* color */
		gd.setCornerRadius((int)_radius); /* radius */
		gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
		_view.setBackground(gd);
	}
	
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public void _click_animation_2(final View _view) {
		_view.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()){
					case MotionEvent.ACTION_DOWN:{
						ObjectAnimator scaleX = new ObjectAnimator();
						scaleX.setTarget(_view);
						scaleX.setPropertyName("scaleX");
						scaleX.setFloatValues(1.1f);
						scaleX.setDuration(100);
						scaleX.start();
						
						ObjectAnimator scaleY = new ObjectAnimator();
						scaleY.setTarget(_view);
						scaleY.setPropertyName("scaleY");
						scaleY.setFloatValues(1.1f);
						scaleY.setDuration(100);
						scaleY.start();
						break;
					}
					case MotionEvent.ACTION_UP:{
						
						ObjectAnimator scaleX = new ObjectAnimator();
						scaleX.setTarget(_view);
						scaleX.setPropertyName("scaleX");
						scaleX.setFloatValues((float)1);
						scaleX.setDuration(100);
						scaleX.start();
						
						ObjectAnimator scaleY = new ObjectAnimator();
						scaleY.setTarget(_view);
						scaleY.setPropertyName("scaleY");
						scaleY.setFloatValues((float)1);
						scaleY.setDuration(100);
						scaleY.start();
						
						break;
					}
				}
				return false;
			}
		});
	}
	
	
	public void _pickQuestion() {
		n++;
		q = SketchwareUtil.getRandom((int)(0), (int)(lmap.size() - 1));
		vmap = lmap.get((int)q);
		lmap.remove((int)(q));
		textview1.setText(String.valueOf((long)(n)));
		textview2.setText(vmap.get("ques").toString());
		checkbox1.setText(vmap.get("a").toString());
		checkbox2.setText(vmap.get("b").toString());
		checkbox3.setText(vmap.get("c").toString());
		checkbox4.setText(vmap.get("d").toString());
	}
	
	
	public void _Music() {
		MP = MediaPlayer.create(getApplicationContext(), R.raw.dilruba);
		MP.setLooping(true);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						MP.start();
					}
				});
			}
		};
		_timer.schedule(t, (int)(1000));
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}