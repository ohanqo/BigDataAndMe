package ca.uqac.bigdataetmoi.database.data;

/**
 * Created by jul_samson on 17-11-17.
 */

public class UsageData
{
    public static final String DATA_ID = "usagedata";

    private String mPackageName;
    private long mTimeAppBegin;
    private long mTimeAppEnd;

    public UsageData() {}

    public UsageData(String packageName, long appBegin, long appEnd) {
        mPackageName = packageName;
        mTimeAppBegin = appBegin;
        mTimeAppEnd = appEnd;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public void setPackageName(String packageName) {
        this.mPackageName = packageName;
    }

    public long getTimeAppBegin() {
        return mTimeAppBegin;
    }

    public void setTimeAppBegin(long timeAppBegin) {
        this.mTimeAppBegin = timeAppBegin;
    }

    public long getTimeAppEnd() {
        return mTimeAppEnd;
    }

    public void setTimeAppEnd(long timeAppEnd) {
        this.mTimeAppEnd = timeAppEnd;
    }
}
