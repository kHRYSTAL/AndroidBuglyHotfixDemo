package me.khrystal.hotfix;

/**
 * usage: 加载bug的类
 * author: kHRYSTAL
 * create time: 17/1/3
 * update time:
 * email: 723526676@qq.com
 */

public class LoadBugClass {

    /**
     * 获取bug的字符串
     * @return
     */
    public static String getBugString() {
        BugClass bugClass = new BugClass();
        return bugClass.bug();
    }
}
