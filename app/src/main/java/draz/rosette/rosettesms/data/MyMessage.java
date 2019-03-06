package draz.rosette.rosettesms.data;

public class MyMessage {
    private String key;// key: unique id for each object. have to be....
    private String toTitle;
    private String onTitle;

    public String getToTitle() {
        return toTitle;
    }

    public void setToTitle(String toTitle) {
        this.toTitle = toTitle;
    }

    public String getOnTitle() {
        return onTitle;
    }

    public void setOnTitle(String onTitle) {
        this.onTitle = onTitle;
    }

    private String message;
    private String reciver;
    private String app;
    private String time;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public MyMessage(String key, String message, String reciver, String app, String time) {
        this.key = key;
        this.message = message;
        this.reciver = reciver;
        this.app = app;
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "key='" + key + '\'' +
                ", message='" + message + '\'' +
                ", reciver='" + reciver + '\'' +
                ", app='" + app + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

}
