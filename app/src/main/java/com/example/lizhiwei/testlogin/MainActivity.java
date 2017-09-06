package com.example.lizhiwei.testlogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String tag = "myTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void useButton(View v){
        final EditText userName = (EditText)findViewById(R.id.userName);
        final EditText password = (EditText)findViewById(R.id.password);
        switch(v.getId()){
            case R.id.buttonLogin:
                if(userName.getText().toString().equals("abc")){
                    if(password.getText().toString().equals("123")){
                        Log.d(tag,"执行到了这123");
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(this,"账号或密码错误",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(this,"账号或密码错误",Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonCancel:
                Log.d(tag,"执行到了取消功能");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示").setMessage("是否清空账号和密码");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userName.setText("");
                        password.setText("");
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int i){
                        Toast.makeText(MainActivity.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
                break;
        }

    }
}
