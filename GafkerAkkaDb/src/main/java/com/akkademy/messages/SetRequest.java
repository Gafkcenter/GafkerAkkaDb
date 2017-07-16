package com.akkademy.messages;


/**
 * Created by gafker on 2017/7/16.
 * 消息传递的数据
 */
public class SetRequest {
private final String key;
    private final Object value;

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public SetRequest(String key, Object value) {

        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SetRequest{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}

