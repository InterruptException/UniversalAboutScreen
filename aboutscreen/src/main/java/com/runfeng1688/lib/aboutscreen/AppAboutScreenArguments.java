package com.runfeng1688.lib.aboutscreen;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class AppAboutScreenArguments implements Parcelable {
    final String versionNumber;
    final String icpNumber;
    final String icpLink;
    final String privacyLink;
    final String websiteLink;
    final String appName;

    final @DrawableRes Integer logoResId;

    public AppAboutScreenArguments(String appName,
                                   String versionNumber,
                                   String icpNumber,
                                   String icpLink,
                                   String privacyLink,
                                   String websiteLink,
                                   @DrawableRes Integer logoResId
    ) {
        this.appName = appName;
        this.versionNumber = versionNumber;
        this.icpNumber = icpNumber;
        this.icpLink = icpLink;
        this.privacyLink = privacyLink;
        this.websiteLink = websiteLink;
        this.logoResId = logoResId;
    }

    protected AppAboutScreenArguments(Parcel in) {
        versionNumber = in.readString();
        icpNumber = in.readString();
        icpLink = in.readString();
        privacyLink = in.readString();
        websiteLink = in.readString();
        appName = in.readString();
        if (in.readByte() == 0) {
            logoResId = null;
        } else {
            logoResId = in.readInt();
        }
    }

    public static final Creator<AppAboutScreenArguments> CREATOR = new Creator<AppAboutScreenArguments>() {
        @Override
        public AppAboutScreenArguments createFromParcel(Parcel in) {
            return new AppAboutScreenArguments(in);
        }

        @Override
        public AppAboutScreenArguments[] newArray(int size) {
            return new AppAboutScreenArguments[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(versionNumber);
        dest.writeString(icpNumber);
        dest.writeString(icpLink);
        dest.writeString(privacyLink);
        dest.writeString(websiteLink);
        dest.writeString(appName);
        if (logoResId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(logoResId);
        }
    }
}
