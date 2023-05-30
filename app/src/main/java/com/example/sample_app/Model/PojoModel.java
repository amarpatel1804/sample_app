package com.example.sample_app.Model; ;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


@Generated("jsonschema2pojo")
public class PojoModel {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("detail")
    @Expose
    private List<Detail> detail;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }

    public class Data {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("mobilenumber")
        @Expose
        private Long mobilenumber;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getMobilenumber() {
            return mobilenumber;
        }

        public void setMobilenumber(Long mobilenumber) {
            this.mobilenumber = mobilenumber;
        }

        ArrayList<Detail> detailArrayList;

        public ArrayList<Detail> getDetailArrayList() {
            return detailArrayList;
        }

        public void setDetailArrayList(ArrayList<Detail> detailArrayList) {
            this.detailArrayList = detailArrayList;
        }
    }

    public class Detail {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}