package com.example.dell.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JiSuanFrame.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JiSuanFrame#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JiSuanFrame extends Fragment {
    int i=0;//循环标记
    int Sign1=0;  //标记是否输入了等号
    int Sign2=0;  //标记是否正在输入数字，开始输入时为1，输入完为0
    int Sign3=0; //标记是整数部分还是小数部分，0为整数部分，1为小数部分
    double Result=0;
    int a =0 ;
    int b = 0;
    int c=0;//括号标记
    final int d=20;
    int x=0;
    int z=0;//表示小数点后几位
    final double[] Number=new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    final int[] Sign=new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    final char[] NumberChar=new char[20];
    String tuige;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public JiSuanFrame() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JiSuanFrame.
     */
    // TODO: Rename and change types and number of parameters
    public static JiSuanFrame newInstance(String param1, String param2) {
        JiSuanFrame fragment = new JiSuanFrame();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View JiSuan_Frame=inflater.inflate(R.layout.fragment_ji_suan_frame, container, false);





        final TextView JiSuan_EditText=(TextView)JiSuan_Frame.findViewById(R.id.JiSuan_EditText);



        //三角函数绑定按钮及添加监听器
        Button buttonsin=(Button)JiSuan_Frame.findViewById(R.id.buttonsin);
        buttonsin.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"sin");}});
        Button buttoncos=(Button)JiSuan_Frame.findViewById(R.id.buttoncos);
        buttoncos.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"cos");}});
        Button buttontan=(Button)JiSuan_Frame.findViewById(R.id.buttontan);
        buttontan.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"tan");}});


        //幂函数绑定按钮及添加监听器
        Button buttonm=(Button)JiSuan_Frame.findViewById(R.id.buttonm);
        buttonm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Sign1==1){Sign1=0;JiSuan_EditText.setText(""+Result);x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"^");
            }
        });

