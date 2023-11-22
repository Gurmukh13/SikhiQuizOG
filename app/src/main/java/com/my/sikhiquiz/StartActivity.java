package com.my.sikhiquiz;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class StartActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private double sp1 = 0;
	private double number = 0;
	private double n = 0;
	
	private LinearLayout linear2;
	private LinearLayout linear15;
	private TextView textview5;
	private LinearLayout linear21;
	private ImageView imageview1;
	private LinearLayout linear19;
	private LinearLayout linear22;
	private ScrollView vscroll1;
	private ImageView imageview6;
	private Button button2;
	private ImageView imageview2;
	private LinearLayout linear20;
	private TextView textview10;
	private TextView textview8;
	private LinearLayout linear14;
	private TextView textview9;
	private EditText edittext1;
	private TextView textview11;
	private Button button1;
	private LinearLayout linear9;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private LinearLayout linear10;
	private LinearLayout linear7;
	private LinearLayout linear5;
	private LinearLayout linear12;
	private TextView textview1;
	private TextView textview2;
	private TextView textview4;
	private TextView textview7;
	private TextView textview6;
	private TextView textview3;
	
	private Intent i = new Intent();
	private SoundPool soundp;
	private AlertDialog.Builder dialog;
	private TimerTask timer;
	private SharedPreferences save;
	private ObjectAnimator oa = new ObjectAnimator();
	private MediaPlayer media;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		linear15 = findViewById(R.id.linear15);
		textview5 = findViewById(R.id.textview5);
		linear21 = findViewById(R.id.linear21);
		imageview1 = findViewById(R.id.imageview1);
		linear19 = findViewById(R.id.linear19);
		linear22 = findViewById(R.id.linear22);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview6 = findViewById(R.id.imageview6);
		button2 = findViewById(R.id.button2);
		imageview2 = findViewById(R.id.imageview2);
		linear20 = findViewById(R.id.linear20);
		textview10 = findViewById(R.id.textview10);
		textview8 = findViewById(R.id.textview8);
		linear14 = findViewById(R.id.linear14);
		textview9 = findViewById(R.id.textview9);
		edittext1 = findViewById(R.id.edittext1);
		textview11 = findViewById(R.id.textview11);
		button1 = findViewById(R.id.button1);
		linear9 = findViewById(R.id.linear9);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear6 = findViewById(R.id.linear6);
		linear10 = findViewById(R.id.linear10);
		linear7 = findViewById(R.id.linear7);
		linear5 = findViewById(R.id.linear5);
		linear12 = findViewById(R.id.linear12);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview4 = findViewById(R.id.textview4);
		textview7 = findViewById(R.id.textview7);
		textview6 = findViewById(R.id.textview6);
		textview3 = findViewById(R.id.textview3);
		dialog = new AlertDialog.Builder(this);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear14.setVisibility(View.VISIBLE);
				
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_RequiredActionDialog(dialog, true);
				dialog.setTitle("About");
				dialog.setIcon(R.drawable.logos);
				dialog.setMessage("Sikhi Quiz Game\nDevloped by Gurmukh Singh.\n\nVersion 1.1.0");
				dialog.setPositiveButton("cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						_RequiredActionDialog(dialog, true);
					}
				});
				dialog.create().show();
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear14.setVisibility(View.GONE);
			}
		});
		
		button1.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview9.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "saved name");
					textview9.setVisibility(View.GONE);
				}
				else {
					save.edit().putString("name", edittext1.getText().toString()).commit();
					textview9.setText(save.getString("name", ""));
					linear14.setVisibility(View.GONE);
					textview9.setVisibility(View.VISIBLE);
					SketchwareUtil.showMessage(getApplicationContext(), "Name saved");
				}
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MapActivity.class);
				startActivity(i);
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_help();
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
	}
	
	private void initializeLogic() {
		linear14.setVisibility(View.GONE);
		if (!save.getString("name", "").equals("")) {
			textview9.setText(save.getString("name", ""));
			textview9.setVisibility(View.VISIBLE);
		}
		else {
			textview9.setVisibility(View.GONE);
		}
		_gd(linear14, "#FFE082", "#FFCA28", 50);
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						oa.setTarget(linear20);
						oa.setPropertyName("alpha");
						oa.setFloatValues((float)(0), (float)(1));
						oa.setInterpolator(new AccelerateInterpolator());
						oa.setDuration((int)(500));
						oa.setTarget(linear20);
						oa.setPropertyName("translationX");
						oa.setFloatValues((float)(200), (float)(0));
						oa.setInterpolator(new LinearInterpolator());
						oa.setDuration((int)(20000));
						oa.start();
						oa.start();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(1000), (int)(20000));
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						n = n;
						n++;
						if (n == 1) {
							imageview6.setImageResource(R.drawable.character1);
						}
						if (n == 2) {
							imageview6.setImageResource(R.drawable.character2);
						}
						if (n == 3) {
							n = 0;
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(5000));
	}
	
	@Override
	public void onBackPressed() {
		media.setLooping(false);
		media.pause();
		finishAffinity();
	}
	public void _RequiredActionDialog(final AlertDialog.Builder _Dialog, final boolean _True) {
		_Dialog.setCancelable(_True);
	}
	
	
	public void _help() {
		final AlertDialog dialog2 = new AlertDialog.Builder(StartActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.help, null);
		dialog2.setView(inflate);
		dialog2.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		dialog2.setCanceledOnTouchOutside(false);
		dialog2.setCancelable(false);
		final Button but1 = (Button) inflate.findViewById(R.id.button1);
		final TextView txt1 = (TextView) inflate.findViewById(R.id.textview1);
		final LinearLayout lin1 = (LinearLayout) inflate.findViewById(R.id.linear2);
			_gd(lin1, "#CFD8DC", "#607D8B", 30);
		_gd(but1, "#CFD8DC", "#607D8B", 50);
		but1.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				dialog2.dismiss(); } });
		dialog2.show();
	}
	
	
	public void _gd(final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(5, Color.parseColor(_sc));
		
		_view.setBackground(gd);
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