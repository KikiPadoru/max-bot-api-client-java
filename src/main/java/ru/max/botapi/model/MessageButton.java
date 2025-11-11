package ru.max.botapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Кнопка сообщение(самоделка).
 */
public class MessageButton extends Button implements MaxSerializable {


  @JsonCreator
  public MessageButton(@JsonProperty("text") String text) {
    super(text);
  }

  @Override
  public void visit(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public <T> T map(Mapper<T> mapper) {
    return mapper.map(this);
  }

  @JsonProperty("type")
  @Override
  public String getType() {
    return Button.MESSAGE;
  }

  @Override
  public String toString() {
    return "MessageButton{"+ super.toString()
        + '}';
  }
}