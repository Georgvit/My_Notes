package model;


public class Notes {
    //    id записи
    private String id = "";
    //    Дата создания записи
    private String date;
    //    Заголовок записи
    private String topic;
    //    Текст записи
    private String text;

    public void setDate(String date) {
        this.date = date;
    }

    public Notes(String date, String topic, String text) {
        this.date = date;
        this.topic = topic;
        this.text = text;
    }

    public Notes(String id, String date, String topic, String text) {
        this(date, topic, text);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
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
