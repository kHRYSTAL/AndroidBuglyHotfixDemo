package me.khrystal.hotfix;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 17/1/3
 * update time:
 * email: 723526676@qq.com
 */

public class SampleApplication extends TinkerApplication {

    /**
     * 参数1：int tinkerFlags 表示Tinker支持的类型 dex only、library only or all suuport，default: TINKER_ENABLE_ALL
     * 参数2：String delegateClassName Application代理类 这里填写你自定义的ApplicationLike
     * 参数3：String loaderClassName  Tinker的加载器，使用默认即可
     * 参数4：boolean tinkerLoadVerifyFlag  加载dex或者lib是否验证md5，默认为false
     */
    public SampleApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL,
                "me.khrystal.hotfix.SampleApplicationDelegate",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
