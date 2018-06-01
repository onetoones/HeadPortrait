package com.example.headportrait.base;

/**
 * @Creation date
 * @name
 * @Class action
 */

public class UserBean {

    /**
     * msg : 获取用户信息成功
     * code : 0
     * data : {"age":null,"appkey":"38d950cb716c4dd2","appsecret":"F22E08CD3B8FD6E2E2FD471FE46103F8","createtime":"2018-05-31T09:06:25","email":null,"fans":0,"follow":0,"gender":null,"icon":"https://www.zhaoapi.cn/images/1527729157692head_icon.jpg","latitude":null,"longitude":null,"mobile":"18312345678","money":null,"nickname":"","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"AD81803C4AAAD275F7BAA4AA864B7A3E","uid":3402,"userId":null,"username":"18312345678"}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : 38d950cb716c4dd2
         * appsecret : F22E08CD3B8FD6E2E2FD471FE46103F8
         * createtime : 2018-05-31T09:06:25
         * email : null
         * fans : 0
         * follow : 0
         * gender : null
         * icon : https://www.zhaoapi.cn/images/1527729157692head_icon.jpg
         * latitude : null
         * longitude : null
         * mobile : 18312345678
         * money : null
         * nickname :
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * praiseNum : null
         * token : AD81803C4AAAD275F7BAA4AA864B7A3E
         * uid : 3402
         * userId : null
         * username : 18312345678
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private int fans;
        private int follow;
        private Object gender;
        private String icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
