package me.khrystal.hotfix;

import android.app.Application;
import android.content.Context;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 17/1/3
 * update time:
 * email: 723526676@qq.com
 */

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 这里实现SDK初始化，appId, 是否为debug模式(是否打印日志)
        // TODO: 17/2/7 替换appId
        Bugly.init(this, "9527lzsb", true);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // 安装tinker
        Beta.installTinker();
    }
}
