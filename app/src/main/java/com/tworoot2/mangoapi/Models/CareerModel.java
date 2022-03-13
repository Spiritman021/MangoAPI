package com.tworoot2.mangoapi.Models;

public class CareerModel {


    private Integer id;
    private String title;
    private String careerImage;
    private String videoUrl;
    private String timestamp;
    private String utimestamp;
    private String track;
    private String utrack;
    private String status;
    private String career;

    private CareerDetail careerDetail;

    public CareerDetail getCareerDetail() {
        return careerDetail;
    }

    public void setCareerDetail(CareerDetail careerDetail) {
        this.careerDetail = careerDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCareerImage() {
        return careerImage;
    }

    public void setCareerImage(String careerImage) {
        this.careerImage = careerImage;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUtimestamp() {
        return utimestamp;
    }

    public void setUtimestamp(String utimestamp) {
        this.utimestamp = utimestamp;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getUtrack() {
        return utrack;
    }

    public void setUtrack(String utrack) {
        this.utrack = utrack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }


    public static class CareerDetail {

        String title;
        String slug;
        String careerImage;
        String image_url;
        String image_url2;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getCareerImage() {
            return careerImage;
        }

        public void setCareerImage(String careerImage) {
            this.careerImage = careerImage;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImage_url2() {
            return image_url2;
        }

        public void setImage_url2(String image_url2) {
            this.image_url2 = image_url2;
        }
    }
}





