
package com.example.week4test.model.startup;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StartupResponse implements Parcelable
{

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;
    public final static Creator<StartupResponse> CREATOR = new Creator<StartupResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public StartupResponse createFromParcel(Parcel in) {
            return new StartupResponse(in);
        }

        public StartupResponse[] newArray(int size) {
            return (new StartupResponse[size]);
        }

    }
    ;

    protected StartupResponse(Parcel in) {
        this.photos = ((Photos) in.readValue((Photos.class.getClassLoader())));
        this.stat = ((String) in.readValue((String.class.getClassLoader())));
    }

    public StartupResponse() {
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(photos);
        dest.writeValue(stat);
    }

    public int describeContents() {
        return  0;
    }

}
