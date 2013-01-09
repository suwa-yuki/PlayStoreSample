package jp.classmethod.android.sample.playstore;

import java.util.ArrayList;

/**
 * ページのアイテム.
 */
public class PageItem {
    
    /** GridView の Fragment の Id. */
    public static final int GRID = 0;
    /** RelativeLayout の Fragment の Id. */
    public static final int RELATIVE = 1;
    
    /** ページ名. */
    public String title;
    /** Fragment の種類. */
    public int fragmentKind;
    /** アプリケーションのリスト. */
    public ArrayList<App> appList;

}
