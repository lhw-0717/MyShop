package com.example.myshop.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginBean implements Parcelable {
    /**
     * errno : 0
     * errmsg :
     * data : {"code":200,"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoicTg0NjYxbmZhaCIsImlhdCI6MTYwOTc0MTAzM30.yqiSNxnP8wvr_0Ntw20dKXl3WfcBdXhMr8T6dh-PomE","userInfo":{"uid":"7b965656-70eb-4726-b4a7-c52366861485","username":"z1234","nickname":"21312312","gender":0,"avatar":"http://2002a-zwx.oss-cn-beijing.aliyuncs.com/7b965656-70eb-4726-b4a7-c52366861485/16096606300755698.701909599277.png","birthday":110022}}
     */

    private int errno;
    private String errmsg;
    /**
     * code : 200
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoicTg0NjYxbmZhaCIsImlhdCI6MTYwOTc0MTAzM30.yqiSNxnP8wvr_0Ntw20dKXl3WfcBdXhMr8T6dh-PomE
     * userInfo : {"uid":"7b965656-70eb-4726-b4a7-c52366861485","username":"z1234","nickname":"21312312","gender":0,"avatar":"http://2002a-zwx.oss-cn-beijing.aliyuncs.com/7b965656-70eb-4726-b4a7-c52366861485/16096606300755698.701909599277.png","birthday":110022}
     */

    private DataBean data;

    protected LoginBean(Parcel in) {
        errno = in.readInt();
        errmsg = in.readString();
    }

    public static final Creator<LoginBean> CREATOR = new Creator<LoginBean>() {
        @Override
        public LoginBean createFromParcel(Parcel in) {
            return new LoginBean(in);
        }

        @Override
        public LoginBean[] newArray(int size) {
            return new LoginBean[size];
        }
    };

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(errno);
        dest.writeString(errmsg);
    }

    public static class DataBean implements Parcelable{
        private int code;
        private String token;
        /**
         * uid : 7b965656-70eb-4726-b4a7-c52366861485
         * username : z1234
         * nickname : 21312312
         * gender : 0
         * avatar : http://2002a-zwx.oss-cn-beijing.aliyuncs.com/7b965656-70eb-4726-b4a7-c52366861485/16096606300755698.701909599277.png
         * birthday : 110022
         */

        private UserInfoBean userInfo;

        protected DataBean(Parcel in) {
            code = in.readInt();
            token = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(code);
            dest.writeString(token);
        }

        public static class UserInfoBean implements Parcelable{
            private String uid;
            private String username;
            private String nickname;
            private int gender;
            private String avatar;
            private int birthday;

            protected UserInfoBean(Parcel in) {
                uid = in.readString();
                username = in.readString();
                nickname = in.readString();
                gender = in.readInt();
                avatar = in.readString();
                birthday = in.readInt();
            }

            public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
                @Override
                public UserInfoBean createFromParcel(Parcel in) {
                    return new UserInfoBean(in);
                }

                @Override
                public UserInfoBean[] newArray(int size) {
                    return new UserInfoBean[size];
                }
            };

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getBirthday() {
                return birthday;
            }

            public void setBirthday(int birthday) {
                this.birthday = birthday;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(uid);
                dest.writeString(username);
                dest.writeString(nickname);
                dest.writeInt(gender);
                dest.writeString(avatar);
                dest.writeInt(birthday);
            }
        }
    }
}
