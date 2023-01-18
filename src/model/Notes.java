package model;

public class Notes {
    private String id = "";
    private String data;
    private String topic;
    private String text;

    public Notes(String topic, String text) {
        this.topic = topic;
        this.text = text;
    }

    public Notes(String id, String data, String topic, String text) {
        this(topic, text);
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        return String.format("ID: %s\nДата: %s\nТема записи: %s\nТекст записи: %s\n",id,data,topic,text);
    }
}
