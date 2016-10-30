package com.example.dell.calculator;

import android.app.Fragment;
import android.content.ClipData;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.calculator.HuanSuanFrame;
import com.example.dell.calculator.JiSuanFrame;
import com.example.dell.calculator.R;

public class MainActivity extends AppCompatActivity implements
        HuanSuanFrame.OnFragmentInteractionListener,
        JiSuanFrame.OnFragmentInteractionListener,
        PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton HuanSuan=(RadioButton)findViewById(R.id.HuanSuan);
        RadioButton JiSuan=(RadioButton)findViewById(R.id.JiSuan);


        final RelativeLayout HuanSuanFrame=(RelativeLayout)findViewById(R.id.HuanSuanFrame);
        final RelativeLayout JiSuanFrame=(RelativeLayout)findViewById(R.id.JiSuanFrame);


        HuanSuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HuanSuanFrame.setVisibility(View.VISIBLE);
                JiSuanFrame.setVisibility(View.INVISIBLE);
            }
        });
        JiSuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HuanSuanFrame.setVisibility(View.INVISIBLE);
                JiSuanFrame.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void showPopup1(View v){
        PopupMenu popup=new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu1);
        popup.show();
    }
    public void showPopup2(View v){
        PopupMenu popup=new PopupMenu(this,v);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.menu2);
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem menuItem){

        TextView textView1=(TextView)findViewById(R.id.textView8);
        TextView textView2=(TextView)findViewById(R.id.textView9);


        switch (menuItem.getItemId()){
            case R.id.menu_1:
                textView1.setText("毫克");
                Toast.makeText(this,"弹出菜单1已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_2:
                textView1.setText("克");
                Toast.makeText(this,"弹出菜单2已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_3:
                textView1.setText("千克");
                Toast.makeText(this,"弹出菜单3已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_4:
                textView1.setText("吨");
                Toast.makeText(this,"弹出菜单4已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_5:
                textView2.setText("毫克");
                Toast.makeText(this,"弹出菜单4已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_6:
                textView2.setText("克");
                Toast.makeText(this,"弹出菜单4已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_7:
                textView2.setText("千克");
                Toast.makeText(this,"弹出菜单4已被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_8:
                textView2.setText("吨");
                Toast.makeText(this,"弹出菜单4已被点击",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;

    }
}
