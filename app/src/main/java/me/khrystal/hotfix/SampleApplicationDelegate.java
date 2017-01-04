package me.khrystal.hotfix;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.tinker.loader.app.DefaultApplicationLike;

/**
 * usage: 注意：这个类是Application的代理类，
 * 以前所有在Application的实现必须要全部拷贝到这里<br/>
 * author: kHRYSTAL
 * create time: 17/1/3
 * update time:
 * email: 723526676@qq.com
 */

public class SampleApplicationDelegate extends DefaultApplicationLike {

    public static final String TAG = SampleApplicationDelegate.class.getCanonicalName();

    public SampleApplicationDelegate(Application application,
                                     int tinkerFlags,
                                     boolean tinkerLoadVerifyFlag,
                                     long applicationStartElapsedTime,
                                     long applicationStartMillisTime,
                                     Intent tinkerResultIntent,
                                     Resources[] resources,
                                     ClassLoader[] classLoader,
                                     AssetManager[] assetManager) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag,
                applicationStartElapsedTime, applicationStartMillisTime,
                tinkerResultIntent, resources, classLoader, assetManager);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Bugly.setIsDevelopmentDevice(getApplication(), true);
        // 这里实现SDK 初始化 appId替换成在Bugly 平台申请的appId
        // TODO: 17/1/3  need replace appId
        Bugly.init(getApplication(), "e7a2e43b67", true);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        // TODO : 安装tinker
        Beta.installTinker(this);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks) {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }
}
