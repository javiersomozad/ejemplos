package es.anaya.spring.data.s03.mongodbembed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document
public class Note {
  @Id
  private ObjectId _id;
  private String text;
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date date;
  private Author author;
  private List<Change> changes = new ArrayList<Change>();
  
  public Note () {}
  
  
 public Note(String text) {
  this.text = text;
  date = new Date();
 }


 public ObjectId get_id() {
  return _id;
 }
 public void set_id(ObjectId _id) {
  this._id = _id;
 }
 public String getText() {
  return text;
 }
 public void setText(String text) {
  this.text = text;
 }
 public Date getDate() {
  return date;
 }
 public void setDate(Date date) {
  this.date = date;
 }


public Author getAuthor() {
	return author;
}


	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	public List<Change> getChanges() {
		return changes;
	}
	
	
	public void setChanges(List<Change> changes) {
		this.changes = changes;
	}


	@Override
	public String toString() {
		return "\nNote [_id=" + _id + ", text=" + text + ", date=" + date + ", " + author + ", \n\tchanges=" + changes
				+ "]";
	}
	



 
}
