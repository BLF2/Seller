package net.blf2.entity;

import java.util.Date;

/**
 * Created by blf2 on 17-6-24.
 */
public class ReponsityIo {
    private String reponsityNum;//存储
    private String materialsName;//材料名称
    private String materialsOp;//材料操作：input or output
    private String measurementUnit;//计量单位
    private Double pricePerUnit;//单价
    private Double measurementNum;//数量
    private Double totalCost;//总价值
    private String currentAdminId;//当前库管员
    private String currentAdminName;//当前库管员名字
    private String ioPersonId;//送货或取货人Id
    private String ioPersonName;//送货或取货人名字
    private String operateDateTime;//操作时间


    public String getReponsityNum() {
        return reponsityNum;
    }

    public void setReponsityNum(String reponsityNum) {
        this.reponsityNum = reponsityNum;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }

    public String getMaterialsOp() {
        return materialsOp;
    }

    public void setMaterialsOp(String materialsOp) {
        this.materialsOp = materialsOp;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCurrentAdminId() {
        return currentAdminId;
    }

    public void setCurrentAdminId(String currentAdminId) {
        this.currentAdminId = currentAdminId;
    }

    public String getCurrentAdminName() {
        return currentAdminName;
    }

    public void setCurrentAdminName(String currentAdminName) {
        this.currentAdminName = currentAdminName;
    }

    public String getIoPersonId() {
        return ioPersonId;
    }

    public void setIoPersonId(String ioPersonId) {
        this.ioPersonId = ioPersonId;
    }

    public String getIoPersonName() {
        return ioPersonName;
    }

    public void setIoPersonName(String ioPersonName) {
        this.ioPersonName = ioPersonName;
    }

    public String getOperateDateTime() {
        return operateDateTime;
    }

    public void setOperateDateTime(String operateDateTime) {
        this.operateDateTime = operateDateTime;
    }

    public Double getMeasurementNum() {
        return measurementNum;
    }

    public void setMeasurementNum(Double measurementNum) {
        this.measurementNum = measurementNum;
    }

    @Override
    public String toString() {
        return "ReponsityIo{" +
                "reponsityNum='" + reponsityNum + '\'' +
                ", materialsName='" + materialsName + '\'' +
                ", materialsOp='" + materialsOp + '\'' +
                ", measurementUnit='" + measurementUnit + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", measurementNum=" + measurementNum +
                ", totalCost=" + totalCost +
                ", currentAdminId='" + currentAdminId + '\'' +
                ", currentAdminName='" + currentAdminName + '\'' +
                ", ioPersonId='" + ioPersonId + '\'' +
                ", ioPersonName='" + ioPersonName + '\'' +
                ", operateDateTime='" + operateDateTime + '\'' +
                '}';
    }
}
