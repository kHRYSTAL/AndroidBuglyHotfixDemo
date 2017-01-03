package me.khrystal.hotfix;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.bugly.beta.Beta;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCurrentVersion;
    private Button btnShowToast;
    private Button btnLoadPatch;
    private Button btnKillSelf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCurrentVersion = (TextView) findViewById(R.id.tvCurrentVersion);
        btnShowToast = (Button) findViewById(R.id.btnShowToast);
        btnShowToast.setOnClickListener(this);
        btnKillSelf = (Button) findViewById(R.id.btnKillSelf);
        btnKillSelf.setOnClickListener(this);
        btnLoadPatch = (Button) findViewById(R.id.btnLoadPatch);
        btnLoadPatch.setOnClickListener(this);

        tvCurrentVersion.setText("当前版本:" + getCurrentVersion(this));
    }

    private String getCurrentVersion(Context context) {
        try {
            PackageInfo packageInfo =
                    context.getPackageManager().getPackageInfo(this.getPackageName(),
                            PackageManager.GET_CONFIGURATIONS);
            int versionCode = packageInfo.versionCode;
            String versionName = packageInfo.versionName;
            return versionName + "." + versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void testShowToast() {
        Toast.makeText(this, LoadBugClass.getBugString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowToast: // 测试热更新是否成功
                testShowToast();
                break;
            case R.id.btnKillSelf: // 杀死进程
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
            case R.id.btnLoadPatch: // 本地加载补丁测试
                Beta.applyTinkerPatch(getApplicationContext(),
                        Environment.getExternalStorageDirectory().getAbsolutePath()+ "/patch_signed_7zip.apk");
                break;
        }
    }
}
