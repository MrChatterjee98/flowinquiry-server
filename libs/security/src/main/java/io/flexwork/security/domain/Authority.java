package io.flexwork.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Objects;

/** A Authority. */
@Entity
@Table(name = "fw_authority")
@JsonIgnoreProperties(value = {"new", "id"})
@Data
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Authority implements Serializable, Persistable<String> {

  private static final long serialVersionUID = 1L;

  @NotNull
  @Size(max = 50)
  @Id
  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Transient private boolean isPersisted;

  public Authority name(String name) {
    this.setName(name);
    return this;
  }

  @PostLoad
  @PostPersist
  public void updateEntityState() {
    this.setIsPersisted();
  }

  @Override
  public String getId() {
    return this.name;
  }

  @Transient
  @Override
  public boolean isNew() {
    return !this.isPersisted;
  }

  public Authority setIsPersisted() {
    this.isPersisted = true;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Authority)) {
      return false;
    }
    return getName() != null && getName().equals(((Authority) o).getName());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getName());
  }

}
