package com.fastaccess.data.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.siimkinks.sqlitemagic.annotation.Column;
import com.siimkinks.sqlitemagic.annotation.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Kosh on 13 Dec 2016, 12:33 AM
 */

@Getter @Setter @NoArgsConstructor @Table(persistAll = true)
public class RenameModel implements Parcelable {
    @SerializedName("from") @Column String fromValue;
    @SerializedName("to") @Column String toValue;

    public long getId() {
        return id;
    }

    @Override public int describeContents() { return 0; }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fromValue);
        dest.writeString(this.toValue);
        dest.writeLong(this.id);
    }

    protected RenameModel(Parcel in) {
        this.fromValue = in.readString();
        this.toValue = in.readString();
        this.id = in.readLong();
    }

    public static final Creator<RenameModel> CREATOR = new Creator<RenameModel>() {
        @Override public RenameModel createFromParcel(Parcel source) {return new RenameModel(source);}

        @Override public RenameModel[] newArray(int size) {return new RenameModel[size];}
    };
}
