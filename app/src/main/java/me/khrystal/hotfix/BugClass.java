package me.khrystal.hotfix;

/**
 * usage: 测试bug类
 * author: kHRYSTAL
 * create time: 17/1/3
 * update time:
 * email: 723526676@qq.com
 */

public class BugClass {

    public String bug() {
        // 这段代码会报空指针
        String str = null;
       int length = str.length();
        return "This is a bug class";
    }
}