//数字绑定按钮及监听
        final Button Number0= (Button) JiSuan_Frame.findViewById(R.id.button0);
        Number0.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"0");}});
        Button Number1= (Button) JiSuan_Frame.findViewById(R.id.button1);
        Number1.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"1");}});
        Button Number2= (Button) JiSuan_Frame.findViewById(R.id.button2);
        Number2.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"2");}});
        Button Number3= (Button) JiSuan_Frame.findViewById(R.id.button3);
        Number3.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"3");}});
        Button Number4= (Button) JiSuan_Frame.findViewById(R.id.button4);
        Number4.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"4");}});
        Button Number5= (Button) JiSuan_Frame.findViewById(R.id.button5);
        Number5.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"5");}});
        Button Number6= (Button) JiSuan_Frame.findViewById(R.id.button6);
        Number6.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"6");}});
        Button Number7= (Button) JiSuan_Frame.findViewById(R.id.button7);
        Number7.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"7");}});
        Button Number8= (Button) JiSuan_Frame.findViewById(R.id.button8);
        Number8.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"8");}});
        Button Number9= (Button) JiSuan_Frame.findViewById(R.id.button9);
        Number9.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"9");}});

        //小数点绑定按钮及监听
        Button Numberdian= (Button) JiSuan_Frame.findViewById(R.id.buttondian);
        Numberdian.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {JiSuan_EditText.setText(JiSuan_EditText.getText()+".");}});

        Button buttontg=(Button)JiSuan_Frame.findViewById(R.id.buttontg);
        buttontg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuige=JiSuan_EditText.getText().toString();
                if(tuige.length()==0){}
                else
                {if(Sign1==1){Sign1=0;x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}tuige=tuige.substring(0,tuige.length()-1);JiSuan_EditText.setText(tuige+"");}
            }
        });

        Button Signjia=(Button)JiSuan_Frame.findViewById(R.id.buttonjia);
        Signjia.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText(""+Result);x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"+");}});
        Button Signjian=(Button)JiSuan_Frame.findViewById(R.id.buttonjian);
        Signjian.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText(""+Result);x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"-");}});
        Button Signcheng=(Button)JiSuan_Frame.findViewById(R.id.buttoncheng);
        Signcheng.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText(""+Result);x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"*");}});
        Button Signchu=(Button)JiSuan_Frame.findViewById(R.id.buttonchu);
        Signchu.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText(""+Result);x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"/");}});
        Button Signzuo=(Button)JiSuan_Frame.findViewById(R.id.buttonzuo);
        Signzuo.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+"(");}});
        Button Signyou=(Button)JiSuan_Frame.findViewById(R.id.buttonyou);
        Signyou.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {if(Sign1==1){Sign1=0;JiSuan_EditText.setText("");x=0;for(i=0;i<20;i++){Number[i]=0;Sign[i]=0;}}JiSuan_EditText.setText(JiSuan_EditText.getText()+")");}});
        Button Signdeng=(Button)JiSuan_Frame.findViewById(R.id.buttondeng);



        Signdeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sign3=0;z=0;

                String Number_String=JiSuan_EditText.getText().toString();
                Number_String.getChars(0,Number_String.length(),NumberChar,0);
                for(i=0;i<JiSuan_EditText.length();i++){

                    if(NumberChar[i]=='0'){if(Sign3==0)Number[x]=Number[x]*10+0;if(Sign3==1){z=z+1;Number[x]=Number[x]+0*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='1'){if(Sign3==0)Number[x]=Number[x]*10+1;if(Sign3==1){z=z+1;Number[x]=Number[x]+1*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='2'){if(Sign3==0)Number[x]=Number[x]*10+2;if(Sign3==1){z=z+1;Number[x]=Number[x]+2*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='3'){if(Sign3==0)Number[x]=Number[x]*10+3;if(Sign3==1){z=z+1;Number[x]=Number[x]+3*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='4'){if(Sign3==0)Number[x]=Number[x]*10+4;if(Sign3==1){z=z+1;Number[x]=Number[x]+4*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='5'){if(Sign3==0)Number[x]=Number[x]*10+5;if(Sign3==1){z=z+1;Number[x]=Number[x]+5*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='6'){if(Sign3==0)Number[x]=Number[x]*10+6;if(Sign3==1){z=z+1;Number[x]=Number[x]+6*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='7'){if(Sign3==0)Number[x]=Number[x]*10+7;if(Sign3==1){z=z+1;Number[x]=Number[x]+7*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='8'){if(Sign3==0)Number[x]=Number[x]*10+8;if(Sign3==1){z=z+1;Number[x]=Number[x]+8*Math.pow(0.1,z);}}
                    if(NumberChar[i]=='9'){if(Sign3==0)Number[x]=Number[x]*10+9;if(Sign3==1){z=z+1;Number[x]=Number[x]+9*Math.pow(0.1,z);}}

                    if(NumberChar[i]=='.'){Sign3=1;}

                    //三角函数
                    if(NumberChar[i]=='s'){Number[x]=15;Sign3=0;z=0;Sign[x]=7;i=i+2;
                        if(NumberChar[i+3]!='('||NumberChar[i+3]!=')'||NumberChar[i+3]!='+'||NumberChar[i+3]!='-'||NumberChar[i+3]!='*'||NumberChar[i+3]!='/'){x++;}}
                    if(NumberChar[i]=='c'){Number[x]=16;Sign3=0;z=0;Sign[x]=7;i=i+2;
                        if(NumberChar[i+3]!='('||NumberChar[i+3]!=')'||NumberChar[i+3]!='+'||NumberChar[i+3]!='-'||NumberChar[i+3]!='*'||NumberChar[i+3]!='/'){x++;}}
                    if(NumberChar[i]=='t'){Number[x]=17;Sign3=0;z=0;Sign[x]=7;i=i+2;
                        if(NumberChar[i+3]!='('||NumberChar[i+3]!=')'||NumberChar[i+3]!='+'||NumberChar[i+3]!='-'||NumberChar[i+3]!='*'||NumberChar[i+3]!='/'){x++;}}


                    if(NumberChar[i]=='+'){
                        x++;Number[x]=11;Sign3=0;z=0;Sign[x]=1+c;
                        if(NumberChar[i+1]!='('||NumberChar[i+1]!=')'||NumberChar[i+1]!='+'||NumberChar[i+1]!='-'||NumberChar[i+1]!='*'||NumberChar[i+1]!='/'){x++;}}
                    if(NumberChar[i]=='-'){
                        x++;Number[x]=12;z=0;Sign3=0;Sign[x]=1+c;
                        if(NumberChar[i+1]!='('||NumberChar[i+1]!=')'||NumberChar[i+1]!='+'||NumberChar[i+1]!='-'||NumberChar[i+1]!='*'||NumberChar[i+1]!='/'){x++;}}
                    if(NumberChar[i]=='*'){
                        x++;Number[x]=13;z=0;Sign3=0;Sign[x]=2+c;
                        if(NumberChar[i+1]!='('||NumberChar[i+1]!=')'||NumberChar[i+1]!='+'||NumberChar[i+1]!='-'||NumberChar[i+1]!='*'||NumberChar[i+1]!='/'){x++;}}
                    if(NumberChar[i]=='/'){
                        x++;Number[x]=14;z=0;Sign3=0;Sign[x]=2+c;
                        if(NumberChar[i+1]!='('||NumberChar[i+1]!=')'||NumberChar[i+1]!='+'||NumberChar[i+1]!='-'||NumberChar[i+1]!='*'||NumberChar[i+1]!='/'){x++;}}
                    if(NumberChar[i]=='('){
                        z=0;Sign3=0;c=3;}
                    if(NumberChar[i]==')'){
                        z=0;Sign3=0;c=0;}

                    if(NumberChar[i]=='^'){
                        x++;Number[x]=18;Sign3=0;z=0;Sign[x]=3+c;
                        if(NumberChar[i+1]!='('||NumberChar[i+1]!=')'||NumberChar[i+1]!='+'||NumberChar[i+1]!='-'||NumberChar[i+1]!='*'||NumberChar[i+1]!='/'){x++;}}


                }



                for(a=0;a<d;a++){
                    if(Sign[a]==7){
                        if(Number[a]==15){Number[a]=Math.sin(Number[a+1]);Sign[a]=0;Number[a+1]=0;}
                        if(Number[a]==16){Number[a]=Math.cos(Number[a+1]);Sign[a]=0;Number[a+1]=0;}
                        if(Number[a]==17){Number[a]=Math.tan(Number[a+1]);Sign[a]=0;Number[a+1]=0;}
                    }
                }

                for(a=0;a<d;a++){
                    if(Sign[a]==6){
                        for(b=a-1;b<a;b--)
                        {if(Number[b]!=0)break;}
                        if(Number[a]==18) Number[b]=Math.pow(Number[b],Number[a+1]);
                        for(b=b+1;b<=a+1;b++)Number[b]=0;
                        Sign[a]=0;
                        Number[a]=0;
                    }
                }

                for(a=0;a<d;a++){
                    if(Sign[a]==5){
                        for(b=a-1;b<a;b--)
                        {if(Number[b]!=0)break;}
                        if(Number[a]==13) Number[b]=Number[b]*Number[a+1];
                        if(Number[a]==14)Number[b]=Number[b]/Number[a+1];
                        for(b=b+1;b<=a+1;b++)Number[b]=0;
                        Sign[a]=0;
                        Number[a]=0;
                    }
                }
                for(a=0;a<d;a++){
                    if(Sign[a]==4){
                        for(b=a-1;b<a;b--)
                        {if(Number[b]!=0)break;}
                        if(Number[a]==11) Number[b]=Number[b]+Number[a+1];
                        if(Number[a]==12)Number[b]=Number[b]-Number[a+1];
                        for(b=b+1;b<=a+1;b++)Number[b]=0;
                        Sign[a]=0;
                        Number[a]=0;
                    }
                }

                for(a=0;a<d;a++){
                    if(Sign[a]==3){
                        for(b=a-1;b<a;b--)
                        {if(Number[b]!=0)break;}
                        if(Number[a]==18) Number[b]=Math.pow(Number[b],Number[a+1]);
                        for(b=b+1;b<=a+1;b++)Number[b]=0;
                        Sign[a]=0;
                        Number[a]=0;
                    }
                }
                for(a=0;a<d;a++){
                    if(Sign[a]==2){
                        for(b=a-1;b<a;b--)
                        {if(Number[b]!=0)break;}
                        if(Number[a]==13) Number[b]=Number[b]*Number[a+1];
                        if(Number[a]==14)Number[b]=Number[b]/Number[a+1];
                        for(b=b+1;b<=a+1;b++)Number[b]=0;
                        Sign[a]=0;
                        Number[a]=0;
                    }
                }
                for(a=0;a<d;a++){
                    if(Sign[a]==1){
                        for(b=a-1;b<a;b--)
                        {if(Number[b]!=0)break;}
                        if(Number[a]==11) Number[b]=Number[b]+Number[a+1];
                        if(Number[a]==12)Number[b]=Number[b]-Number[a+1];
                        for(b=b+1;b<=a+1;b++)Number[b]=0;
                        Sign[a]=0;
                        Number[a]=0;
                    }
                }
                Result=Number[0];
                JiSuan_EditText.setText(JiSuan_EditText.getText()+"="+Result);
                Sign1=1;
            }

        });






        return JiSuan_Frame;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
