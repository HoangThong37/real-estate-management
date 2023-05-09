package com.laptrinhjavaweb.buider;

import java.util.List;

public class BuildingSearchBuilder {
    private String name;
    private Integer floorArea;  // diện tích sàn
    private String district;   // quận
    private String ward;
    private String street;
    private Integer numberOfBasement;
    private String direction;      // hướng
    private String level;          //  hạng
    private Integer rentAreaFrom;  // diện tích thuê từ
    private Integer rentAreaTo;    // diện tích thuê đến
    private Integer rentPriceFrom; // giá thuê từ
    private Integer rentPriceTo;   // giá thuê đến
    private String managerName;
    private Integer managerPhone;
    private Integer staffID;       // chọn nhân viên phụ trách
    private List<String> types;    // chọn loại tòa nhà mong muốn

    public String getName() {
        return name;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public Integer getRentAreaFrom() {
        return rentAreaFrom;
    }

    public Integer getRentAreaTo() {
        return rentAreaTo;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public String getManagerName() {
        return managerName;
    }

    public Integer getManagerPhone() {
        return managerPhone;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public List<String> getTypes() {
        return types;
    }

    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floorArea = builder.floorArea;
        this.district = builder.district;
        this.ward = builder.ward;
        this.street = builder.street;
        this.numberOfBasement = builder.numberOfBasement;
        this.direction = builder.direction;
        this.level = builder.level;
        this.rentAreaFrom = builder.rentAreaFrom;
        this.rentAreaTo = builder.rentAreaTo;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.managerName = builder.managerName;
        this.managerPhone = builder.managerPhone;
        this.staffID = builder.staffID;
        this.types = builder.types;
    }

    public static final class Builder {
        private String name;
        private Integer floorArea;
        private String district;
        private String ward;
        private String street;
        private Integer numberOfBasement;
        private String direction;
        private String level;
        private Integer rentAreaFrom;
        private Integer rentAreaTo;
        private Integer rentPriceFrom;
        private Integer rentPriceTo;
        private String managerName;
        private Integer managerPhone;
        private Integer staffID;
        private List<String> types;



        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }



        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }



        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }



        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }



        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }



        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }



        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }



        public Builder setRentAreaFrom(Integer rentAreaFrom) {
            this.rentAreaFrom = rentAreaFrom;
            return this;
        }



        public Builder setRentAreaTo(Integer rentAreaTo) {
            this.rentAreaTo = rentAreaTo;
            return this;
        }



        public Builder setRentPriceFrom(Integer rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }



        public Builder setRentPriceTo(Integer rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }



        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }



        public Builder setManagerPhone(Integer managerPhone) {
            this.managerPhone = managerPhone;
            return this;
        }



        public Builder setStaffID(Integer staffID) {
            this.staffID = staffID;
            return this;
        }



        public Builder setTypes(List<String> types) {
            this.types = types;
            return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }

}
