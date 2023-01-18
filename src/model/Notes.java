package model;


import java.util.Date;

public class Notes {
    private String id = "";
    private Date date = new Date();
    private String topic;
    private String text;

    public Notes(Date date, String topic, String text) {
        this.date = date;
        this.topic = topic;
        this.text = text;
    }

    public Notes(String id, Date date, String topic, String text) {
        this(date, topic, text);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("ID: %s\nДата: %s\nТема записи: %s\nТекст записи: %s\n", id, date, topic, text);
    }
}
