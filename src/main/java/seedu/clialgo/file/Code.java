package seedu.clialgo.file;

public class Code extends File {

    public Code(String name, String path, String topic) {
        this.name = name;
        this.path = path;
        this.topic = topic;
        this.type = "CODE";
    }
    public Code(String name, String path, String topic, int importance) {
        this.name = name;
        this.path = path;
        this.topic = topic;
        this.importance = importance;
        this.type = "CODE";
    }
}
