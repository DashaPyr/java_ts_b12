package dd.pyrkova.rest.appmeneger;

import java.util.Objects;

public class Issue {
  private int id;
  private String subject;
  private String description;
  private String status;

  public int getId() {
    return id;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }

  public String getStatus() {
    return status;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public Issue withStatus(String state_name) {
    this.status = state_name;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Issue issue = (Issue) o;
    return id == issue.id &&
            Objects.equals(subject, issue.subject) &&
            Objects.equals(description, issue.description) &&
            Objects.equals(status, issue.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subject, description, status);
  }

  @Override
  public String toString() {
    return "Issue{" +
            "id=" + id +
            ", subject='" + subject + '\'' +
            ", description='" + description + '\'' +
            ", status='" + status + '\'' +
            '}';
  }


}
