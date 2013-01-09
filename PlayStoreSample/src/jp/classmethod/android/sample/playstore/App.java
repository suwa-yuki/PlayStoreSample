package jp.classmethod.android.sample.playstore;

import java.io.Serializable;

/**
 * アプリケーション情報.
 */
public class App implements Serializable {

    /** シリアルバージョン. */
    private static final long serialVersionUID = -8730067026050196758L;

    /** アプリ名. */
    public String title;
    /** 詳細情報. */
    public String description;
    /** 制作会社. */
    public String company;
    /** 評価. */
    public float rate;
    /** 価格. */
    public int value;

}
