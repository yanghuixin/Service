package com.yhx.dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View view) {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置图标
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //设置标题
        builder.setTitle("警告");
        //设置内容
        builder.setMessage("欲练此功，必先自宫");
        //设置确定按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"自宫完成，谢谢使用",Toast.LENGTH_LONG).show();
            }
        });
        //设置取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"若不自宫，一定不成功",Toast.LENGTH_LONG).show();
            }
        });
        //显示对话框
        AlertDialog ad = builder.create();
        ad.show();
    }

    public void click2(View view) {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置图标
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //设置标题
        builder.setTitle("选择您的家乡");
        final String[] items = new String[]{
              "火星","赛博坦","氪星","M78星云"
        };
        //设置单选选项
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            //dialog:触发此方法执行的那个对话框
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,items[which],Toast.LENGTH_LONG).show();
                //设置对话框消失
                dialog.dismiss();
            }
        });
        //显示对话框
        builder.show();
    }

    public void click3(View view) {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置图标
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //设置标题
        builder.setTitle("选择您需要的武器");
        final String[] items = new String[]{
                "板凳","啤酒瓶","开山刀","AK-47","爱国者","唐小平"
        };

        final boolean[] checkedItems = new boolean[]{
                true,false,false,false,false,true
        };
        //设置多选选项
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //记录用户的选择
                checkedItems[which] = isChecked;
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = "";
                for (int i =0 ; i<checkedItems.length;i++){
                    text += checkedItems[i] ? items[i] + "," : "";
                }
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

    public void click4(View view) {
        //创建进度条对话框
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setIcon(android.R.drawable.ic_input_add);
        dialog.setTitle("正在自宫，请稍后。。。");
        dialog.setMax(100);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i =0 ; i <= 100 ; i++){
                    dialog.setProgress(i);
                    try {
                        sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
            }
        };
        t.start();
        dialog.show();
    }
}
