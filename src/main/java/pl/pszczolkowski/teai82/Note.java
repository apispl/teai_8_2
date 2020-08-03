package pl.pszczolkowski.teai82;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Note {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;
    String text;
    Date creationDate;
    Date editingDate;

    public Note() {
    }

    public Note(String text, Date creationDate, Date editingDate) {
        this.text = text;
        this.creationDate = creationDate;
        this.editingDate = editingDate;
    }

    public Note(long id, String text, Date creationDate, Date editingDate) {
        this.id = id;
        this.text = text;
        this.creationDate = creationDate;
        this.editingDate = editingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEditingDate() {
        return editingDate;
    }

    public void setEditingDate(Date editingDate) {
        this.editingDate = editingDate;
    }
}
