package com.example.headportrait.view;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.headportrait.R;
import com.example.headportrait.base.BaseActivity;
import com.example.headportrait.MyBean;
import com.example.headportrait.base.UserBean;
import com.example.headportrait.presenter.HeadPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.io.FileOutputStream;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends BaseActivity<HeadPresenter> implements IView {

    @BindView(R.id.imv)
    SimpleDraweeView imv;
    private String pic_path = Environment.getExternalStorageDirectory() + "/head1.jpg";
    //裁剪完成之后图片保存的路径
    private String crop_icon_path = Environment.getExternalStorageDirectory() + "/head_icon.jpg";
    private String icon;
    private Uri parse;
    @Override
    protected HeadPresenter getPresenter() {
        return new HeadPresenter();
    }

    @Override
    protected void initView() {
        presenter.getusers();

        imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder normalDialog =
                        new AlertDialog.Builder(MainActivity.this);

                normalDialog.setMessage("请选择");
                normalDialog.setPositiveButton("相机",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                paiZhao();
                            }
                        });
                normalDialog.setNegativeButton("相册",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                XiangCe();
                            }
                        });
                // 显示
                normalDialog.show();

            }
        });
    }

    private void paiZhao() {
        Intent intent = new Intent();
        //指定动作...拍照的动作 CAPTURE...捕获
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        //给相机传递一个指令,,,告诉他拍照之后保存..MediaStore.EXTRA_OUTPUT向外输出的指令,,,指定存放的位置
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(pic_path)));

        //拍照的目的是拿到拍的图片
        startActivityForResult(intent, 1000);

    }

    private void XiangCe() {
        Intent intent = new Intent();
        //指定选择/获取的动作...PICK获取,拿
        intent.setAction(Intent.ACTION_PICK);
        //指定获取的数据的类型
        intent.setType("image/*");

        startActivityForResult(intent, 3000);
    }

    private void crop(Uri uri) {
        Intent intent = new Intent();
        //指定裁剪的动作
        intent.setAction("com.android.camera.action.CROP");

        //设置裁剪的数据(uri路径)....裁剪的类型(image/*)
        intent.setDataAndType(uri, "image/*");

        //执行裁剪的指令
        intent.putExtra("crop", "true");
        //指定裁剪框的宽高比
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        //指定输出的时候宽度和高度
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);

        //设置取消人脸识别
        intent.putExtra("noFaceDetection", false);
        //设置返回数据
        intent.putExtra("return-data", true);

        //
        startActivityForResult(intent, 2000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {

            //拍照保存之后进行裁剪....根据图片的uri路径
            crop(Uri.fromFile(new File(pic_path)));
        }


        //获取相册图片
        if (requestCode == 3000 && resultCode == RESULT_OK) {
            //获取的是相册里面某一张图片的uri地址
            Uri uri = data.getData();
            Log.d("data------", data + "");
            //根据这个uri地址进行裁剪
            crop(uri);
        }
        if (requestCode == 2000 && resultCode == RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            File saveIconFile = new File(crop_icon_path);
            if (saveIconFile.exists()) {
                saveIconFile.delete();
            }
            try {
                saveIconFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(saveIconFile);
                //把bitmap通过流的形式压缩到文件中
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.flush();
                fos.close();
                //通过file对象创建一个请求体
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), saveIconFile);
                //通过请求体对象 构建MultipartBody.Part对象
                //"file" 接口里面参数的名
                MultipartBody.Part part = MultipartBody.Part.createFormData("file", saveIconFile.getName(), requestFile);
                //保存到sd卡中之后再去把文件上传到服务器


                presenter.getaa(part);
                Log.e("file=====", part.body() + "");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }



    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void show(MyBean bb) {
        String code = bb.getCode();
        int i = Integer.parseInt(code);
        if (i == 0) {
            imv.setImageURI(parse);
        }else {

        }
    }

    @Override
    public void usera(final UserBean bean) {
        String[] split = bean.getData().getIcon().split("\\|");
        Log.e("12=========",bean.getData().getIcon());
        parse = Uri.parse(split[0]);


     /*   Glide.with(this).load(bean.getData().getIcon()).asBitmap().centerCrop().into(new BitmapImageViewTarget(imv) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(MainActivity.this.getResources(), resource);
                circularBitmapDrawable.setCircular(true);

                imv.setImageDrawable(circularBitmapDrawable);
            }
        });*/
    }
}
