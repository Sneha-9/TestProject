package com.sneha.jobScheduler;

//MR. NIKHIL SONI COMMENT: RENAME
public class MachineRegistry {

    private String id;
    private int memorySupported;
    private String status;
    private String url;

    MachineRegistry(String id, int memorySupported, String status, String url) {
       this.id = id;
       this.memorySupported = memorySupported;
       this.status = status;
       this.url = url;
    }

    public String getId() {
        return id;
    }

    public int getMemorySupported() {
        return memorySupported;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }
}
