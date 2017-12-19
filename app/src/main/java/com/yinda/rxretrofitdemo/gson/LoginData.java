package com.yinda.rxretrofitdemo.gson;

import java.util.List;

/**
 * Created by ChenXuanHe on 2017/12/18.
 */

public class LoginData {


    /**
     * head : {"status":1,"info":""}
     * data : [{"username":"测试","company":"网络找茬","userid":"869915023793061"}]
     */

    private HeadBean head;
    private List<DataBean> data;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class HeadBean {
        /**
         * status : 1
         * info :
         */

        private int status;
        private String info;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return "HeadBean{" +
                    "status=" + status +
                    ", info='" + info + '\'' +
                    '}';
        }
    }

    public static class DataBean {
        /**
         * username : 测试
         * company : 网络找茬
         * userid : 869915023793061
         */

        private String username;
        private String company;
        private String userid;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "username='" + username + '\'' +
                    ", company='" + company + '\'' +
                    ", userid='" + userid + '\'' +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "LoginData{" +
                "head=" + head +
                ", data=" + data +
                '}';
    }
}
