package mjxm.pojo;

import java.util.Date;

public class Record {
    private Integer recordId;

    private Date time;

    private Integer userId;

    private Integer requirementId;

    public Record(Integer recordId, Date time, Integer userId, Integer requirementId) {
        this.recordId = recordId;
        this.time = time;
        this.userId = userId;
        this.requirementId = requirementId;
    }

    public Record() {
        super();
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }
}