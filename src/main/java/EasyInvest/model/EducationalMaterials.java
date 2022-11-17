package EasyInvest.model;

import java.util.Date;


public class EducationalMaterials {
  protected int materialId;
  protected String title;
  protected String content;
  protected Date created;
  protected boolean published;
  protected Admin user;

  public EducationalMaterials(int materialId, String title, String content, Date created,
      boolean published, Admin user) {
    this.materialId = materialId;
    this.title = title;
    this.content = content;
    this.created = created;
    this.published = published;
    this.user = user;
  }

  public int getMaterialId() {
    return materialId;
  }

  public void setMaterialId(int materialId) {
    this.materialId = materialId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  public Admin getUser() {
    return user;
  }

  public void setUser(Admin user) {
    this.user = user;
  }
}