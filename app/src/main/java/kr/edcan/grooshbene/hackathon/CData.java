package kr.edcan.grooshbene.hackathon;

import android.content.Context;

/**
 * Created by grooshbene on 15. 7. 20.
 */
public class CData {
    public String content_label;
    public String description;
    public String phone;

    public CData(Context context, String content_label_, String description_, String phone_) {
        content_label = content_label_;
        description = description_;
        phone = phone_;
    }


    public String getContent_label() {
        return content_label;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

}
