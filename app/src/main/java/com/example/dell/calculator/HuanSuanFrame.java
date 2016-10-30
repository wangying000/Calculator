package com.example.dell.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HuanSuanFrame.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HuanSuanFrame#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HuanSuanFrame extends Fragment {
    double Num=0;
    String Str;
    String tuige;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HuanSuanFrame() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HuanSuanFrame.
     */
    // TODO: Rename and change types and number of parameters
    public static HuanSuanFrame newInstance(String param1, String param2) {
        HuanSuanFrame fragment = new HuanSuanFrame();
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
        View view= inflater.inflate(R.layout.fragment_huan_suan_frame, container, false);


        final EditText editText1=(EditText)view.findViewById(R.id.editText);
        final EditText editText2=(EditText)view.findViewById(R.id.editText2);
        final TextView textView1=(TextView)view.findViewById(R.id.textView8);
        final TextView textView2=(TextView)view.findViewById(R.id.textView9);

        Button buttonzh=(Button)view.findViewById(R.id.buttonzh);

        Button buttontg=(Button)view.findViewById(R.id.buttontg);
        buttontg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tuige=editText1.getText().toString();
                    if(tuige.length()==0){}
                    else
                    {tuige=tuige.substring(0,tuige.length()-1);editText1.setText(tuige+"");}


            }
        });

        Button buttonnum0=(Button)view.findViewById(R.id.button10);
        buttonnum0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"0");
            }
        });
        Button buttonnum1=(Button)view.findViewById(R.id.button11);
        buttonnum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"1");
            }
        });
        Button buttonnum2=(Button)view.findViewById(R.id.button12);
        buttonnum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"2");
            }
        });
        Button buttonnum3=(Button)view.findViewById(R.id.button13);
        buttonnum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"3");
            }
        });
        Button buttonnum4=(Button)view.findViewById(R.id.button14);
        buttonnum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"4");
            }
        });
        Button buttonnum5=(Button)view.findViewById(R.id.button15);
        buttonnum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"5");
            }
        });
        Button buttonnum6=(Button)view.findViewById(R.id.button16);
        buttonnum6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"6");
            }
        });
        Button buttonnum7=(Button)view.findViewById(R.id.button17);
        buttonnum7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"7");
            }
        });
        Button buttonnum8=(Button)view.findViewById(R.id.button18);
        buttonnum8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"8");
            }
        });
        Button buttonnum9=(Button)view.findViewById(R.id.button19);
        buttonnum9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+"9");
            }
        });
        Button buttondian2=(Button)view.findViewById(R.id.buttondian2);
        buttondian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText1.getText()+".");
            }
        });

        buttonzh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Str=editText1.getText().toString();
                Num=Double.valueOf(Str).doubleValue();
                if(textView1.getText().toString().equals("毫克")){Num=Num*1;}
                if(textView2.getText().toString().equals("毫克")){Num=Num/1;}
                if(textView1.getText().toString().equals("克")){Num=Num*1000;}
                if(textView2.getText().toString().equals("克")){Num=Num/1000;}
                if(textView1.getText().toString().equals("千克")){Num=Num*1000000;}
                if(textView2.getText().toString().equals("千克")){Num=Num/1000000;}
                if(textView1.getText().toString().equals("吨")){Num=Num*1000000000;}
                if(textView2.getText().toString().equals("吨")){Num=Num/1000000000;}
                editText2.setText(""+Num);
            }
        });
        return view;
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
